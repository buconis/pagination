# Guide how to setup Spring Data pagination


All you have to do is clone this repo, import library.sql scrypt from src folder and run gradle bootRun task.


Example request simple pagination:
```$xslt
http://localhost:8080/books?page=0&size=2
```

Example complex pagination request:
```$xslt
http://localhost:8080/books-search?periods=1,3&authors=1,2&genres=1,2,3&sort=author.name&direction=desc&search=&page=0&length=2&type=data
```

Example native query pagination request:
```$xslt
http://localhost:8080/books-search?periods=1,3&authors=1,2&genres=1,2,3&sort=name&direction=desc&search=&page=0&length=2&type=native
```
