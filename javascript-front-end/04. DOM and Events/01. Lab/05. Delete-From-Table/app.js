function deleteByEmail() {
    const emails = Array.from(document.querySelectorAll("td:nth-child(even)"));
    const input = document.querySelector("input");

    let emailValue = input.value;
    let foundElement = emails.find((e) => e.textContent === emailValue);

    let output = document.getElementById("result");

    if (foundElement) {
        foundElement.parentElement.remove();
        output.textContent = "Deleted.";
    } else {
        output.textContent = "Not found.";
    }

    input.value = "";
}