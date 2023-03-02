function isValidPass(password) {
    let isValid = true;

    if (password.length < 6 || 10 < password.length) {
        isValid = false;
        console.log("Password must be between 6 and 10 characters");
    }

    if (!(/^[a-zA-Z0-9]+$/.test(password))) {
        isValid = false;
        console.log("Password must consist only of letters and digits");
    }

    let digitCounter = 0;

    for (let i = 0; i < password.length; i++) {
        if (!isNaN(password[i] * 1)) {
            digitCounter++;
        }

        if (digitCounter === 2) {
            break;
        }
    }

    if (digitCounter !== 2) {
        isValid = false;
        console.log("Password must have at least 2 digits");
    }

    if (isValid) {
        console.log("Password is valid");
    }
}