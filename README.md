# Themoviedb
This project contains basic Rest Assured testing for the themoviedb's API.

Make sure you go in and add the api key into the apiKey String value in the SharedResources class.

To run tests, simply clone this repo, then using maven run the "mvn clean test" command to launch the tests (only 2 are active, the rest are pseudocode or comments).  
(maven can be downloaded from here: http://apache.mirrors.ionfish.org/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.zip)

You can also just go to the apiResponding method or the searchForJackReacher method and just run those in your IDE of choice (I'm using IntelliJ IDEA)

Afterwards, if you'd like a report of the tests you can run the "mvn site" commmand to output an Allure report.

Allure reports appear in the /themoviedb/target/site folder, double click on the allure-maven-plugin.html file to see the report.

The project is written in Java 8 update 131.