function solve(headcount, groupType, dayOfWeek) {
    let price = 0;

    switch (groupType) {
        case "Students":
            switch (dayOfWeek) {
                case "Friday":
                    price = 8.45;
                    break;
                case "Saturday":
                    price = 9.80;
                    break;
                case "Sunday":
                    price = 10.46;
                    break;
            }
            break;
        case "Business":
            switch (dayOfWeek) {
                case "Friday":
                    price = 10.90;
                    break;
                case "Saturday":
                    price = 15.60;
                    break;
                case "Sunday":
                    price = 16.00;
                    break;
            }
            break;
        case "Regular":
            switch (dayOfWeek) {
                case "Friday":
                    price = 15.00;
                    break;
                case "Saturday":
                    price = 20.00;
                    break;
                case "Sunday":
                    price = 22.50;
                    break;
            }
            break;
    }

    let totalPrice = headcount * price;

    if (groupType === "Students" && headcount >= 30) {
        totalPrice *= 0.85;
    }

    if (groupType === "Business" && headcount >= 100) {
        let newHeadcount = headcount - 10;
        totalPrice = newHeadcount * price;
    }

    if (groupType === "Regular" && 10 <= headcount && headcount <= 20) {
        totalPrice *= 0.95;
    }

    console.log(`Total price: ${totalPrice.toFixed(2)}`);
}