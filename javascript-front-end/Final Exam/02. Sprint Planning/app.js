window.addEventListener("load", solve);

function solve() {
  const inputDOMElements = {
    title: document.getElementById("title"),
    description: document.getElementById("description"),
    label: document.getElementById("label"),
    points: document.getElementById("points"),
    assignee: document.getElementById("assignee"),
  };

  const otherDOMElements = {
    createTaskBtn: document.getElementById("create-task-btn"),
    deleteTaskBtn: document.getElementById("delete-task-btn"),
    taskContainer: document.getElementById("tasks-section"),
    totalPointsContainer: document.getElementById("total-sprint-points"),
    hiddenInput: document.getElementById("task-id"),
  };

  let taskCounter = 0;
  let tasksTotalPoints = 0;

  otherDOMElements.createTaskBtn.addEventListener("click", createTaskHandler);
  otherDOMElements.deleteTaskBtn.addEventListener(
    "click",
    finalTaskDeleteHandler
  );

  function createTaskHandler() {
    const allInputsHaveValue = Object.values(inputDOMElements).every(
      (input) => input.value !== ""
    );

    if (!allInputsHaveValue) {
      return;
    }

    const { title, description, label, points, assignee } = inputDOMElements;

    const article = createElement(
      "article",
      otherDOMElements.taskContainer,
      "",
      ["task-card"],
      `task-${++taskCounter}`
    );

    let taskDivContent = "";
    let taskDivClass = "";

    switch (inputDOMElements.label.value) {
      case "Feature":
        taskDivContent = "Feature &#8865";
        taskDivClass = "feature";
        break;
      case "Low Priority Bug":
        taskDivContent = "Low Priority Bug &#9737";
        taskDivClass = "low-priority";
        break;
      case "High Priority Bug":
        taskDivContent = "High Priority Bug &#9888";
        taskDivClass = "high-priority";
        break;
    }

    createElement(
      "div",
      article,
      `${taskDivContent}`,
      ["task-card-label", `${taskDivClass}`],
      "",
      "",
      true
    );

    createElement("h3", article, `${title.value}`, ["task-card-title"]);
    createElement("p", article, `${description.value}`, [
      "task-card-description",
    ]);

    tasksTotalPoints += Number(points.value);
    createElement("div", article, `Estimated at ${points.value} pts`, [
      "task-card-points",
    ]);

    createElement("div", article, `Assigned to: ${assignee.value}`, [
      "task-card-assignee",
    ]);

    const divBtn = createElement("div", article, "", ["task-card-actions"]);
    const deleteBtn = createElement("button", divBtn, "Delete");
    deleteBtn.addEventListener("click", deleteCurrentTaskHandler);

    Object.values(inputDOMElements).forEach((input) => (input.value = ""));
    otherDOMElements.totalPointsContainer.textContent = `Total Points ${tasksTotalPoints}pts`;
  }

  function deleteCurrentTaskHandler() {
    const article = this.parentNode.parentNode;
    const children = Array.from(article.children);

    const { title, description, label, points, assignee } = inputDOMElements;
    const [
      taskLabel,
      taskTitle,
      taskDescription,
      taskPoints,
      taskAssignee,
      _taskActions,
    ] = children;

    title.value = taskTitle.textContent;
    description.value = taskDescription.textContent;
    points.value = Number(taskPoints.textContent.split(" ")[2]);
    assignee.value = taskAssignee.textContent.split(": ")[1];

    if (taskLabel.textContent.includes("Feature")) {
      label.value = "Feature";
    } else if (taskLabel.textContent.includes("Low")) {
      label.value = "Low Priority Bug";
    } else {
      label.value = "High Priority Bug";
    }

    otherDOMElements.createTaskBtn.disabled = true;
    otherDOMElements.deleteTaskBtn.disabled = false;

    Object.values(inputDOMElements).forEach((input) => (input.disabled = true));
    otherDOMElements.hiddenInput.value = article.id;
  }

  function finalTaskDeleteHandler() {
    tasksTotalPoints -= Number(inputDOMElements.points.value);
    const taskIdToRemove = otherDOMElements.hiddenInput.value;
    const articleToRemove = document.getElementById(taskIdToRemove);
    articleToRemove.remove();
    otherDOMElements.hiddenInput.value = "";

    Object.values(inputDOMElements).forEach((input) => {
      input.value = "";
      input.disabled = false;
    });

    otherDOMElements.totalPointsContainer.textContent = `Total Points ${tasksTotalPoints}pts`;
    otherDOMElements.createTaskBtn.disabled = false;
    otherDOMElements.deleteTaskBtn.disabled = true;
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
