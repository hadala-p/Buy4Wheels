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
    "brand": document.getElementById("template-brand")
}

const brandList = document.getElementById("brand-list");
let sessionInfoUpdateTimeout = undefined;
let firstLoadInitialized = false;

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
    getBrands: (page, pageSize) => {
        return request("GET", SERVICES.CAR, `/brands`, null)
    },
    addBrand: (brand) => {
        return request("POST", SERVICES.CAR, `/brands`, brand).then(response => response.body)
    },
    deleteBrand: (id) => {
        return request("DELETE", SERVICES.CAR, `/brands/${id}`, null)
    },
});


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
            if (!firstLoadInitialized) {
                firstLoadInitialized = true;
                loadBrands();
            }
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
function removeBrand(button) {
    let idToDelete = extractButtonId(button);
    console.log(`Remove Brand id: ${idToDelete}`);
    API.deleteBrand(idToDelete)
        .then(() =>
            document.querySelector(`.brand[entity-id='${idToDelete}']`).remove()
        );
}

function appendBrands(brands) {
    brands.forEach(appendSingleBrand);
}

function appendSingleBrand(brand) {
    let brandElement = initTemplate(TAMEPLATES.brand, brand);
    brandList.appendChild(brandElement);
}

function loadBrands() {
    API.getBrands()
        .then(x => x.body.brands)
        .then(appendBrands);
}

function addBrand() {
    let brandName = document.getElementById("new-brand-name").value;
    let brandCountry = document.getElementById("new-brand-country").value;
    let brandDescription = document.getElementById("new-brand-description").value;

    if (brandName == undefined
        || brandCountry == undefined
        || brandDescription == undefined) {
        return;
    }

    let body = {
        name: brandName,
        country: brandCountry,
        description: brandDescription,
    };

    API.addBrand(body).then(appendSingleBrand)

    document.getElementById("new-brand-name").value = "";
    document.getElementById("new-brand-country").value = "";
    document.getElementById("new-brand-description").value = "";
}


function main() {
    updateSessionInfo();
}

main();