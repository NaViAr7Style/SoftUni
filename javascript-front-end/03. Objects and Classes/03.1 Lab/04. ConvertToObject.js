function convertToObject(jsonString) {
    let obj = JSON.parse(jsonString);

    for (const key in obj) {
        console.log(`${key}: ${obj[key]}`);
    }
}