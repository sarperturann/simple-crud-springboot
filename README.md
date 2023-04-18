# Simple CRUD Web Service with Spring Boot

This is a simple REST web service created using Java and Spring Boot with PostgreSQL database. It ingests spreadsheet documents in database and conducts basic CRUD operations on created reports.

The application is Dockerized to enable easy development on multiple platforms with minimal effort. In order to run the application you need Docker installed in your computer.

In order for local development/testing, clone the repository to your own computer. After cloning the repository, open the terminal on the main folder and run the following commands.

Build and package the app to an executable format.

```./gradlew build```

Run the docker container with app and PostgreSQL image.

```docker-compose up --build```

After running these commands in sequence, the application is initialized and now running.

---

### Limitations/Potential Improvements
In terms of overall functionality there are some edge cases not covered. For example the createRecord function carries a risk to give ```NullPointerException``` if any of the cells or input is null. 

Input validation can be added to avoid mistakes and ensure the data stored in the database is valid.

Instead of using ```POST``` mapping for deleteRecord and updateRecord functions, more suiting HTTP verbs can be used to be semantically correct like ```DELETE``` and ```PUT```.

Addition of unit tests are critical.

In a real-life scenario it would be better to use different data types instead of just int for cases such as salary, workYears etc.

---

[API Documentation](API_DOCUMENTATION.md)
