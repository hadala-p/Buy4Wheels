const LS_KEY_TOKEN = "token";

const SERVICES = {
    AUTH: Symbol("AUTH"),
    CAR: Symbol("CAR"),
    OFFER: Symbol("OFFER"),
};

const URLS = {
    [SERVICES.AUTH]: "http://localhost:8000",
    [SERVICES.CAR]: "http://localhost:8010",
    [SERVICES.OFFER]: "http://localhost:8030"
};

const TAMEPLATES = {
    "offer": document.getElementById("template-offer")
}

const offerList = document.getElementById("offer-list");


let sessionInfoUpdateTimeout = undefined;
const pageSize = 10;
let offerPage = 0;
let brands = [];
let models = [];
let firstDraw = true;


function getToken() {
    return localStorage.getItem(LS_KEY_TOKEN);
}

function updateToken(token) {
    console.log("Update Token");
    debugPrintToken(token);
    localStorage.setItem(LS_KEY_TOKEN, token);
}

/**
 * @param {string} token
 */
function debugPrintToken(token) {
    let parts = token.split(".");
    let header = JSON.parse(atob(parts[0]));
    let payload = JSON.parse(atob(parts[1]));
    console.log("token", {header, payload});
}

/**
 * @typedef {object} Response
 * @property {number} status
 * @property {object} body
 */


/**
 * @param {string} method
 * @param {"AUTH"|"CAR"|"OFFER"} service
 * @param {string} path
 * @param {object|string|undefined} body
 * @returns {Future<Response>}
 */
function request(method, service, path, body) {
    if (!(service in URLS)) {
        throw new Error("illegal enum value")
    }
    let URL = URLS[service];
    let joinedPath = URL + (path.startsWith("/") ? "" : "/") + path;
    let requestBody;
    if (body == undefined) requestBody = undefined;
    else if (typeof (body) === "string") requestBody = body;
    else requestBody = JSON.stringify(body);

    return fetch(joinedPath, {
        method,
        headers: {
            "content-type": "application/json",
            "Authorization": getToken() ?? ""
        },
        credentials: "omit",
        body: requestBody
    })
        .then(parseFetchResponse);
}

async function parseFetchResponse(response) {
    try {
        if (response.status === 204) return {status: response.status, body: {}};
        let body = await response.json();
        let responseObject = {
            status: response.status,
            body
        };
        if (response.status < 100 || response.status > 399) {
            throw responseObject;
        }
        return responseObject;
    } catch (_) {
        throw new Error("not json");
    }
}

API = Object.freeze({
    login: () => {
        return request("GET", SERVICES.AUTH, "/token", null).then(r => updateToken(r.body.token));
    },
    getOffers: (page, pageSize) => {
        return request("GET", SERVICES.OFFER, `/offers`, null)
    },
    deleteOffer: (id) => {
        return request("DELETE", SERVICES.OFFER, `/offers/${id}`, null)
    },
    addOffer: (offer) => {
        return request("POST", SERVICES.OFFER, `/offers`, offer).then(response => response.body)
    },
    getModels: () => {
        return request("GET", SERVICES.CAR, "/models", null).then(response => response.body.models);
    },
    getBrands: () => {
        return request("GET", SERVICES.CAR, "/brands", null).then(response => response.body.brands);
    }
});

function drawFirstTime() {
    if (!firstDraw) {
        return;
    }
    firstDraw = false;
    loadBrands()
    loadModels()
    loadMore();
}


function updateSessionInfo() {
    let token = getToken();
    let sessionInfo = document.getElementById("session-info");
    if (token == undefined) {
        sessionInfo.innerText = "No session";
    } else {
        let parts = token.split(".");
        let payload = JSON.parse(atob(parts[1]));
        let expDate = payload.exp * 1000;
        let now = Date.now();
        let diff = (expDate - now) / 1000;
        if (diff < 0) {
            sessionInfo.innerText = "Session Expired";
        } else {
            drawFirstTime();
            let mins = Math.floor(diff / 60);
            let secs = Math.floor(diff % 60);
            sessionInfo.innerText = `Session expires in ${mins}:${secs}`;

            clearTimeout(sessionInfoUpdateTimeout);
            sessionInfoUpdateTimeout = setTimeout(updateSessionInfo, 1000);
        }
    }

}

function refreshSession() {
    API.login().then(updateSessionInfo);
}

/**
 *
 * @param {HTMLTemplateElement} template
 * @param {object} data
 */
function initTemplate(template, data) {
    /** @type {HTMLElement} */
    let element = template.content.firstElementChild.cloneNode(true);
    initTemplateFiels(element, data);
    return element;
}

