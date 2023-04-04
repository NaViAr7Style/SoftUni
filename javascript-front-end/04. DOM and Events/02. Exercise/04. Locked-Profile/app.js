function lockedProfile() {
    const buttons = Array.from(document.getElementsByTagName("button"));

    for (const button of buttons) {
        button.addEventListener("click", toggleInfo);
    }

    function toggleInfo(e) {
        const currentProfile = this.parentElement;
        const lockRadioInput = currentProfile.children[2];
        const additionalInfoDiv = currentProfile.children[9];

        if (lockRadioInput.checked) {
            return;
        }

        if (this.textContent === "Show more") {
            additionalInfoDiv.style.display = "block";
            this.textContent = "Hide it";
        } else {
            additionalInfoDiv.style.display = "none";
            this.textContent = "Show more";
        }
    }
}