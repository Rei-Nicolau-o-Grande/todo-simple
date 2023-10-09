const url = "http://localhost:8080/task/user/4";

function hideLoader() {
    document.getElementById("loading").style.display = "none";
}

function show(tasks) {
    let tab = `<thead>
            <th scope="col">#</th>
            <th scope="col">Description</th>
        </thead>`;

    for (let task of tasks) {
        tab += `
            <tr>
                <td scope="row">${task.id}</td>
                <td>${task.description}</td>
            </tr>
        `;
    }

    document.getElementById("tasks").innerHTML = tab;
}

async function getTasks(url) {
    let response = await fetch(url,
        {
            method: "GET"
        }
    );
    let data = await response.json();

    console.log(data);

    if (response) hideLoader();
    show(data);

}

getTasks(url);