function findOccurrences(input) {
    let searchedWords = input.shift().split(" ");
    let wordsFound = {};

    for (const word of searchedWords) {
        let count = input.filter((w) => w === word).length;
        wordsFound[word] = count;
    }

    let result = Object.entries(wordsFound);

    result.sort((f, s) => {
        return s[1] - f[1];
    })
    .forEach((w) => {
        console.log(`${w[0]} - ${w[1]}`);
    });
}