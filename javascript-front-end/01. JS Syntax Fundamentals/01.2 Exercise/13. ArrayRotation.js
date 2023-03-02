function solved(args, rotations) {
    for (let i = 1; i <= rotations; i++) {
        let firstEl = args.shift();
        args.push(firstEl);
    }

    console.log(args.join(" "));
}