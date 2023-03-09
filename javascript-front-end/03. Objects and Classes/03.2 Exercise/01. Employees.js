function parseEmployees(input) {
    // SIMPLER SOLUTION
    // for (const employee of input) {
    //     let personalNumber = employee.length;

    //     console.log(`Name: ${employee} -- Personal Number: ${personalNumber}`)
    // }

    let employees = input.reduce((data, employee) => {
        data[employee] = employee.length;
        return data;
    }, {});

    for (const key in employees) {
        console.log(`Name: ${key} -- Personal Number: ${employees[key]}`)
    }
}