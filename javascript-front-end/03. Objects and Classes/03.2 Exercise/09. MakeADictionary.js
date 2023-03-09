function dictionaryParser(input) {
    let dictionary = {};

    for (const line of input) {
        let term = JSON.parse(line);

        
        for (const key in term) {
            dictionary[key] = term[key];
        }
    }

    let output = Object.entries(dictionary);

    output.sort((f, s) => {
        return f[0].localeCompare(s[0]);
    })
    .forEach(([ term, definition]) => {
        console.log(`Term: ${term} => Definition: ${definition}`);
    });
}