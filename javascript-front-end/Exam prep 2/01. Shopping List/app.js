function solve(input) {
  let shoppingList = input.shift().split("!");

  let commandTokens = input.shift();
  while (commandTokens !== "Go Shopping!") {
    let command = commandTokens.split(" ")[0];
    let item = commandTokens.split(" ")[1];

    switch (command) {
      case "Urgent":
        if (!shoppingList.includes(item)) {
            shoppingList.unshift(item);
        }
        break;
      case "Unnecessary":
        if (shoppingList.includes(item)) {
            let index = shoppingList.indexOf(item)
            shoppingList.splice(index, 1);
        }
        break;
      case "Correct":
        let newItem = commandTokens.split(" ")[2];

        if (shoppingList.includes(item)) {
            let index = shoppingList.indexOf(item)
            shoppingList.splice(index, 1, newItem);
        }

        break;
      case "Rearrange":
        if (shoppingList.includes(item)) {
            let index = shoppingList.indexOf(item)
            shoppingList.splice(index, 1);
            shoppingList.push(item);
        }
        break;
    }

    commandTokens = input.shift();
  }
  
  console.log(shoppingList.join(", "));
}