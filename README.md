## Prerequisites
1. git clone https://github.com/GoodRx/gold-qa.git
2. Make sure core project has builded successfully.
3. TimeZone (GMT-8).

## How to build the core project

	mvn clean test

## How to run the test suite using terminal
1. Open the terminal -> Navigate up to the gold-qa directory.
2. Then type below commands to run the test.

	clean test -DsuiteXmlFile=src\test\resources\gold-qa-test-suite.xml

## Running test suite without using terminal : 

Go to the src/test/resources package -> gold-qa-test-suite -> double click -> Right click -> Run as -> TestNG suite

## How to see allure reports after execution

1. Select the project and refresh it.
2. Click on target.
3. Select the allure-results and copy the path.
4. Open the terminal and type below command.

	allure serve 

