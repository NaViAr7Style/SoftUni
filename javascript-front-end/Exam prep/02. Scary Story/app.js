window.addEventListener("load", solve);

function solve() {
  const inputDOMElements = {
    firstName: document.getElementById("first-name"),
    lastName: document.getElementById("last-name"),
    age: document.getElementById("age"),
    title: document.getElementById("story-title"),
    genre: document.getElementById("genre"),
    story: document.getElementById("story"),
  };

  let inputValues = [];

  const otherDOMElements = {
    publishBtn: document.getElementById("form-btn"),
    previewList: document.getElementById("preview-list"),
    mainDiv: document.getElementById("main"),
  };

  otherDOMElements.publishBtn.addEventListener("click", publishStoryHandler);

  function publishStoryHandler() {
    const allInputsHaveValues = Object.values(inputDOMElements).every(
      (input) => input.value !== ""
    );

    if (!allInputsHaveValues) {
      return;
    }

    const { firstName, lastName, age, title, genre, story } = inputDOMElements;

    const li = createElement("li", otherDOMElements.previewList, "", [
      "story-info",
    ]);
    const article = createElement("article", li);
    createElement("h4", article, `Name: ${firstName.value} ${lastName.value}`);
    createElement("p", article, `Age: ${age.value}`);
    createElement("p", article, `Title: ${title.value}`);
    createElement("p", article, `Genre: ${genre.value}`);
    createElement("p", article, story.value);

    const saveBtn = createElement("button", li, "Save Story", ["save-btn"]);
    saveBtn.addEventListener("click", saveStoryHandler);

    const editBtn = createElement("button", li, "Edit Story", ["edit-btn"]);
    editBtn.addEventListener("click", editStoryHandler);

    const deleteBtn = createElement("button", li, "Delete Story", [
      "delete-btn",
    ]);
    deleteBtn.addEventListener("click", deleteStoryHandler);

    for (const input in inputDOMElements) {
      inputValues.push(inputDOMElements[input].value);
    }

    Object.values(inputDOMElements).forEach((input) => (input.value = ""));
    otherDOMElements.publishBtn.disabled = true;
  }

  function editStoryHandler() {
    for (const input in inputDOMElements) {
      inputDOMElements[input].value = inputValues.shift();
    }

    otherDOMElements.publishBtn.disabled = false;
    this.parentNode.remove();
  }

  function saveStoryHandler() {
    otherDOMElements.mainDiv.innerHTML = "";
    createElement("h1", otherDOMElements.mainDiv, "Your scary story is saved!");
  }

  function deleteStoryHandler() {
    this.parentNode.remove();
    otherDOMElements.publishBtn.disabled = false;
  }

  function createElement(
    type,
    parentNode,
    content,
    classes,
    id,
    attributes,
    useInnerHtml
  ) {
    const htmlElement = document.createElement(type);

    if (content && useInnerHtml) {
      htmlElement.innerHTML = content;
    } else {
      if (content && type !== "input") {
        htmlElement.textContent = content;
      }

      if (content && type === "input") {
        htmlElement.value = content;
      }
    }

    if (classes && classes.length > 0) {
      htmlElement.classList.add(...classes);
    }

    if (id) {
      htmlElement.id = id;
    }

    if (attributes) {
      for (const key in attributes) {
        htmlElement[key] = attributes[key];
      }
    }

    if (parentNode) {
      parentNode.appendChild(htmlElement);
    }

    return htmlElement;
  }
}
