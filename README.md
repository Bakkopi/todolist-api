# Spring Boot Todo List API

This is a simple Spring Boot application for managing a todo list. 

It provides CRUD operations, search filtering and sorting, user-associated tasks, and tagging functionalities. 

## Dependencies

- Java 17
- Spring Boot 3.2.1
- Spring Data JPA
- MySQL Database

## Setup

1. Clone the repository.
    ```bash
    git clone https://github.com/Bakkopi/todolist-api
   ```

2. Ensure MySQL is installed and setup. Instructions are provided [here](https://www.javatpoint.com/how-to-install-mysql).

3. Create a new `.env` file in the `src/main/resources` folder.

4. Assign your MySQL user login credentials in the `.env` file (Refer to [`.env.example`](src/main/resources/.env.example) for the template)
   ```bash
   MYSQLDB_DBNAME = "todolist"
   MYSQLDB_USERNAME = "root"
   MYSQLDB_ROOT_PASSWORD = "yourPasswordHere"
   ```
   
5. Build and run the project using your Java IDE of choice (IntelliJ IDEA recommended)

6. Populate tables with dummy data by running the [`dummyData.sql`](dummyData.sql) script on MySQL CLI.
   ```bash
   mysql> USE todolist;
   mysql> source {Absolute path to dummyData.sql}
   ```
   
## Usage

1. Ensure all setup steps have been followed and run the API application. ([http://localhost:8080](http://localhost:8080)). 
2. Import the Postman Collection (`Todo List API.postman_collection.json`) provided into your local Postman.
3. Send and modify requests according to the templates provided. Have fun!
