function findOddOccurrences(input) {
    let words = input.split(" ");
    let oddCounts = {};

    for (const word of words) {
        wordLowerCase = word.toLowerCase();

        if (!oddCounts.hasOwnProperty(wordLowerCase)) {
            oddCounts[wordLowerCase] = 0;
        }

        oddCounts[wordLowerCase]++;
    }

    let output = [];

    Object.entries(oddCounts)
    .filter(([ _word, count ]) => count % 2 === 1)
    .forEach(([ word, _count ]) => {
        output.push(word);
    })

    console.log(output.join(" "));
}