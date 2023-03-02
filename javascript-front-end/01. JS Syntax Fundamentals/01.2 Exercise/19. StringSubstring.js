function solved(word, text) {
    let wordLowerCase = word.toLowerCase();
    let textArr = text.toLowerCase().split(" ");

    for (let currentWord of textArr) {
        if (currentWord === wordLowerCase) {
            return currentWord;
        }
    }

    return `${word} not found!`;
}