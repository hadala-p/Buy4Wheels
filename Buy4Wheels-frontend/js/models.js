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
    "model": document.getElementById("template-model")
}

const modelList = document.getElementById("model-list");


let sessionInfoUpdateTimeout = undefined;
const pageSize = 10;
let modelPage = 0;
let brands = [];
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
    getModels: (page, pageSize) => {
        return request("GET", SERVICES.CAR, `/models`, null)
    },
    deleteModel: (id) => {
        return request("DELETE", SERVICES.CAR, `/models/${id}`, null)
    },
    addModel: (model) => {
        return request("POST", SERVICES.CAR, `/models`, model).then(response => response.body)
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

function appendModels(models) {
    models.forEach(appendSingleModel);
}

function appendSingleModel(model) {
    let modelElement = initTemplate(TAMEPLATES.model, model);
    modelList.appendChild(modelElement);
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
function removeModel(button) {
    let idToDelete = extractButtonId(button);
    console.log(`Remove Model id: ${idToDelete}`);
    API.deleteModel(idToDelete)
        .then(() =>
            document.querySelector(`.model[entity-id='${idToDelete}']`)
                .remove()
        );
}


function loadMore() {
    API.getModels(modelPage, pageSize)
        .then(x => x.body.models)
        .then(appendModels);


    modelPage++;
}

function loadBrands() {
    API.getBrands().then(brandList => {
        brands = brandList;
        updateBrandSelect();
    });
}

function updateBrandSelect() {
    let select = document.getElementById("new-model-brand");
    select.innerHTML = "";
    brands.forEach(brand => {
        let option = document.createElement("option");
        option.value = brand.id;
        option.text = brand.name;
        option.innerText = `${brand.id} (${brand.name})`;
        select.appendChild(option);
    });

}

function addModel() {
    let modelNewModelName = document.getElementById("new-model-name").value;
    let modelNewModelBrand = parseInt(document.getElementById("new-model-brand").value, 10);
    let modelNewModelDescription = document.getElementById("new-model-description").value;


    if (modelNewModelName == undefined
        || modelNewModelBrand == undefined
        || modelNewModelDescription == undefined) {
        return;
    }

    let body = {
        name: modelNewModelName,
        brandId: modelNewModelBrand,
        description: modelNewModelDescription,
    };
    console.log("Add Model", body);
    API.login();
    API.addModel(body).then(appendSingleModel)

    document.getElementById("new-model-name").value = "";
    document.getElementById("new-model-brand").value = "";
    document.getElementById("new-model-description").value = "";
}


function main() {
    updateSessionInfo();
}

main();