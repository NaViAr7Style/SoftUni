function convertToJson(name, lastName, hairColor) {
    let person = {
        name,
        lastName,
        hairColor
    }

    let jsonString = JSON.stringify(person);

    return jsonString;
}