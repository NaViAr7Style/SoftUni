function formatGrade(grade) {
    let gradeDescription = "";

    if (grade < 3) {
        gradeDescription = "Fail";
        return `${gradeDescription} (${Math.floor(grade)})`;
    } else if (grade < 3.50) {
        gradeDescription = "Poor";
    } else if (grade < 4.50) {
        gradeDescription = "Good";
    } else if (grade < 5.50) {
        gradeDescription = "Very good";
    } else {
        gradeDescription = "Excellent";
    }

    return `${gradeDescription} (${grade.toFixed(2)})`;
}