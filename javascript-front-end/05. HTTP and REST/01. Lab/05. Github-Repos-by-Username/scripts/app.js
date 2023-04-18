async function loadRepos() {
  const userInput = document.getElementById("username");
  const ulContainer = document.getElementById("repos");
  const userVal = userInput.value;
  const BASE_URL = "https://api.github.com/users/";

  ulContainer.replaceChildren();

  try {
    let allUserRepos = await fetch(`${BASE_URL}${userVal}/repos`);
    let data = await allUserRepos.json();

    data.forEach((element) => {
      let li = document.createElement("li");
      let href = document.createElement("a");
      href.textContent = element.full_name;
      href.href = element.html_url;
      li.appendChild(href);
      ulContainer.appendChild(li);
    });
  } catch (err) {
    let li = document.createElement("li");
	li.textContent = err.message;
    ulContainer.appendChild(li);
  }
}