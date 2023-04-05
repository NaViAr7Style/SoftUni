function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const inputField = document.getElementById("searchField");
      const tableRows = Array.from(document.querySelectorAll("tbody > tr"));

      for (const row of tableRows) {
         row.classList.remove("select");

         if (inputField.value !== "" && row.textContent.includes(inputField.value)) {
            row.classList.add("select");
         }
      }

      inputField.value = "";
   }
}