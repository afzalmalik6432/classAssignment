
# Custom Query Application
This is the application in which we are using a native query as well as custom methods for fetching a data from the database.

# Technology Used
* Spring Boot
* MySql
* Core Java

# Tools Used
* IntelliJ IDEA
* JDK 17
* Postman

# DataFlow of Application
* Controller - This is the layer in which we handling the request from the user and based on the user request we are implement various endpoints.
* Service - This is  the layer which is used to communicate with repository layer as well as with controller layer
* Repository - In repository layer we have different methods, In this repository layer we wrote a numbers of methods for custom query as well as custom methods. 
* Database Design - In our database we have a one table in which we have six Fields.

# Some End Point Below
* http://localhost:8080/api/v1/student
* http://localhost:8080/api/v1/studentById?id=1
* http://localhost:8080/api/v1/studentByfirstName?firstName=Shama
* http://localhost:8080/api/v1/studentByfirstNameQuery?firstName=Ayan

### Note
For adding a data to database used raw Json object with the help of postman
Please download and run on localHost.

### References to learn Spring Boot
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

