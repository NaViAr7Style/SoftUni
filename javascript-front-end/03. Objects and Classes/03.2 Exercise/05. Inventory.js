function inventory(input) {
    let heroes = [];

    for (const line of input) {
        let [nickname, level,items] = line.split(" / ");
        level = Number(level);
        heroes.push({ nickname, level, items});
    }

    heroes.sort((f, s) => {
        return f.level - s.level;
    })
    .forEach((h) => {
        console.log(`Hero: ${h.nickname}`);
        console.log(`level => ${h.level}`);
        console.log(`items => ${h.items}`);
    });
}