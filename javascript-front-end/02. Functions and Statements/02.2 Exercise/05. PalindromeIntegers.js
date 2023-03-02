function palindromeCheck(numbers) {
    for (const num of numbers) {
        let numAsString = num.toString();
        let isPalindrome = true;

        for (let i = 0; i < numAsString.length / 2; i++) {
            let frontDigit = numAsString[i];
            let endDigit = numAsString[numAsString.length - i - 1];

            if (frontDigit !== endDigit) {
                isPalindrome = false;
                break
            }
        }

        console.log(isPalindrome);
    }
}