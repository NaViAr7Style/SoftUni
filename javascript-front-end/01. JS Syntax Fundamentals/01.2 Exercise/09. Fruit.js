function solved(fruit, weight, pricePerKg) {
    let weightInKg = weight / 1000;
    let money = weightInKg * pricePerKg;

    console.log (`I need $${money.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${fruit}.`);
}