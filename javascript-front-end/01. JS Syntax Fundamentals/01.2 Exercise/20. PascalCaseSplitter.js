function solved(text) {
    let result = text.split(/(?=[A-Z])/);
    console.log(result.join(", "));
}