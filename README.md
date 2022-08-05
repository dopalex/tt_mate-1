# Url-shorter

## Descriptions
This is a simple implementation of a library application, created using Spring Boot, SQL database, REST principles and supports CRUD operations. All data is displayed to user in JSON format.

## Project structure
Project is built on a three-tier architecture:

1. Presentation layer (controllers);
2. Application layer (service);
3. Data access layer (DAO);

### List of endpoints:
1. `POST`: /authors - add author
2. `PUT`: /authors/{id} - update author
3. `DELETE`: /authors/{id} - delete author
4. `POST`: /books - add book
5. `PUT`: /books/{id} - update book
6. `DELETE`: /books/{id} - delete book
7. `GET`: /authors - show all books by author name
8. `GET`: /most-sold/authors - show most selling book by author name
9. `GET`: /most-published/authors - show most published book by author name
10. `GET`: /by-sold/authors - show list of most selling book by partial author name
11. `GET`: /by-published/authors - show list of most published book by partial author name
12. `GET`: /by-success-rate/authors - show list of most successful book (sold/published ratio) by partial author name

## Technologies stack

- Java 11
- REST
- Spring Boot
- Spring WEB
- Apache Maven
- MySQL
- Swagger 
- Lombok

### Entity
1. Book;
- `private Long id;`
- `private String bookName;`
- `private long publishedAmount;`
- `private long soldAmount;`
2. Author
- `private Long id;`
- `private String authorName;`
- `private LocalDate birthDate;`
- `private String phone;`
- `private String email;`


## How to run project
1. Clone this project
2. Configure DB connection in resources/application.properties
3. Run project.
4. Use swagger - `http://localhost:8080/swagger-ui/#/`
