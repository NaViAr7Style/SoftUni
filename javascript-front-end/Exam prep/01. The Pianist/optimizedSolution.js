function solve(input) {
    let n = Number(input.shift());
    let piecesCollection = {};
    let commandParser = {
        "Add": addPiece,
        "Remove": removePiece,
        "ChangeKey": changeKey
    };

    for (let i = 0; i < n; i++) {
        const [ piece, composer, key ] = input.shift().split("|");
        piecesCollection[piece] = { composer, key };
    }

    for (const inputLine of input) {
        if (inputLine === "Stop") {
            break;
        }

        let commandTokens = inputLine.split("|");
        let command = commandTokens.shift();

        commandParser[command](...commandTokens);
    }

    for (const piece in piecesCollection) {
        const { composer, key } = piecesCollection[piece];
        console.log(`${piece} -> Composer: ${composer}, Key: ${key}`);
    }

    function addPiece(piece, composer, key) {
        if (piecesCollection.hasOwnProperty(piece)) {
            console.log(`${piece} is already in the collection!`);
        } else {
            piecesCollection[piece] = { composer, key };
            console.log(`${piece} by ${composer} in ${key} added to the collection!`);
        }

    }

    function removePiece(piece) {
        if (piecesCollection.hasOwnProperty(piece)) {
            delete piecesCollection[piece];
            console.log(`Successfully removed ${piece}!`);
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    }

    function changeKey(piece, newKey) {
        if (piecesCollection.hasOwnProperty(piece)) {
            piecesCollection[piece].key = newKey;
            console.log(`Changed the key of ${piece} to ${newKey}!`); 
        } else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    }
}