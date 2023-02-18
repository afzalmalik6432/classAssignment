# UserManagement Validation Project
This project is used to valid the input data which is entered by the user.
In this project we are validation user email, phone number, username and date of birth.
### Frameworks and language used
* Spring MVC
* Spring Boot
* Java 17
* Collection framework
* H2 DataBase
### Tools Used
* IntelliJ Idea
* JDK 17
* Maven build tool
* Postman
### Data Structure Used

* Collection Api
* Regular Expression and Pattern matching

# Data flow(functions in used)
* Controller :- We have userContoller in which we have function like addUser(@RequestBody String user), deleteUser(@RequestParam Integer userId),
getUserById(Integer userId), getAllUser() and updateUser(@RequestBody String user, @RequestParam Integer userId). After collecting the request at controller we are forwarding this request to the business layer. 
* Service Layer :- This layer collect the data from the controller layer and act as a business layer, where all of our business logic written and this layer also connected with repository layer.
* Repository Layer :- This layer collect the data and request from the service layer and provide the necessary data from the database to the service layer, this layer also help to connect with database.
## Some Endpoints

* [Adding user data](localhost:8080/api/v1/user/adduser)
* [Get all users](localhost:8080/api/v1/user/getAllUser)
* [Get User by userId](localhost:8080/api/v1/user/getUser/2)
* [Update user](localhost:8080/api/v1/user/updateUser?userId=1)
* [Delete user](localhost:8080/api/v1/user/deleteUser?userId=2)

### Note :- Use Json raw object or text to pass data with postman



