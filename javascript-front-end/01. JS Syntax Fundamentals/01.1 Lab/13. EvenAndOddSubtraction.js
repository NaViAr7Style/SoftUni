function solve (arr) {
    let even = 0;
    let odd = 0;

    for (const num of arr) {
        if (num % 2 === 0) {
            even += num;
        } else {
            odd += num;
        }
    }

    console.log(even - odd);
}