# Themoviedb
This project contains a early implementation of the Rest Assured testing framework for the themoviedb's API.

**Instructions**

Make sure you go in and add the api key into the apiKey String value in the SharedResources class.

To run tests, simply clone this repo, then using maven run the "mvn clean test" command to launch the tests (only 2 are active, the rest are pseudocode or comments).  
(maven can be downloaded from here: http://apache.mirrors.ionfish.org/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.zip)

You can also just go to the apiResponding method or the searchForJackReacher method and just run those in your IDE of choice (I'm using IntelliJ IDEA)

Afterwards, if you'd like a report of the tests you can run the "mvn site" commmand to output an Allure report.

Allure reports appear in the /themoviedb/target/site folder, double click on the allure-maven-plugin.html file to see the report.

**Other Notes:**

There are 3 failing tests and 3 passing tests to show the functionality of logging in the Allure report for failed tests.

Expected Results :

Failed tests: 
  SearchTests.searchForJackReacher2WithWrongAdultStatus:74->search:29 1 expectation failed.
JSON path results[0].adult doesn't match.
Expected: <true>
  Actual: false

  SearchTests.searchForJackReacher2WithWrongDate:68->search:28 1 expectation failed.
JSON path results[0].release_date doesn't match.
Expected: 2016-10-31
  Actual: 2016-10-19

  SearchTests.searchForJackReacher2WithWrongName:62->search:27 1 expectation failed.
JSON path results[0].title doesn't match.
Expected: Jack Raecher: Never Go Back
  Actual: null

Tests run: 6, Failures: 3, Errors: 0, Skipped: 0

The project is written in Java 8 update 131.