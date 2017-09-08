## Pagination with Spring Data

This is example of pagination with spring data, it provide us with Pageable object where most of the stuff can be defined.
To run this app all you need is to checkout project and run gradle bootRun task.

There is also dump for sample database in folder scripts called library.sql so you can import it and have a test environment setup completely.

#####Example call for simple pagination:
http://localhost:8080/books?page=0&size=3

#####Example call for complex pagination:
http://localhost:8080/books-search?periods=1,3&authors=1,2&genres=1,2,3&sort=author.name&direction=desc&search=&page=0&length=2&type=data

#####Example call for native query pagination:
http://localhost:8080/books-search?periods=1,3&authors=1,2&genres=1,2,3&sort=name&direction=desc&search=&page=0&length=2&type=native
