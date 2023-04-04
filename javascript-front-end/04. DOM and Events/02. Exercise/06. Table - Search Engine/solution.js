function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const tableRows = Array.from(document.querySelectorAll("tbody > tr"));

      for (const row of tableRows) {
         row.classList.remove("select");
      }

      const textCells = Array.from(document.querySelectorAll("tbody td"));
      const searchValue = document.getElementById("searchField").value;

      for (const cell of textCells) {
         if (cell.textContent.includes(searchValue)) {
            cell.parentElement.classList.add("select");
         }
      }
   }
}