function addItem() {
    const selectTag = document.getElementById("menu");
    const inputText = document.getElementById("newItemText");
    const inputValue = document.getElementById("newItemValue");

    const option = document.createElement("option");
    option.textContent = inputText.value;
    option.value = inputValue.value;

    selectTag.appendChild(option);

    inputText.value = "";
    inputValue.value = "";
}