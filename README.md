# microservices-springbootcloud
RESTful web sevice with three mapping methods get,post,put,delete.

GET: http://localhost:8080/users/${userID}
     http://localhost:8080/users?page=10&limits=11
     
POST: http://localhost:8080/users
      body:
      <UserRest>
       <first_name>Ziad</first_name>
       <last_name>Jamal</last_name>
       <email>alaajamal470@gmail.com</email>
       <age>10</age>
    </UserRest>

PUT: http://localhost:8080/users/${userID}
    body:
    {
    "first_name": "Walaa",
    "last_name": "Jamal"
    }
    
DELETE: http://localhost:8080/users/${userID}

We can use postman app to send and test this methods
