function solve(input) {
    let n = input.shift();
    let sprintCollection = {};

    for (let i = 0; i < n; i++) {
        const [ assignee, taskId, title, status, points ] = input.shift().split(":");
        addProperty(sprintCollection, assignee)
        addProperty(sprintCollection[assignee], taskId, { title, status, points });
    }

    function addProperty(object, propName, propValue) {
        object[propName] = propValue;
    }
}

solve([
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Kiril:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Peter:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
]
);