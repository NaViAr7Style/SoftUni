function solved(text) {
    let words = text.split(" ").filter(a => a.length > 1);

    for (const word of words) {
        if (word[0] !== "#") {
            continue;
        }

        let currentWord = word.substring(1);

        if (!/^[a-zA-Z]+$/.test(currentWord)) {
            continue;
        }

        console.log(currentWord);
    }
}