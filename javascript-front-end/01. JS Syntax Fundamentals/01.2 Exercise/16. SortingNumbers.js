function solved(args) {
    let sorted = [];
    args.sort((a, b) => a - b);

    for (let i = 0; i < args.length / 2; i++) {
        sorted.push(args[i]);
        sorted.push(args[args.length - i - 1]);
    }

    if (args.length % 2 !== 0) {
        sorted.pop();
    }

    return sorted;
}