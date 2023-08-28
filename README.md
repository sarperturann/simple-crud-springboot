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

[API Documentation](API_DOCUMENTATION.md)
