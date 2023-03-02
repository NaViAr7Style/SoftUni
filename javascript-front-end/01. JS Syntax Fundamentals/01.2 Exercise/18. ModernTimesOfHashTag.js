function solved(text) {
    let words = text.split(" ").filter(a => a.length > 1);

    for (let i = 0; i < words.length; i++) {
        if (words[i][0] !== "#") {
            continue;
        }

        let currentWord = words[i].substring(1);

        if (!/^[a-zA-Z]+$/.test(currentWord)) {
            continue;
        }

        console.log(currentWord);
    }
}