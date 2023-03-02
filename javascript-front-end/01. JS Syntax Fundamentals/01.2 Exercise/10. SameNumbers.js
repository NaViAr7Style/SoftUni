function solved(num) {
    let digit = num % 10;
    let isSameDigit = true;
    let sum = 0;

    while (num > 0) {
        let currentDigit = num % 10;
        sum += currentDigit;
        num = Math.floor(num / 10);

        if (currentDigit !== digit) {
            isSameDigit = false;
        }
    }

    console.log(isSameDigit);
    console.log(sum);
}