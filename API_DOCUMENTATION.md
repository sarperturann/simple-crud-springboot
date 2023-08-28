# API Documentation

This document will be used to document the API operations. The example requests will be provided from local development.


## Functionalities Available
### Create Record
- Endpoint (POST)
 ``http://localhost:8080/api/createRecord``
- Enter a binary body for Base64 encoded version of your Excel Spreadsheet.
<img width="435" alt="Screenshot 2023-04-18 at 22 22 25" src="https://user-images.githubusercontent.com/60585707/232883280-ea4a94e0-f602-4a29-88f1-52026eaac151.png">

### Read Record
- Endpoint (GET)
 ``http://localhost:8080/api/readRecord``
- Enter the id as a parameter
- Example request:  ``http://localhost:8080/api/readRecord?id=7``

### Update Record
- Endpoint (PUT)
 ``http://localhost:8080/api/updateRecord``
- Enter a JSON body ``{
    "id": 4,
    "name": "Sarper",
    "surname": "Test",
    "age": 21,
    "salary": 24000,
    "workYears": 5,
    "title": "Junior Software Engineer"
}``

### Delete Record
- Endpoint (DELETE)
 ``http://localhost:8080/api/deleteRecord``
- Enter the id as a parameter
- Example request:  ``http://localhost:8080/api/deleteRecord?id=7``

### Add Record
- Endpoint (POST)
 ``http://localhost:8080/api/addRecord``
- Enter a JSON body ``{
    "name": "Sarper",
    "surname": "Test",
    "age": 21,
    "salary": 24000,
    "workYears": 5,
    "title": "Junior Software Engineer"
}``
