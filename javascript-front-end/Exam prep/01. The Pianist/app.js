function solve(input) {
  let n = Number(input.shift());
  let piecesCollection = {};

  for (let i = 0; i < n; i++) {
    let [piece, composer, key] = input.shift().split("|");
    piecesCollection[piece] = { composer, key };
  }

  let commandTokens = input.shift();

  while (commandTokens !== "Stop") {
    let [command, piece, ...remainingTokens] = commandTokens.split("|");

    switch (command) {
      case "Add":
        let [composer, key] = remainingTokens;

        if (piecesCollection.hasOwnProperty(piece)) {
          console.log(`${piece} is already in the collection!`);
        } else {
          piecesCollection[piece] = { composer, key };
          console.log(
            `${piece} by ${composer} in ${key} added to the collection!`
          );
        }

        break;
      case "Remove":
        if (piecesCollection.hasOwnProperty(piece)) {
          delete piecesCollection[piece];
          console.log(`Successfully removed ${piece}!`);
        } else {
          console.log(
            `Invalid operation! ${piece} does not exist in the collection.`
          );
        }

        break;
      case "ChangeKey":
        let [newKey] = remainingTokens;

        if (piecesCollection.hasOwnProperty(piece)) {
          piecesCollection[piece].key = newKey;
          console.log(`Changed the key of ${piece} to ${newKey}!`);
        } else {
          console.log(
            `Invalid operation! ${piece} does not exist in the collection.`
          );
        }

        break;
    }

    commandTokens = input.shift();
  }

  for (const piece in piecesCollection) {
    let { composer, key } = piecesCollection[piece];
    console.log(`${piece} -> Composer: ${composer}, Key: ${key}`);
  }
}