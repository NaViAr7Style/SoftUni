function solve() {
  const inputText = document.getElementById("input");
  const outputDiv = document.getElementById("output");

  let sentences = inputText.value.split(".");
  sentences.pop(); //Remove empty element.

  while (sentences.length > 0) {
    let paragraphSentences = sentences.splice(0, 3)
      .map((p) => p.trimStart() + ".");

    const newParagraph = document.createElement("p");
    newParagraph.textContent = paragraphSentences.join(" ");
    outputDiv.appendChild(newParagraph);
  }
}