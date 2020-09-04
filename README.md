## Customer Relationship Management Application

**Team 3: Kenneth Boyer, Jhanani Dhakshnamoorthy, Saurav Dhungel**

## API

| Methods | URL | Actions |
| --- | --- |--- |
| POST   | /api/customers     | create new Customers    |
| GET     | /api/customers       | retrieve all Customers      |
| GET     | /api/customers/:id       | retrieve a Customer by :id      |
| PUT     | /api/customers/:id       | update a Customer by :id      |
| DELETE     | /api/customers/:id       | delete a Customer by :id      |
| GET     | /api/customers/:id/interactions       | retrieve all interactions by customer id      |
| POST   | /api/customers/:id/interactions     | create new customer interaction    |
| PUT     | /api/customers/interactions/:id       | update a Customer interaction by :id      |
| DELETE     | /api/customers/interactions/:id       | delete a Customer interaction by :id      |


## Technology
- Java 8
- Spring Boot 2 (with Spring Web MVC, Spring Data MongoDB)
- MongoDB
- Gradle
