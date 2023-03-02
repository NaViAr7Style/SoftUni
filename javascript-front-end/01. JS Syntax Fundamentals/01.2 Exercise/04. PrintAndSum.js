function solved(num1, num2) {
    let numbers = [];
    let sum = 0;

    for (let i = num1; i <= num2; i++) {
        numbers.push(i);
        sum += i;
    }

    let output = numbers.join(" ");
    
    console.log(output);
    console.log(`Sum: ${sum}`);
}