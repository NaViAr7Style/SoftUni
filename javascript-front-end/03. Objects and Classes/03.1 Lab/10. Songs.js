function solve(input) {
  class Song {
    constructor(typeList, name, time) {
      this.typeList = typeList;
      this.name = name;
      this.time = time;
    }
  }

  let songLists = [];
  let [count, ...tokens] = input;

  for (let i = 1; i <= count; i++) {
    let [typeList, name, time] = tokens.shift().split("_");
    songLists.push(new Song(typeList, name, time));
  }

  typeList = tokens[0];

  typeList === "all"
    ? songLists.forEach((song) => console.log(song.name))
    : songLists
        .filter((song) => song.typeList === typeList)
        .forEach((song) => console.log(song.name));
}