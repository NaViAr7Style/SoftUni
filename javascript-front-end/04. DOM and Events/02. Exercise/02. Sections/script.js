function create(words) {
   const divContainer = document.getElementById("content");

   for (const word of words) {
      const div = document.createElement("div");
      const paragraph = document.createElement("p");

      paragraph.textContent = word;
      paragraph.style.display = "none";

      div.appendChild(paragraph);
      div.addEventListener("click", () => {
         paragraph.style.display = "block";
      });

      divContainer.appendChild(div);
   }
}