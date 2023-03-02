function solved(wordsToFill, text) {
    let words = wordsToFill.split(", ");
    words.sort(function(a, b) {
        return a.length - b.length;
    })

    while (text.indexOf("*") !== -1) {
        let startIndex = text.indexOf("*");
        let currentIndex = startIndex;
        let count = 0;

        while (text[currentIndex] === "*") {
            currentIndex++;
            count++;
        }

        let neededWord;

        for (let i = 0; i < words.length; i++) {
            if (words[i].length === count) {
                neededWord = words[i];
                break;
            }
        }

        text = text.substring(0, startIndex) + neededWord + text.substring(startIndex + count, text.length);
    }

    console.log(text);
}