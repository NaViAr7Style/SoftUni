function loadingBar(num) {
    let barCompletion = num / 10;

    if (barCompletion === 10) {
        console.log("100% Complete!");
        return;
    }

    let bar = `${num}% [${"%".repeat(barCompletion)}${".".repeat(10 - barCompletion)}]`;

    console.log(bar);
    console.log("Still loading...");
}