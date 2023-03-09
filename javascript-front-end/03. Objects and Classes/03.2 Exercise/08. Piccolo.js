function piccolo(input) {
    let carNumbers = new Set();

    for (const line of input) {
        let [ command, carNum] = line.split(", ");

        if (command === "IN") {
            carNumbers.add(carNum);
        } else if (command === "OUT") {
            carNumbers.delete(carNum)
        }
    }



    if (carNumbers.size === 0) {
        console.log("Parking Lot is Empty");
    } else {
        Array.from(carNumbers)
        .sort((f, s) => f.localeCompare(s))
        .forEach((carNum) => {
            console.log(carNum);
        });
    }

}