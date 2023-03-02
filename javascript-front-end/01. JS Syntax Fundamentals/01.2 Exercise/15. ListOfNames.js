function solved(args) {
    args.sort((a, b) => a.localeCompare(b));

    for (let i = 0; i < args.length; i++) {
        console.log(`${i + 1}.${args[i]}`)
    }
}