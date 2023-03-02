function divideFactorials(firstNum, secondNum) {
    let firstFactorial = calculateFactorial(firstNum);
    let secondFactorial = calculateFactorial(secondNum);

    let result = firstFactorial / secondFactorial;

    console.log(result.toFixed(2));

    function calculateFactorial(num) {
        if (num === 1) {
            return 1;
        }

        return num * calculateFactorial(num - 1);
    }
}