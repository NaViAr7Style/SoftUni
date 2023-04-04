function addItem() {
    const listItems = document.getElementById("items");
    const input = document.getElementById("newItemText");

    const childElement = document.createElement("li");
    childElement.textContent = input.value;

    listItems.appendChild(childElement);
    input.value = "";
}