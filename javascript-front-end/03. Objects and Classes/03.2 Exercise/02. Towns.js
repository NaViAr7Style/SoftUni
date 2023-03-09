function parseTowns(input) {
    for (const line of input) {
        let [town, lattitude, longitude] = line.split(" | ");
        let townObj = {town, 
            latitude: Number(lattitude).toFixed(2), 
            longitude: Number(longitude).toFixed(2)
        }

        console.log(townObj);
    }
}