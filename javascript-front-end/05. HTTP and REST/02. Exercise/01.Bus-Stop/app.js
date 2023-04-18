async function getInfo() {
    const BASE_URL = "http://localhost:3030/jsonstore/bus/businfo/";
    const busStop = document.getElementById("stopId").value;
    const stopNameDiv = document.getElementById("stopName");
    const ulContainer = document.getElementById("buses");
    
    ulContainer.replaceChildren();
    stopNameDiv.textContent = "";

    try {
        let busStopRes = await fetch(`${BASE_URL}${busStop}`);
        let data = await busStopRes.json();

        stopNameDiv.textContent = data.name;

        for (const busId in data.buses) {
            const li = document.createElement("li");
            li.textContent = `Bus ${busId} arrives in ${data.buses[busId]} minutes`;
            ulContainer.appendChild(li);
        }

    } catch(e) {
        stopNameDiv.textContent = "Error";
    }
}