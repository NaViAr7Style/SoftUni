function printSmallestNumber(...numbers) {
    let min = Number.MAX_SAFE_INTEGER;

    for (const num of numbers) {
        if (num < min) {
            min = num;
        }
    }

    console.log(min);
}