async function loadCommits() {
    const BASE_URL = "https://api.github.com/repos/";
    const username = document.getElementById("username");
    const repo = document.getElementById("repo");
    const ulContainer = document.getElementById("commits");
    const usernameVal = username.value;
    const repoVal = repo.value;

    ulContainer.replaceChildren();

    try {
        const allCommitsRes = await fetch(`${BASE_URL}${usernameVal}/${repoVal}/commits`);
        const data = await allCommitsRes.json();
    
        data.forEach((element) => {
            const li = document.createElement("li");
            li.textContent = `${element.commit.author.name}: ${element.commit.message}`;
            ulContainer.appendChild(li);
        })
    } catch(err) {
        const li = document.createElement("li");
        li.textContent = `Error: 404 (Not found)`;
        ulContainer.appendChild(li);
    }
}