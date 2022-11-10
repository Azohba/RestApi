# Backend Test | Java & Rest Assured

Api Test cases were implemented by using Java language, Maven Framework and Rest Assured within non-BDD structure.

## Requirement/s

Java path&variables

Jenkins local

Calliope account

## Versions / Dependencies

Java: 17.03

Rest Assured: 4.4.0

TestNG: 7.4.0

Apache-Maven: 3.8.4

Jenkins: 2.361.1


## Setup

Precondition: Ensure all required dependencies are installed

1: Java and Maven have to be installed and configured path variables for Windows

2: Clone the repository

$ git clone https://github.com/Azohba/RestApi.git

3: Install dependencies

``` mvn clean install ```

4: Install Jenkins to run the tests in a CI/CD environment

$ Follow the steps in the article for Windows setup -> https://www.blazemeter.com/blog/how-to-install-jenkins-on-windows

$ Follow the steps in the article for Mac setup -> https://www.knowledgehut.com/blog/devops/install-jenkins-on-mac

5: Install Jenkins plugins in order to trigger for creating test results

$ Maven plugin 

$ TestNG report plugin

## Run
Runs the test locally, below command triggers to run all test cases
``` mvn test ```

Runs the tests on Jenkins (firstly go to the directory path where Jenkins war locates)
``` java -jar jenkins-cli.jar -s http://localhost:8080/ -auth {{jenkins_username}}:{{jenkins_password}} build RestApi_SpriteCloud  ```

 
## Project Structure
RestAssuredClient includes general Rest Assured api call methods (HTTP Methods: Get, Post, Put, Patch, Delete) to avoid retyping the same codes in our step classes or helper classes.

$ main/java/client/

Models includes the POJO(Plain Old Java Object) part of the project. It stores all of the request or response body objects in this directory. 

$ main/java/models  

Config includes some constants like URLs or Errors.

$ test/java/config

Helpers includes methods to call api endpoints.

$ test/java/helpers

Services includes all test classes inside of a tailored directory for api service.

$ test/java/services
 
## Calliope
Here is the link to go to results in Calliope.pro

$ https://app.calliope.pro/profiles/4508

## Test Case Selection
I chose at least one endpoint to perform each common used HTTP methods such as GET, PUT, POST, DELETE. So in this assignment I created pet by calling POST method. I updated pet info by calling PUT method. I get the pet info by calling GET method and finally I deleted the pet I created before by calling DELETE http method.

## Future Tasks
There could be a structure to perform negative cases or more cases in a single method by sending only test data. DataProvider annotation of TestNG can be used.

## Contribution

Feel free to contribute to this test automation case study.
