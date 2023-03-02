function sumEvenAndOdd(number) {
    let evenSum = 0, oddSum = 0;

    while (number > 0) {
        let digit = number % 10;

        if (digit % 2 === 0) {
            evenSum += digit;
        } else {
            oddSum += digit;
        }
        
        number = Math.floor(number / 10);
    }

    return `Odd sum = ${oddSum}, Even sum = ${evenSum}`;
}