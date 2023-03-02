function order(product, quantity) {
  let price = 0;

  switch (product) {
    case "coffee":
      price = 1.5;
      break;
    case "coke":
      price = 1.4;
      break;
    case "water":
      price = 1.0;
      break;
    case "snacks":
      price = 2.0;
      break;
  }

  let totalPrice = price * quantity;

  console.log(totalPrice.toFixed(2));
}