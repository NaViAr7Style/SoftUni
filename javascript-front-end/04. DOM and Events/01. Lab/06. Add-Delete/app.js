function addItem() {
    const ulContainer = document.getElementById("items");
    const input = document.getElementById("newItemText");

    const newLi = document.createElement("li");
    const newAnchor = document.createElement("a");

    newLi.textContent = input.value;
    newAnchor.textContent = "[Delete]";
    newAnchor.href = "#";

    newLi.appendChild(newAnchor);
    ulContainer.appendChild(newLi);
    
    input.value = "";

    newAnchor.addEventListener("click", deleteHandler);

    function deleteHandler(e) {
        this.parentElement.remove();
    }
}