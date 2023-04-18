function attachEvents() {
  const baseURL = "http://localhost:3030/jsonstore/collections/students";
  const tbody = document.querySelector("tbody");
  const submitButtonElement = document.getElementById("submit");
  const inputElements = Array.from(document.querySelectorAll(".inputs input"));
  submitButtonElement.addEventListener("click", enrollStudent);
  loadStudents();
  async function loadStudents() {
    try {
      const response = await fetch(baseURL);
      const data = await response.json();
      Object.values(data).forEach((x) => {
        const grade = Number(x.grade);
        const tableRow = createHTMLElement("tr", "", tbody, "");
        createHTMLElement("td", x.firstName, tableRow, "");
        createHTMLElement("td", x.lastName, tableRow, "");
        createHTMLElement("td", x.facultyNumber, tableRow, "");
        createHTMLElement("td", `${grade.toFixed(2)}`, tableRow, "");
      });
    } catch (error) {
      console.error(error);
    }
  }

  async function enrollStudent() {
    let values = inputElements.map((input) => input.value);
    if (values.filter((word) => word === "").length > 0) {
      return;
    }
    let bodyObject = {
      firstName: values[0],
      lastName: values[1],
      facultyNumber: values[2],
      grade: values[3],
    };
    try {
      await fetch(baseURL, {
        method: "POST",
        "Content-type": "application/json",
        body: JSON.stringify(bodyObject),
      }).then(() => {
        tbody.textContent = "";
        loadStudents();
      });
    } catch (error) {
      console.error(error);
    }
  }
  function createHTMLElement(typeOfElement, content, parent, classList) {
    const element = document.createElement(typeOfElement);
    if (content) {
      element.textContent = content;
    }
    if (parent) {
      parent.appendChild(element);
    }
    if (classList) {
      element.classList.add(classList);
    }
    return element;
  }
}

attachEvents();