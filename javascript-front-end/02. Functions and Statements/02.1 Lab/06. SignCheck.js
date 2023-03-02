function checkSign(...numbers) {
    let negativeSignCounter = 0;

    for (let number of numbers) {
        if (number < 0) {
            negativeSignCounter++;
        }
    }

    if (negativeSignCounter % 2 === 0) {
        console.log("Positive");
    } else {
        console.log("Negative");
    }
}