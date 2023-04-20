window.addEventListener("load", solve);

function solve() {
  const inputFields = {
    title: document.getElementById("task-title"),
    category: document.getElementById("task-category"),
    content: document.getElementById("task-content"),
  };

  const otherDOMElements = {
    publishBtn: document.getElementById("publish-btn"),
    reviewList: document.getElementById("review-list"),
    publishList: document.getElementById("published-list"),
  };

  otherDOMElements.publishBtn.addEventListener("click", publishTaskHandler);

  function publishTaskHandler() {
    const allInputsHaveValues = Object.values(inputFields).every(
      (input) => input.value !== ""
    );

    if (!allInputsHaveValues) {
      return;
    }

    const { title, category, content } = inputFields;

    const li = createElement("li", otherDOMElements.reviewList, "", ["rpost"]);
    const article = createElement("article", li);
    createElement("h4", article, `${title.value}`);
    createElement("p", article, `Category: ${category.value}`);

    //Could create an error for Exclamation mark
    createElement("p", article, `Content: ${content.value}`);

    const editBtn = createElement("button", li, "Edit", ["action-btn", "edit"]);
    editBtn.addEventListener("click", editTaskHandler);

    const postBtn = createElement("button", li, "Post", ["action-btn", "post"]);
    postBtn.addEventListener("click", postTaskHandler);

    Object.values(inputFields).forEach((input) => (input.value = ""));
  }

  function editTaskHandler() {
    const article = this.parentNode.children[0];
    const { title, category, content } = inputFields;
    const [postTitle, postCategory, postContent] = Array.from(article.children);

    title.value = postTitle.textContent;
    category.value = postCategory.textContent.split("Category: ")[1];
    content.value = postContent.textContent.split("Content: ")[1];

    this.parentNode.remove();
  }

  function postTaskHandler() {
    const li = this.parentNode;
    const editBtn = li.children[1];
    const postBtn = li.children[2];

    editBtn.remove();
    postBtn.remove();

    otherDOMElements.publishList.appendChild(li);
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