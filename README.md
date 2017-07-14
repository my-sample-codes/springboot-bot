# springboot-bot
A sample application that integrates with third parties

# Steps to Run
This is a maven project build using `Spring Boot`. To execute the project follow the below steps:
1.	Clone the repository in your file system
2.	Switch to the `development` branch which has all the latest code
3.	Run the below maven command to build the application
```
mvn clean package
```
4. Look in the `target` directory you should see `springboot-bot-1.0.jar`
5. To run the application, use the java -jar command
```
java -jar target/springboot-bot-1.0.jar
```
# Steps to test
1. While doing maven build, the application's unit test cases runs automatically which verifies the working condition of the API
2. To test it manually open your favorite browser and hit the below URL:
```
http://localhost:8080/services/v1/checkConnection?urlToCheck=<<URL that you want to validate>>
```
In the above example you can use the value of the Query parameter `urlToCheck` as `https://www.google.co.in` to run a quick test

# Automation Test
One other automation project has been created to automate the testing of the API. You can find the project under the location
```
https://github.com/raahool/bdd-bot
```