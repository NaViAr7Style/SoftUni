function attachEvents() {
  const baseURL = "http://localhost:3030/jsonstore/forecaster/locations";
  const buttonElement = document.getElementById("submit");
  const inputElement = document.getElementById("location");
  const forecasterElement = document.getElementById("forecast");
  const currentConditionsElement = document.getElementById("current");
  const upcomingForeCaster = document.getElementById("upcoming");
  buttonElement.addEventListener("click", loadWeather);
  let conditionObject = {
    Sunny: "&#x2600",
    "Partly sunny": "&#x26C5",
    Overcast: "&#x2601",
    Rain: "&#x2614",
  };

  async function loadWeather() {
    const response = await fetch(baseURL);
    const data = await response.json();
    let objectToGet = data.find((x) => x.name === inputElement.value);
    if (!objectToGet) {
      throw new Error();
    }
    forecasterElement.style.display = "block";
    //Current forecaster
    const currentForecasterURL =
      "http://localhost:3030/jsonstore/forecaster/today/";
    const threeDaysForecasterURL =
      "http://localhost:3030/jsonstore/forecaster/upcoming/";
    const currentForecasterResponse = await fetch(
      `${currentForecasterURL}${objectToGet.code}`
    );
    const newData = await currentForecasterResponse.json();
    let mainDiv = createHTMLElement(
      "div",
      "",
      currentConditionsElement,
      "forecasts"
    );
    createHTMLElement(
      "span",
      conditionObject[newData.forecast.condition],
      mainDiv,
      "condition symbol"
    );
    let spanContainer = createHTMLElement("span", "", mainDiv, "condition");
    createHTMLElement("span", newData.name, spanContainer, "forecast-data");
    createHTMLElement(
      "span",
      `${newData.forecast.low}&#176/${newData.forecast.high}&#176`,
      spanContainer,
      "forecast-data"
    );
    createHTMLElement(
      "span",
      newData.forecast.condition,
      spanContainer,
      "forecast-data"
    );

    const threeDaysResponse = await fetch(
      `${threeDaysForecasterURL}${objectToGet.code}`
    );
    const threeDayData = await threeDaysResponse.json();
    Array.from(threeDayData.forecast).forEach((x) => {
      const divContainer = createHTMLElement(
        "div",
        "",
        upcomingForeCaster,
        "forecast-info"
      );
      const spanContainer = createHTMLElement(
        "span",
        "",
        divContainer,
        "upcoming"
      );
      createHTMLElement(
        "span",
        conditionObject[x.condition],
        spanContainer,
        "symbol"
      );
      createHTMLElement(
        "span",
        `${x.low}&#176/${x.high}&#176`,
        spanContainer,
        "forecast-data"
      );
      createHTMLElement("span", x.condition, spanContainer, "forecast-data");
    });
  }

  function createHTMLElement(
    typeOfElement,
    content,
    parentElement,
    classToAdd
  ) {
    const element = document.createElement(typeOfElement);
    if (content && !content.includes("#")) {
      element.textContent = content;
    }
    if (content && content.includes("#")) {
      element.innerHTML = content;
    }
    if (parentElement) {
      parentElement.appendChild(element);
    }
    if (classToAdd) {
      element.className = classToAdd;
    }
    return element;
  }
}

attachEvents();
