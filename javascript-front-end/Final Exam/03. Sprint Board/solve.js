function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

  const containers = {
    toDo: document.getElementById("todo-section"),
    inProgress: document.getElementById("in-progress-section"),
    codeReview: document.getElementById("code-review-section"),
    done: document.getElementById("done-section"),
  };

  const buttons = {
    loadBtn: document.getElementById("load-board-btn"),
    addBtn: document.getElementById("create-task-btn"),
  };

  const inputFields = {
    taskTitle: document.getElementById("title"),
    taskDescription: document.getElementById("description"),
  };

  buttons.loadBtn.addEventListener("click", loadTasksHandler);
  buttons.addBtn.addEventListener("click", addTaskHandler);

  async function loadTasksHandler() {
    const taskLists = Array.from(document.querySelectorAll(".task-list"));
    taskLists.forEach((list) => (list.innerHTML = ""));

    const loadTasksRes = await fetch(BASE_URL);
    const data = await loadTasksRes.json();

    try {
      for (const item in data) {
        const { title, description, status, _id } = data[item];
        let parent;
        let btnText = "";

        switch (status) {
          case "ToDo":
            parent = containers.toDo.children[1];
            btnText = "Move to In Progress";
            break;
          case "In Progress":
            parent = containers.inProgress.children[1];
            btnText = "Move to Code Review";
            break;
          case "Code Review":
            parent = containers.codeReview.children[1];
            btnText = "Move to Done";
            break;
          case "Done":
            parent = containers.done.children[1];
            btnText = "Close";
            break;
        }

        const li = createElement("li", parent, "", ["task"], _id);
        createElement("h3", li, `${title}`);
        createElement("p", li, `${description}`);
        const taskBtn = createElement("button", li, btnText);
        taskBtn.addEventListener("click", updateTaskStatusHandler);
      }
    } catch (err) {
      console.error(err);
    }
  }

  function updateTaskStatusHandler() {
    const btnText = this.textContent;
    const taskId = this.parentNode.id;

    let httpHeaders = {
      method: "PATCH"
    };

    let taskStatus = {
      status: "ToDo",
    };

    switch (btnText) {
      case "Move to In Progress":
        taskStatus.status = "In Progress";
        break;
      case "Move to Code Review":
        taskStatus.status = "Code Review";
        break;
      case "Move to Done":
        taskStatus.status = "Done";
        break;
      case "Close":
        httpHeaders.method = "DELETE";
        break;
    }

    httpHeaders.body = JSON.stringify(taskStatus);

    fetch(`${BASE_URL}${taskId}`, httpHeaders)
      .then(() => loadTasksHandler())
      .catch((err) => {
        console.error(err);
      });
  }

  function addTaskHandler() {
    const task = {
      title: inputFields.taskTitle.value,
      description: inputFields.taskDescription.value,
      status: "ToDo",
    };

    const httpHeaders = {
      method: "POST",
      body: JSON.stringify(task),
    };

    fetch(BASE_URL, httpHeaders)
      .then(() => {
        loadTasksHandler();
        Object.values(inputFields).forEach((input) => (input.value = ""));
      })
      .catch((err) => {
        console.error(err);
      });
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

attachEvents();
