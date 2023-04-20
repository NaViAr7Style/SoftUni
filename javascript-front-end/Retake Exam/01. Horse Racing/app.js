function solve(input) {
  let horsePositions = input.shift().split("|");
  const commandParser = {
    Retake: retakeHorse,
    Trouble: getInTrouble,
    Rage: enrageHorse,
    Miracle: performAMiracle,
  };

  let commandTokens = input.shift().split(" ");
  while (commandTokens[0] !== "Finish") {
    let command = commandTokens.shift();
    commandParser[command](...commandTokens);
    commandTokens = input.shift().split(" ");
  }

  console.log(horsePositions.join("->"));
  console.log(`The winner is: ${horsePositions[horsePositions.length - 1]}`);

  function retakeHorse(overtakingHorse, overtakenHorse) {
    let overtakingIndex = horsePositions.indexOf(overtakingHorse);
    let overtakenIndex = horsePositions.indexOf(overtakenHorse);

    if (overtakingIndex < overtakenIndex) {
      horsePositions[overtakingIndex] = overtakenHorse;
      horsePositions[overtakenIndex] = overtakingHorse;
      console.log(`${overtakingHorse} retakes ${overtakenHorse}.`);
    }
  }

  function getInTrouble(horse) {
    let horseIndex = horsePositions.indexOf(horse);

    if (horseIndex > 0) {
      let temp = horsePositions[horseIndex - 1];
      horsePositions[horseIndex] = temp;
      horsePositions[horseIndex - 1] = horse;
      console.log(`Trouble for ${horse} - drops one position.`);
    }
  }

  function enrageHorse(horse) {
    let horseIndex = horsePositions.indexOf(horse);
    let lastIndex = horsePositions.length - 1;

    if (lastIndex - horseIndex >=2) {
        let onePositionAhead = horsePositions[horseIndex + 1];
        let twoPositionsAhead = horsePositions[horseIndex + 2];

        horsePositions[horseIndex] = onePositionAhead;
        horsePositions[horseIndex + 1] = twoPositionsAhead;
        horsePositions[horseIndex + 2] = horse;

    } else if (lastIndex - horseIndex === 1) {
        let temp = horsePositions[horseIndex + 1];
        horsePositions[horseIndex] = temp;
        horsePositions[horseIndex + 1] = horse; 
    }

    console.log(`${horse} rages 2 positions ahead.`);
  }

  function performAMiracle() {
    for (let i = 0; i < horsePositions.length - 1; i++) {
        let temp = horsePositions[i];
        horsePositions[i] = horsePositions[i + 1];
        horsePositions[i + 1] = temp;
    }

    console.log(`What a miracle - ${horsePositions[horsePositions.length - 1]} becomes first.`)
  }
}