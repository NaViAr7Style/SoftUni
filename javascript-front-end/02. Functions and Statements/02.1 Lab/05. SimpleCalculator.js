function calculate(num1, num2, operator) {
    const add = (a, b) => a + b;
    const subtract = (a, b) => a - b;
    const multiply = (a, b) => a * b;
    const divide = (a, b) => a / b;

    const operation = {
        add,
        subtract,
        divide,
        multiply
    }

    return operation[operator](num1, num2);
}