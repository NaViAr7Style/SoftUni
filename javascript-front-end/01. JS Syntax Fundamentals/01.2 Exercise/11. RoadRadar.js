function solved(speed, area) {
    let speedLimit = 0;

    switch (area) {
        case "motorway":
            speedLimit = 130;
            break;
        case "interstate":
            speedLimit = 90;
            break;
        case "city":
            speedLimit = 50;
            break;
        case "residential":
            speedLimit = 20;
            break;
    }

    let speedDifference = speed - speedLimit;

    if (speedDifference <= 0) {
        console.log(`Driving ${speed} km/h in a ${speedLimit} zone`)
    } else if (speedDifference <= 20) {
        console.log(`The speed is ${speedDifference} km/h faster than the allowed speed of ${speedLimit} - speeding`);
    } else if (speedDifference <= 40) {
        console.log(`The speed is ${speedDifference} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`);
    } else {
        console.log(`The speed is ${speedDifference} km/h faster than the allowed speed of ${speedLimit} - reckless driving`);
    }
}