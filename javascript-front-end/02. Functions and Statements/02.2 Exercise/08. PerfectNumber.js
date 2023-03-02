function isPerfectNum(num) {
    let divisors = [1];

    for (let i = 2; i <= num / 2; i++) {
        if (num % i === 0) {
            divisors.push(i);
        }
    }

    if (num === divisors.reduce((a, b) => a + b, 0)) {
        console.log("We have a perfect number!");
    } else {
        console.log("It's not so perfect.");

    }
}