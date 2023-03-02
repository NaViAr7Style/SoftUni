function solved(args, n) {
    let filtered = [];

    for (let i = 0; i < args.length; i += n) {
        filtered.push(args[i]);
    }

    return filtered;
}