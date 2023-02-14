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

###Some ScreenShot For Reference
![userManagement1](https://user-images.githubusercontent.com/53900505/218702269-2299831c-5cac-4b5d-8374-2a19850de228.png)
![userManagement2](https://user-images.githubusercontent.com/53900505/218703338-cc9630b2-b53b-49a7-9df7-49723ce4a4b8.png)
![userManagement3](https://user-images.githubusercontent.com/53900505/218703346-fae3bd6d-5fb4-4fde-9e69-4c51dd03e275.png)
![userManagement4](https://user-images.githubusercontent.com/53900505/218703350-0fabf20a-db08-40ae-b648-dcb91b398bdf.png)
![userManagement5](https://user-images.githubusercontent.com/53900505/218703359-55d02abe-43f0-4788-a47e-8a48cca4f27c.png)
![userManagement6](https://user-images.githubusercontent.com/53900505/218703367-77556054-970a-4065-a838-d649473ffe8f.png)


### Guides and Documentation to Develop Spring Boot Applications
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

