function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/collections/books/";
  const loadBtn = document.getElementById("loadBooks");
  const booksContainer = document.querySelector("table > tbody");
  const [ titleInput, authorInput ] = Array.from(document.querySelectorAll("#form > input"));
  const submitBtn = document.querySelector("#form > button");
  const formHeader = document.querySelector("#form > h3");

  let editBookId = null;

  loadBtn.addEventListener("click", loadAllBooksHandler);
  submitBtn.addEventListener("click", submitFormHandler);

  async function loadAllBooksHandler() {
    booksContainer.innerHTML = "";

    const booksRes = await fetch(BASE_URL);
    const booksData = await booksRes.json();

    try {

      for (const bookId in booksData) {
        const { author, title } = booksData[bookId];
        const tableRow = document.createElement("tr");
        const titleTd = document.createElement("td");
        const authorTd = document.createElement("td");
        const buttonsTd = document.createElement("td");
        const editBtn = document.createElement("button");
        const deleteBtn = document.createElement("button");

        titleTd.textContent = title;
        authorTd.textContent = author;

        editBtn.textContent = "Edit";
        editBtn.addEventListener("click", () => {
          editBookId = bookId;
          formHeader.textContent = "Edit FORM";
          submitBtn.textContent = "Save";
          titleInput.value = title;
          authorInput.value = author;
        });

        deleteBtn.textContent = "Delete";
        deleteBtn.id = bookId;
        deleteBtn.addEventListener("click", deleteBookHandler);


        buttonsTd.appendChild(editBtn);
        buttonsTd.appendChild(deleteBtn);

        tableRow.appendChild(titleTd);
        tableRow.appendChild(authorTd);
        tableRow.appendChild(buttonsTd);
        booksContainer.appendChild(tableRow);
      }
    } catch {
      console.log("Error");
    }
  }

  async function submitFormHandler() {
    const title = titleInput.value;
    const author = authorInput.value;
    const httpHeaders = {
      method: "POST",
      body: JSON.stringify({ title, author })
    }
    let url = BASE_URL;

    if (formHeader.textContent === "Edit FORM") {
      httpHeaders.method = "PUT";
      url += editBookId;
    }

    const resData = await fetch(url, httpHeaders);
    loadAllBooksHandler();

    if (formHeader.textContent === "Edit FORM") {
      formHeader.textContent = "FORM";
      submitBtn.textContent = "Submit";
    }

    titleInput.value = "";
    authorInput.value = "";
  }

  async function deleteBookHandler() {
    const id = this.id;
    const httpHeaders = {
      method: "DELETE"
    };

    await fetch(BASE_URL + id, httpHeaders);
    loadAllBooksHandler();
  }

}

attachEvents();