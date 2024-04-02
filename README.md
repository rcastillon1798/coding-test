# Simple Notes API
This is a simple RESTful API for managing notes. It allows users to perform CRUD (Create, Read, Update, Delete) operations on notes.

# Endpoints
POST /notes: Create a new note.

GET /notes: Retrieve all notes.

GET /notes/{id}: Retrieve a specific note by ID.

PUT /notes/{id}: Update a specific note.

DELETE /notes/{id}: Delete a specific note.

### Running the API
To run the API, follow these steps:

Ensure you have Java JDK and Maven installed on your system.
Clone this repository or download the source code.
Navigate to the project directory in your terminal.

Since it's a Spring applications, it's as simple as running the Main method in the `Application.java` class.
The API server will start on http://localhost:8080.

### Usage
You can use tools like Postman or cURL to interact with the API endpoints:
For convenience, postman collections are already created based on the api request located in resources folder in main/java directory

### Create a Note
Send a POST request to http://localhost:8080/notes with a JSON payload containing the note data:

json
Copy code
{
"title": "Note Title",
"body": "Note Body"
}

### Retrieve All Notes
Send a GET request to http://localhost:8080/notes to retrieve all notes.

### Retrieve a Specific Note
Send a GET request to http://localhost:8080/notes/{id} to retrieve a specific note by its ID.

### Update a Note
Send a PUT request to http://localhost:8080/notes/{id} with a JSON payload containing the updated note data:

json
Copy code
{
"title": "Updated Note Title",
"body": "Updated Note Body"
}

### Delete a Note
Send a DELETE request to http://localhost:8080/notes/{id} to delete a specific note by its ID.

### Assumptions
The API uses an in-memory list to store notes. Data is not persisted between application restarts.
No authentication or authorization is implemented for simplicity.
The API assumes that the client will provide valid data when creating or updating notes. 