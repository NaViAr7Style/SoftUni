function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/tasks/";

  const buttons = {
    addCourse: document.getElementById("add-course"),
    editCourse: document.getElementById("edit-course"),
    loadCourses: document.getElementById("load-course"),
  };

  const inputFields = {
    title: document.getElementById("course-name"),
    type: document.getElementById("course-type"),
    description: document.getElementById("description"),
    teacher: document.getElementById("teacher-name"),
  };

  const otherDOMElements = {
    courseContainer: document.getElementById("list"),
  };

  let editId = "";

  buttons.loadCourses.addEventListener("click", loadCoursesHandler);
  buttons.addCourse.addEventListener("click", addCourseHandler);
  buttons.editCourse.addEventListener("click", editCourseQueryHandler);

  async function loadCoursesHandler() {
    otherDOMElements.courseContainer.innerHTML = "";

    const loadCoursesRes = await fetch(BASE_URL);
    const data = await loadCoursesRes.json();

    try {
      for (const item in data) {
        const { title, type, description, teacher, _id } = data[item];

        const div = createElement(
          "div",
          otherDOMElements.courseContainer,
          "",
          ["container"],
          _id
        );
        createElement("h2", div, title);
        createElement("h3", div, teacher);
        createElement("h3", div, type);
        createElement("h4", div, description);

        const editBtn = createElement(
          "button",
          div,
          "Edit Course",
          ["edit-btn"],
          _id
        );
        editBtn.addEventListener("click", editCurrentCourseHandler);

        const finishBtn = createElement(
          "button",
          div,
          "Finish Course",
          ["finish-btn"],
          _id
        );
        finishBtn.addEventListener("click", finishCourseHandler);
      }
    } catch (err) {
      console.error(err);
    }
  }

  function finishCourseHandler() {
    const courseId = this.id;

    const httpHeaders = {
      method: "DELETE"
    };

    fetch(`${BASE_URL}${courseId}`, httpHeaders)
      .then(() => loadCoursesHandler())
      .catch((err) => {
        console.error(err);
      });
  }

  function editCourseQueryHandler(event) {
    event?.preventDefault();

    const allInputsHaveValue = Object.values(inputFields).every(
      (input) => input.value !== ""
    );

    if (!allInputsHaveValue) {
      return;
    }

    const { title, type, description, teacher } = inputFields;

    const course = {
      title: title.value,
      type: type.value,
      description: description.value,
      teacher: teacher.value,
    };

    const httpHeaders = {
      method: "PUT",
      body: JSON.stringify(course),
    };

    fetch(`${BASE_URL}${editId}`, httpHeaders)
      .then(() => loadCoursesHandler())
      .catch((err) => {
        console.error(err);
      });

    buttons.editCourse.disabled = true;
    buttons.addCourse.disabled = false;
    Object.values(inputFields).forEach((input) => (input.value = ""));
  }

  function editCurrentCourseHandler() {
    const div = this.parentNode;
    editId = this.id;
    const [courseTitle, courseTeacher, courseType, courseDescription] =
      Array.from(div.children);

    const { title, type, description, teacher } = inputFields;

    title.value = courseTitle.textContent;
    type.value = courseType.textContent;
    description.value = courseDescription.textContent;
    teacher.value = courseTeacher.textContent;

    this.parentNode.remove();
    buttons.editCourse.disabled = false;
    buttons.addCourse.disabled = true;
  }

  function addCourseHandler(event) {
    event?.preventDefault();

    const allInputsHaveValue = Object.values(inputFields).every(
      (input) => input.value !== ""
    );

    if (!allInputsHaveValue) {
      return;
    }

    const { title, type, description, teacher } = inputFields;

    const course = {
      title: title.value,
      type: type.value,
      description: description.value,
      teacher: teacher.value,
    };

    const httpHeaders = {
      method: "POST",
      body: JSON.stringify(course),
    };

    fetch(BASE_URL, httpHeaders)
      .then(() => loadCoursesHandler())
      .catch((err) => {
        console.error(err);
      });

    Object.values(inputFields).forEach((input) => (input.value = ""));
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
