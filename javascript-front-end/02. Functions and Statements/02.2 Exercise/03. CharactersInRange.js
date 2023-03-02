function printAsciiSymbols(firstChar, secondChar) {
    let start = Math.min(firstChar.charCodeAt(0), secondChar.charCodeAt(0));
    let end = Math.max(firstChar.charCodeAt(0), secondChar.charCodeAt(0));

    let charsArray = [];

    for (let i = start + 1; i < end; i++) {
        charsArray.push(String.fromCharCode(i));
    }

    console.log(charsArray.join(" "));
}