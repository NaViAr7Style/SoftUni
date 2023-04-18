function attachEvents() {
    const baseURL = "http://localhost:3030/jsonstore/messenger";
    const submitButtonElement = document.getElementById("submit");
    const authorInputElement = document.querySelector('input[name="author"]');
    const inputMessageElement = document.querySelector('input[name="content"]');
    const refreshButtonElement = document.getElementById("refresh");
    const textAreaElement = document.getElementById("messages");
    submitButtonElement.addEventListener("click", sentMessage);
    refreshButtonElement.addEventListener("click", loadMessages);
  
    async function sentMessage() {
      let object = {
        author: authorInputElement.value,
        content: inputMessageElement.value,
      };
      try {
        await fetch(baseURL, {
          method: "POST",
          headers: { "Content-type": "application/json" },
          body: JSON.stringify(object),
        });
      } catch (error) {
        console.error(error);
      }
    }
    async function loadMessages() {
      const response = await fetch(baseURL);
      const data = await response.json();
      const length = Object.values(data).length;
  
      Object.values(data).forEach((data, index) => {
        const result =
          index === length - 1
            ? `${data.author}: ${data.content}`
            : `${data.author}: ${data.content}\n`;
        textAreaElement.textContent += result;
      });
    }
  }
  
  attachEvents();