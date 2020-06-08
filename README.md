# Books Universe

## Spring Boot Application using Spring Data JPA

:heavy_check_mark: Relational Model Classes:
  - Author: **src/main/java/com/project/entities/Author.java** 
  - Book: **src/main/java/com/project/entities/Book.java**
  - Library: **src/main/java/com/project/entities/Library.java**


:heavy_check_mark: CRUD operations
 - Entities: **src/main/java/com/project/entities/**
 - DTO: **src/main/java/com/project/dto/**
 - Controllers: **src/main/java/com/project/controllers/** 
 - Repositories: **src/main/java/com/project/repositories/**
 - Services: **src/main/java/com/project/services/**
 
 
:heavy_check_mark: Create REST services
   - Entities: **src/main/java/com/project/entities/**
   - DTO: **src/main/java/com/project/dto/**
   - Controllers: **src/main/java/com/project/controllers/** 
   - Repositories: **src/main/java/com/project/repositories/**
   - Services: **src/main/java/com/project/services/** 
   
 :heavy_check_mark: Relational Database: PostgreSQL
  
  
 :heavy_check_mark: Algorithm
   - **src/main/java/com/project/algorithm/BestBooksForLibraryAlgorithm.java**
   - BestBooksForLibraryAlgorithm is a algorithm which has as input an id of a library (which has a specified budget) 
    and an id of an author. The algorithm outputs a list of books (each book having a price and a review - min. 1, max 5)
    by this author (specified by his id) which this library can afford and are the most profitable 
    (the ratio between price and review is the minimum) 
    
    
 :heavy_check_mark: UnitTests
   - **src/test/java/com/project/ProjectApplicationTests.java**
   - **Testing/Tests.png**
 
 
 :heavy_check_mark: Integration with [Swagger](https://swagger.io/)
   - Configuration: **src/main/java/com/project/swagger/SpringFoxConfig.java**
   
 :heavy_check_mark: Deployment using [Heroku](https://heroku.com/)
   - Configuration: **src/main/java/com/project/swagger/SpringFoxConfig.java**
  

## UML Diagram - Classes
![Class-Diagram](https://github.com/DianaCrainic/AP-Final_Project/blob/master/Diagrams/Class-Diagram.png?raw=true)



## Use-Case: Book
![Use-Case1](https://github.com/DianaCrainic/AP-Final_Project/blob/master/Diagrams/Use-Cases/Use-Case_Book.png?raw=true)


## Use-Case: Author
![Use-Case2](https://github.com/DianaCrainic/AP-Final_Project/blob/master/Diagrams/Use-Cases/Use-Case_Author.png?raw=true)


## Use-Case: Library
![Use-Case3](https://github.com/DianaCrainic/AP-Final_Project/blob/master/Diagrams/Use-Cases/Use-Case_Library.png?raw=true)

## Tests
![Tests](https://github.com/DianaCrainic/AP-Final_Project/blob/master/Testing/Tests.png?raw=true)

