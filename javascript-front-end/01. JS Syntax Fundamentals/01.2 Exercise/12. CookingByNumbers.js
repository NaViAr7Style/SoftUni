function solved(arg, ...operations) {
    let num = parseFloat(arg);

    while (operations.length > 0) {
        let operation = operations.shift();

        switch (operation) {
            case "chop":
                num /= 2;
                break;
            case "dice":
                num = Math.sqrt(num);
                break;
            case "spice":
                num++
                break;
            case "bake":
                num *= 3;
                break;
            case "fillet":
                num *= 0.8;
                break;
        }

        console.log(num);
    }
}