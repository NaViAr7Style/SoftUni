function extractText() {
    const liItems = Array.from(document.querySelectorAll("#items li"));
    const textArea = document.getElementById("result");

    for (const li of liItems) {
        textArea.textContent += li.textContent + "\n";
    }
}