const todoList = document.getElementById('todoList');
const updateForm = document.getElementById('updateForm');
let currentTodoId = null; // Speichert die ID des zu bearbeitenden To-Dos

// Neues To-Do erstellen
document.getElementById('todoForm').addEventListener('submit', async (event) => {
    event.preventDefault(); // Verhindert das Standard-Formularverhalten

    const title = document.getElementById('title').value;
    const completed = document.getElementById('completed').checked;

    const response = await fetch('http://localhost:8080/api/todos', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, completed })
    });

    if (response.ok) {
        document.getElementById('title').value = "";
        document.getElementById('completed').checked = false;
        fetchTodos();
    } else {
        alert('Fehler beim Erstellen des To-Dos.');
    }
});

// To-Do-Liste abrufen
async function fetchTodos() {
    const response = await fetch('http://localhost:8080/api/todos');
    const todos = await response.json();

    todoList.innerHTML = '';
    todos.forEach(todo => {
        const listItem = document.createElement('li');

        const textSpan = document.createElement('span');
        textSpan.textContent = todo.title + (todo.completed ? ' (erledigt)' : '');
        listItem.appendChild(textSpan);

        // Bearbeiten-Button
        const editButton = document.createElement('button');
        editButton.textContent = 'Bearbeiten';
        editButton.className = "liButton";
        editButton.style.marginLeft = '10px';
        editButton.addEventListener('click', () => {
            currentTodoId = todo;
            updateTitle.value = todo.title;
            updateCompleted.checked = todo.completed;
            currentTodoId = todo.id; 
            updateForm.style.display = 'block';
        });

        // Löschen-Button
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Löschen';
        deleteButton.className = "liButton";
        deleteButton.style.marginLeft = '10px';
        deleteButton.addEventListener('click', async () => {
            await fetch(`http://localhost:8080/api/todos/${todo.id}`, { method: 'DELETE' });
            fetchTodos(); 
        });

        listItem.appendChild(editButton);
        listItem.appendChild(deleteButton);
        todoList.appendChild(listItem);
    });
}

// To-Do aktualisieren
updateForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const updatedTitle = document.getElementById('updateTitle').value;
    const updatedCompleted = document.getElementById('updateCompleted').checked;

    const response = await fetch(`http://localhost:8080/api/todos/${currentTodoId}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: updatedTitle, completed: updatedCompleted })
    });

    if (response.ok) {
        updateForm.style.display = 'none';
        fetchTodos(); 
        currentTodoId = null;
    } else {
        alert('Fehler beim Aktualisieren des To-Dos.');
    }
});

fetchTodos();