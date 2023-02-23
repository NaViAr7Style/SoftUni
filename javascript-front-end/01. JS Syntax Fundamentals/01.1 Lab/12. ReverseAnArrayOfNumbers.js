function solve (n, arr) {
    let mySlice = arr.slice(0, n);
    console.log(mySlice.reverse().join(' '));
}