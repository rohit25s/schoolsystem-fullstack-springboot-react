# fullstack SchoolSystem example application with springboot and React

## Requirements
- JDK >= 1.8
- npm = 8.3.1
- maven
- Junit 4

## Models
- User
  - Student
  - Professor

## Functional Requirements
- student's information 

   name | email | school name

- professor's information

    name | email | school name | course taught

API's to be designed

- Add a user
- Update a user 
- List the users 
- Delete a user
- Search APIs like below
  
  a) Find all the students in the given school
  
  b) Find Students

  c) Find Professors
## Non-functional requirements
- UI for api operations
- Form Inputs for add
- List items

## APIs

- **POST /student** - creates a student
- **GET /student/{id}** - find student with id
- **GET /student** - gets all students
- **PUT /student/{id}** - update student with id
- **GET /student?school_name={school_name}** - find all students in a school
- **DELETE /student/{id}** - deletes student with id


- **POST /professor** - creates a professor
- **GET /professor/{id}** - find professor with id
- **GET /professor** - gets all professors
- **PUT /professor/{id}** - update professor with id
- **GET /professor?school_name={school_name}** - find all professors in a school
- **DELETE /professor/{id}** - deletes professor with id

## UI
ui currently only have capability for create, list, delete.

**More to be added later.** 
## How To Run
```
git clone https://github.com/rohit25s/schoolsystem-fullstack-springboot-react.git
```
### or
- unzip repo
```
cd schoolsystem
```
### Backend
```
./mvnw spring-boot:run
```
use Postman or curl to run api

e.g

GET http://localhost:8080/student/1
### Frontend
```
cd schoolsystemfrontend
npm install
npm start
```
### To run tests
```
./mvnw test
```
Open in Browser 
[http://localhost:3000](http://localhost:3000)