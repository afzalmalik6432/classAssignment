
# ToDo Application
This is the application for tracking our activity, this application used to remember us the task which we have in our hand and which we are completed.
The basic purpose of this application help user to keep track there daily works.
# Technology Used
* Spring Boot
* Core Java and Advance java

# Tools Used
* IntelliJ IDEA
* JDK 17
* Postman

# DataFlow of Application
* Controller - This is the layer in which we are handling the request from the user and based on the user request we are implement various endpoints.
* Service - This is  the layer in which we are implementing a business logic as a static list for making in memory database for storing.
* Model - We have a todo model in which we have id, todo name and status.

# Some End Point Below
* http://localhost:8080/api/v1/todo-app/find-all
* http://localhost:8080/api/v1/todo-app/add-todo
* http://localhost:8080/api/v1/todo-app/update-todo/id/6
* http://localhost:8080/api/v1/todo-app/find-todo/id/2
* http://localhost:8080/api/v1/todo-app/delete-todo/id/5

### Note
For adding and updating data use raw Json object with the help of postman.
Please download and run on localHost.

### References to learn Spring Boot
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