function initTemplateFiels(element, data, prevKey = undefined) {
    let keys = Object.keys(data);

    // check for root element
    let key;
    if ((key = element.getAttribute("template-set-attr")) != undefined) {
        if (prevKey == undefined)
            element.setAttribute(`entity-${key}`, data[key]);
        else if (key.startsWith(prevKey))
            element.setAttribute(`entity-${key}`, data[key.substring(prevKey.length + 1)]);

    }
    if ((key = element.getAttribute("template-set")) != undefined) {
        if (prevKey == undefined)
            element.innerText = data[key];
        else if (key.startsWith(prevKey))
            element.innerText = data[key.substring(prevKey.length + 1)]
    }

    for (let key of keys) {
        let searchKey = prevKey == undefined ? key : `${prevKey}-${key}`;
        let value = data[key];
        if (typeof (value) === "object") {
            if (Array.isArray(value)) {
                value = value.join(", ");
            } else {
                initTemplateFiels(element, value, key);
            }
            continue;
        }

        element
            .querySelectorAll(`*[template-set=${searchKey}]`)
            .forEach(element => element.innerText = value);
        element
            .querySelectorAll(`*[template-set-attr=${searchKey}]`)
            .forEach(element => element.setAttribute(`entity-${searchKey}`, value));
    }
}

function appendOffers(offers) {
    offers.forEach(appendSingleOffer);
}

function appendSingleOffer(offer) {
    let offerElement = initTemplate(TAMEPLATES.offer, offer);
    offerList.appendChild(offerElement);
}


/**
 *
 * @param {HTMLButtonElement} button
 */
function extractButtonId(button) {
    return button.getAttribute("entity-id");
}

/**
 *
 * @param {HTMLButtonElement} button
 */
function removeOffer(button) {
    let idToDelete = extractButtonId(button);
    console.log(`Remove Offer id: ${idToDelete}`);
    API.deleteOffer(idToDelete)
        .then(() =>
            document.querySelector(`.offer[entity-id='${idToDelete}']`)
                .remove()
        );
}


function loadMore() {
    API.getOffers(offerPage, pageSize)
        .then(x => x.body.offers)
        .then(appendOffers);


    offerPage++;
}

function loadBrands() {
    API.getBrands().then(brandList => {
        brands = brandList;
        updateBrandSelect();
    });
}

function loadModels() {
    API.getModels().then(modelList => {
        models = modelList;
        updateModelSelect();
    });
}

function updateBrandSelect() {
    let select = document.getElementById("new-offer-brand");
    select.innerHTML = "";
    brands.forEach(brand => {
        let option = document.createElement("option");
        option.value = brand.id;
        option.text = brand.name;
        option.innerText = `${brand.id} (${brand.name})`;
        select.appendChild(option);
    });

}

function updateModelSelect() {
    let select = document.getElementById("new-offer-model");
    select.innerHTML = "";
    models.forEach(model => {
        let option = document.createElement("option");
        option.value = model.id;
        option.text = model.name;
        option.innerText = `${model.id} (${model.name})`;
        select.appendChild(option);
    });

}

function addOffer(string) {
    let offerNewOfferBrand = parseInt(document.getElementById("new-offer-brand").value, 10);
    let offerNewOfferModel = parseInt(document.getElementById("new-offer-model").value, 10);
    let offerNewOfferYear = parseInt(document.getElementById("new-offer-year").value, 10);
    let offerNewOfferMileage = parseInt(document.getElementById("new-offer-mileage").value, 10);
    let offerNewOfferFuelType = document.getElementById("new-offer-fuelType").value;
    let offerNewOfferTransmission = document.getElementById("new-offer-transmission").value;
    let offerNewOfferEnginePower = parseInt(document.getElementById("new-offer-enginePower").value, 10);
    let offerNewOfferColor = document.getElementById("new-offer-color").value;
    let offerNewOfferPrice = parseFloat(document.getElementById("new-offer-price").value, 10);
    let offerNewOfferDescription = document.getElementById("new-offer-description").value;
    let offerNewOfferAvailable = document.getElementById("new-offer-available").value === "on";


    if (offerNewOfferBrand == undefined
        || offerNewOfferModel == undefined
        || offerNewOfferYear == undefined
        || offerNewOfferMileage == undefined
        || offerNewOfferFuelType == undefined
        || offerNewOfferTransmission == undefined
        || offerNewOfferEnginePower == undefined
        || offerNewOfferColor == undefined
        || offerNewOfferPrice == undefined
        || offerNewOfferDescription == undefined
        || offerNewOfferAvailable == undefined) {
        return;
    }

    let body = {
        brandId: offerNewOfferBrand,
        modelId: offerNewOfferModel,
        year: offerNewOfferYear,
        mileage: offerNewOfferMileage,
        fuelType: offerNewOfferFuelType,
        transmission: offerNewOfferTransmission,
        enginePower: offerNewOfferEnginePower,
        color: offerNewOfferColor,
        price: offerNewOfferPrice,
        description: offerNewOfferDescription,
        available: offerNewOfferAvailable
    };
    console.log("Add Offer", body);
    API.login();
    API.addOffer(body).then(appendSingleOffer)

    document.getElementById("new-offer-model").value = "";
    document.getElementById("new-offer-brand").value = "";
    document.getElementById("new-offer-year").value = "";
    document.getElementById("new-offer-mileage").value = "";
    document.getElementById("new-offer-fuelType").value = "";
    document.getElementById("new-offer-transmission").value = "";
    document.getElementById("new-offer-enginePower").value = "";
    document.getElementById("new-offer-color").value = "";
    document.getElementById("new-offer-price").value = "";
    document.getElementById("new-offer-description").value = "";
    document.getElementById("new-offer-available").value = false;
}


function main() {
    updateSessionInfo();
}

main();