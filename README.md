# excel-apache-poi
Spring Boot Application using MongoDB to perfrom CRUD operations and generate excel sheets from database. Also validates if excel headers are in required order

CRUD operation can be performed using the MongoDB repository.
Apache poi library is used to create excel sheets from the data stored in the customer database.
Poi is also used to validate is the headers of an input excel sheet are in required order ( Mandatory fields + Optional Fields)
Mandatory fields : First Name, Email, Phone (In order)
Optional Fields : Last Name(after First Name if present), Address(after Phone if present)

Postman Collection : https://www.getpostman.com/collections/bfe917184be41994744f
