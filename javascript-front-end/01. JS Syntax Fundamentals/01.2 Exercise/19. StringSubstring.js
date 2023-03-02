function solved(wordToFind, text) {
    let searchedWord = wordToFind.toLowerCase();
    words = text.toLowerCase().split(" ");

    for (let word of words) {
        if (word === searchedWord) {
            console.log(wordToFind);
            return;
        }
    }

    console.log(`${wordToFind} not found!`);
}