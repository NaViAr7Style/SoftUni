function focused() {
    const inputFields = Array.from(document.querySelectorAll("input"));

    for (const input of inputFields) {
        input.addEventListener("focus", focusHandler);
        input.addEventListener("blur", blurHandler);
    }


    function focusHandler(e) {
        this.parentElement.classList.add("focused");
    }

    function blurHandler(e) {
        this.parentElement.classList.remove("focused");
    }
}