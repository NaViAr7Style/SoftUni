function printAsciiSymbols(firstChar, secondChar) {
    let first, second;

    if (firstChar < secondChar) {
        first = firstChar.charCodeAt(0);
        second = secondChar.charCodeAt(0);
    } else {
        first = secondChar.charCodeAt(0);
        second = firstChar.charCodeAt(0);
    }

    let charsArray = [];

    for (let i = first + 1; i < second; i++) {
        charsArray.push(String.fromCharCode(i));
    }

    console.log(charsArray.join(" "));
}