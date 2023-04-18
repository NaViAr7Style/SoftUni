function solve() {
  const inputDOMSelectors = {
    title: document.getElementById("title"),
    description: document.getElementById("description"),
    label: document.getElementById("label"),
    points: document.getElementById("points"),
    assignee: document.getElementById("assignee"),
  };

  const otherDOMSelectors = {
    createTaskBtn: document.getElementById("create-task-btn"),
    deleteTaskBtn: document.getElementById("delete-task-btn"),
    taskSection: document.getElementById("tasks-section"),
    taskId: document.getElementById("task-id"),
    totalPoints: document.getElementById("total-sprint-points"),
  };

  let totalPoints = 0;
  let taskCounter = 1;
  otherDOMSelectors.createTaskBtn.addEventListener("click", createTaskHandler);

  function createTaskHandler() {
    const allFieldsHaveValue = Object.values(inputDOMSelectors).every(
      (input) => input.value !== ""
    );

    if (!allFieldsHaveValue) {
      return;
    }

    const articleContainer = createElement(
      "article",
      otherDOMSelectors.taskSection,
      "",
      ["task-card"],
      `task-${taskCounter}`
    );
    taskCounter++;

    let labelVal = inputDOMSelectors.label.value;
    let divIcon = "";
    let divClass = "";

    switch (labelVal) {
      case "Feature":
        divIcon = "&#8865";
        divClass = "feature";
        break;
      case "Low Priority Bug":
        divIcon = "&#9737";
        divClass = "low-priority";
        break;
      case "High Priority Bug":
        divIcon = "&#9888";
        divClass = "high-priority";
        break;
    }

    createElement("div", articleContainer, `${labelVal} <span>${divIcon}</span>`, ["task-card-label", `${divClass}`], "", "", true);

    createElement("h3", articleContainer, inputDOMSelectors.title.value, [
      "task-card-title",
    ]);

    createElement("p", articleContainer, inputDOMSelectors.description.value, [
      "task-card-description",
    ]);

    createElement(
      "div",
      articleContainer,
      `Estimated at ${inputDOMSelectors.points.value} pts`,
      ["task-card-points"]
    );

    createElement(
      "div",
      articleContainer,
      `Assigned to: ${inputDOMSelectors.assignee.value}`,
      ["task-card-assignee"]
    );

    const divBtn = createElement("div", articleContainer, "", [
      "task-card-actions",
    ]);

    const deleteBtn = createElement("button", divBtn, "Delete");
    deleteBtn.addEventListener("click", deleteBtnHandler);

    totalPoints += Number(inputDOMSelectors.points.value);
    otherDOMSelectors.totalPoints.textContent = `Total Points ${totalPoints}pts`;

    Object.values(inputDOMSelectors).forEach((input) => {
      input.value = "";
    });
  }

  function deleteBtnHandler() {
    const [label, title, description, points, assignee] =
      this.parentNode.parentNode.children;

    inputDOMSelectors.title.value = title.textContent;
    inputDOMSelectors.description.value = description.textContent;
    inputDOMSelectors.assignee.value = assignee.textContent.slice(12);

    let pointTokens = points.textContent.split(" ");
    inputDOMSelectors.points.value = Number(pointTokens[2]);

    if (label.textContent.includes("Feature")) {
      inputDOMSelectors.label.value = "Feature";
    } else if (label.textContent.includes("High")) {
      inputDOMSelectors.label.value = "High Priority Bug";
    } else if (label.textContent.includes("Low")) {
      inputDOMSelectors.label.value = "Low Priority Bug";
    }

    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].disabled = true;
    }

    otherDOMSelectors.createTaskBtn.disabled = true;
    otherDOMSelectors.taskId.value = this.parentNode.parentNode.id;
    otherDOMSelectors.deleteTaskBtn.disabled = false;

    otherDOMSelectors.deleteTaskBtn.addEventListener(
      "click",
      deleteTaskHandler
    );
  }

  function deleteTaskHandler() {
    const article = document.getElementById(otherDOMSelectors.taskId.value);
    article.remove();

    totalPoints -= Number(inputDOMSelectors.points.value);
    otherDOMSelectors.totalPoints.textContent = `Total Points ${totalPoints}pts`;

    for (const key in inputDOMSelectors) {
      inputDOMSelectors[key].value = "";
      inputDOMSelectors[key].disabled = false;
    }

    otherDOMSelectors.createTaskBtn.disabled = false;
    otherDOMSelectors.deleteTaskBtn.disabled = true;
    otherDOMSelectors.taskId.value = "task-id";
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

window.addEventListener("load", solve());