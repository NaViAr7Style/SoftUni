function meetingScheduler(input) {
    let calendar = {};

    for (const meeting of input) {
        let [day, person] = meeting.split(" ");

        if (!calendar.hasOwnProperty(day)) {
            calendar[day] = person;
            console.log(`Scheduled for ${day}`);
        } else {
            console.log(`Conflict on ${day}!`);
        }
    }

    for (const key in calendar) {
        console.log(`${key} -> ${calendar[key]}`);
    }
}