const API_URL = "/tasks";

async function loadTasks() {

    const response = await fetch(API_URL);
    const tasks = await response.json();

    const taskList = document.getElementById("taskList");

    taskList.innerHTML = "";

    tasks.forEach(task => {

        const taskItem = document.createElement("div");

        taskItem.className = "task-item";

        taskItem.innerHTML = `
        
            <div class="task-left">

                <input
                    type="checkbox"
                    ${task.completed ? "checked" : ""}
                    onchange="toggleTask(${task.id}, '${task.title}', this.checked)"
                >

                <div>

                    <span class="${task.completed ? "completed" : ""}">
                        ${task.title}
                    </span>

                    <div style="
                        font-size:14px;
                        margin-top:5px;
                        color:gray;
                    ">
                        Status:
                        ${task.completed
                            ? "Completed ✅"
                            : "Incomplete ⏳"}
                    </div>

                </div>

            </div>

            <div class="action-buttons">

                <button
                    class="edit-btn"
                    onclick="editTask(${task.id}, '${task.title}', ${task.completed})">
                    Edit
                </button>

                <button
                    class="delete-btn"
                    onclick="deleteTask(${task.id})">
                    Delete
                </button>

            </div>
        `;

        taskList.appendChild(taskItem);
    });
}

async function addTask() {

    const input = document.getElementById("taskInput");

    const title = input.value.trim();

    if (title === "") {

        alert("Task title cannot be empty");

        return;
    }

    await fetch(API_URL, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            title: title,
            completed: false
        })
    });

    input.value = "";

    loadTasks();
}

async function toggleTask(
    id,
    title,
    completed
) {

    await fetch(`${API_URL}/${id}`, {

        method: "PUT",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            title: title,
            completed: completed
        })
    });

    loadTasks();
}

async function editTask(
    id,
    currentTitle,
    completed
) {

    const newTitle = prompt(
        "Edit Task",
        currentTitle
    );

    if (
        newTitle === null ||
        newTitle.trim() === ""
    ) {
        return;
    }

    await fetch(`${API_URL}/${id}`, {

        method: "PUT",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            title: newTitle,
            completed: completed
        })
    });

    loadTasks();
}

async function deleteTask(id) {

    const confirmDelete = confirm(
        "Are you sure you want to delete this task?"
    );

    if (!confirmDelete) {
        return;
    }

    await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    });

    loadTasks();
}

loadTasks();