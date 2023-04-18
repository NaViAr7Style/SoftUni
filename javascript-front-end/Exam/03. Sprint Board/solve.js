function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";
  const loadBtn = document.getElementById("load-board-btn");

  const sectionDOMSelectors = {
    toDo: document.getElementById("todo-section"),
    inProgress: document.getElementById("in-progress-section"),
    codeReview: document.getElementById("code-review-section"),
    done: document.getElementById("done-section"),
  };

  const [toDoList, inProgressList, codeReviewList, doneList] = Array.from(
    document.getElementsByClassName("task-list")
  );

  loadBtn.addEventListener("click", loadBoardHandler);

  function loadBoardHandler() {

    fetch(BASE_URL)
      .then((res) => res.json())
      .then((tasksRes) => {
        const tasks = Object.values(tasksRes);

        for (const { title, description, status, _id } of tasks) {
          const li = document.createElement("li");
          li.classList.add("task");
          li.id = _id;

          const h3 = document.createElement("h3");
          h3.textContent = title;

          const p = document.createElement("p");
          p.textContent = description;

          const button = document.createElement("button");

          switch (status) {
            case "ToDo":
              button.textContent = "Move to In Progress";
              toDoList.appendChild(li);
              break;
            case "In Progress":
              button.textContent = "Move to Code Review";
              inProgressList.appendChild(li);
              break;
            case "Code Review":
              button.textContent = "Move to Done";
              codeReviewList.appendChild(li);
              break;
            case "Done":
              button.textContent = "Close";
              doneList.appendChild(li);
              break;
          }

          button.addEventListener("click", moveHandler);

          li.append(h3, p, button);
        }
      })
      .catch((err) => {
        console.error(err);
      });
  }

  function moveHandler() {
    const id = this.parentNode.id;
    const action = this.textContent;
    let status = "";
    let httpHeaders = {};

    switch (action) {
      case "Move to In Progress":
        status = "In Progress";
        httpHeaders = {
          method: "PATCH",
          body: JSON.stringify({ status }),
        };
        break;
      case "Move to Code Review":
        status = "Code Review";
        httpHeaders = {
          method: "PATCH",
          body: JSON.stringify({ status }),
        };
        break;
      case "Move to Done":
        httpHeaders = {
          method: "PATCH",
          body: JSON.stringify({ status }),
        };
        status = "Done";
        break;
      case "Close":
        httpHeaders = {
          method: "DELETE",
        };
        break;
    }

    fetch(`${BASE_URL}${id}`, httpHeaders)
        .then(() => loadBoardHandler())
        .catch((err) => {
            console.error(err);
        })
  }
}

attachEvents();
