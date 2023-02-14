# User Management System
User Management System is the backend system which is maintaining user details.
Currently, we are using a static list in this system and we can replace this static list
with any database as per our need.

### Technology Used
* JDK 17
* Spring boot
* Rest Api
* Lombok
* Open Api definition

### Tools Used
* IntelliJ Idea
* Postman
* Google chrome

### localHost EndPoints
For adding and updating a data use raw json object from the postman.
While update a user data please pass request parameter as in form of key value pair.
Key is constant **userId** and value is in **Integer**.

* [Getting All User](http://localhost:8080/api/v1/user/getUsers)
* [Getting User by id](http://localhost:8080/api/v1/user/getUser/1)
* [Adding User](http://localhost:8080/api/v1/user/addUser)
* [Updating User](http://localhost:8080/api/v1/user/updateUser)
* [Deleting User by id](http://localhost:8080/api/v1/user/deleteUser)


### Guides and Documentation to Develop Spring Boot Applications
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

