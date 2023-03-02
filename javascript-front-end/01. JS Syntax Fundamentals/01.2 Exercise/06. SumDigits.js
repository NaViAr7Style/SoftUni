function solved(num) {
    let sum = 0;

    while (num > 0) {
        let remainder = num % 10;
        sum += remainder;
        num = Math.floor(num / 10);
    }

    console.log (sum);
}