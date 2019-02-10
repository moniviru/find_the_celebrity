# Find the Celebrity - Project

This project was created to implement the algorithm "Find the celebrity".

### Prerequisites

* JDK 8
* IDE (Eclipse)
* Application server (The Tomcat 9 server was used)

## Installing and Deployment

* You can clone the project or download the sources as a ZIP.
* Open the IDE.
* Click on the "File" option and then click on Import ==> Existing Maven Project. Select the project.
* In the IDE, Right click on the project Run as ==> Run on Server.
* Configure the application server to run the project.
* In the browser, open the URL http://localhost:8080/find-the-celebrity/search/celebrity (The port depends on the port configured in the application server).

## How to use the application?

* First you need to create a file in Text/Plain format.
* You must enter in the file the names of a group of people. Example:
```
input.txt
```
```
Annie
Bob
Marc 
Kathy
```
* Upload the file and then click in the "Find the celebrity" button.
* A page with the name and id of the celebrity and also the matrix of responses will be displayed.
* If you want to upload another group of people and find the celebrity, you can click on the "Try Again" button.
* Supposed and rules: (You can also see them on the home page) 
```
Supposed

- There is always a celebrity in the group of people.

Rules

- Not allowed empty files.
- File lines with more than 15 characters or empty will be omitted.
```

## Built With

* Spring 5
* Bootstrap
* Maven

## Author

* [moniviru](https://github.com/moniviru)

