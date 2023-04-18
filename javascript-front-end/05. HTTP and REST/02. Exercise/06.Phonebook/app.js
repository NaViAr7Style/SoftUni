function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/phonebook/";
  const phoneBookContainer = document.getElementById("phonebook");
  const loadBtn = document.getElementById("btnLoad");

  const personInput = document.getElementById("person");
  const phoneInput = document.getElementById("phone");
  const createBtn = document.getElementById("btnCreate");

  loadBtn.addEventListener("click", loadPhoneBookHandler);
  createBtn.addEventListener("click", createPhoneBookHandler);

  async function loadPhoneBookHandler() {
    const phoneBookRes = await fetch(BASE_URL);
    let phoneBookData = await phoneBookRes.json();

    phoneBookContainer.replaceChildren();

    try {
      phoneBookData = Object.values(phoneBookData);

      for (const { person, phone, _id } of phoneBookData) {
        let li = document.createElement("li");
        let deleteBtn = document.createElement("button");
        li.textContent = `${person}: ${phone}`;
        deleteBtn.textContent = "Delete";
        deleteBtn.id = _id;
        deleteBtn.addEventListener("click", deletePhoneBookHandler);
        li.appendChild(deleteBtn);
        phoneBookContainer.appendChild(li);
      }
    } catch (e) {
      console.log("Error");
    }
  }

  function createPhoneBookHandler() {
    const person = personInput.value;
    const phone = phoneInput.value;
    const httpHeaders = {
      method: "POST",
      body: JSON.stringify({ person, phone })
    };

    fetch(BASE_URL, httpHeaders)
      .then((res) => res.json())
      .then(loadPhoneBookHandler)
      .catch((err) => {
        console.error(err);
      });

    personInput.value = "";
    phoneInput.value = "";
  }

  async function deletePhoneBookHandler() {
    const id = this.id;
    const httpHeaders = {
      method: "DELETE",
    };

    fetch(`${BASE_URL}${id}`, httpHeaders)
      .then((res) => res.json())
      .then(loadPhoneBookHandler)
      .catch((err) => {
        console.error(err);
      });
  }
}

attachEvents();