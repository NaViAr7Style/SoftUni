function sumTable() {
    const costs = Array.from(document.querySelectorAll("td:nth-child(even)"));
    const sumElement = costs.pop();

    let totalSum = 0;

    costs.forEach((e) => {
        totalSum += Number(e.textContent);
    });

    sumElement.textContent = totalSum;
}