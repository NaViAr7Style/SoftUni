function calculate(...numbers) {
    return subtract(sum(numbers[0], numbers[1]), numbers[2]);

    function sum(a, b) {
        return a + b;
    }

    function subtract(a, b) {
        return a - b;
    }
}