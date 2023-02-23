function operation(firstNum, secondNum, operator) {
  switch (operator) {
    case "+":
      console.log(firstNum + secondNum);
      break;
    case "-":
      console.log(firstNum - secondNum);
      break;
    case "*":
      console.log(firstNum * secondNum);
      break;
    case "/":
      console.log(firstNum / secondNum);
      break;
    case "%":
      console.log(firstNum % secondNum);
      break;
    case "**":
      console.log(firstNum ** secondNum);
      break;
  }
}
