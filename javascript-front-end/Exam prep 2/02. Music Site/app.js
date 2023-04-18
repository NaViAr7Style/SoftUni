window.addEventListener("load", solve);

function solve() {
  const inputDOMSelectors = {
    genre: document.getElementById("genre"),
    songName: document.getElementById("name"),
    author: document.getElementById("author"),
    creationDate: document.getElementById("date"),
  };

  const otherDOMSelectors = {
    addBtn: document.getElementById("add-btn"),
    collectionContainer: document.querySelector(".all-hits-container"),
    savedSongsContainer: document.querySelector(".saved-container"),
  };

  otherDOMSelectors.addBtn.addEventListener("click", addSongHandler);

  function addSongHandler(event) {
    event.preventDefault();

    const allInputsHaveValue = Object.values(inputDOMSelectors).every(
      (input) => input.value !== ""
    );

    if (!allInputsHaveValue) {
      return;
    }

    const { genre, songName, author, creationDate } = inputDOMSelectors;
    const div = createElement("div", otherDOMSelectors.collectionContainer, "", ["hits-info"]);
    
    const img = createElement("img", div);
    img.src = "./static/img/img.png";

    createElement("h2", div, `Genre: ${genre.value}`);
    createElement("h2", div, `Name: ${songName.value}`);
    createElement("h2", div, `Author: ${author.value}`);
    createElement("h3", div, `Date: ${creationDate.value}`);

    const saveBtn = createElement("button", div, "Save song", ["save-btn"]);
    saveBtn.addEventListener("click", saveSongHandler);

    const likeBtn = createElement("button", div, "Like song", ["like-btn"]);
    likeBtn.addEventListener("click", likeSongHandler);

    const deleteBtn = createElement("button", div, "Delete", ["delete-btn"]);
    deleteBtn.addEventListener("click", deleteSongHandler);

    clearAllInputs();
  }

  function saveSongHandler() {
    const div = this.parentNode;
    div.removeChild(div.children[6]);
    div.removeChild(div.children[5]);

    otherDOMSelectors.savedSongsContainer.appendChild(div);
  }

  function likeSongHandler() {
    const totalLikesContainer = document.querySelector("#total-likes > div > p");
    let currentLikes = Number(totalLikesContainer.textContent.split("Total Likes: ")[1]);
    currentLikes++;
    totalLikesContainer.textContent = `Total Likes: ${currentLikes}`;
    
    this.disabled = true;
  }

  function deleteSongHandler() {
    const div = this.parentNode;
    const container = div.parentNode;
    container.removeChild(div);
  }

  function clearAllInputs() {
    Object.values(inputDOMSelectors)
      .forEach((input) => {
        input.value = "";
      })
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
