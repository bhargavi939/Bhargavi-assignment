# Dream Portal - Test Automation Project

This project contains automated functional tests for the "Dream Portal" website, as part of the QA Intern Assignment. The framework is built using Java, Selenium, and TestNG, with professional reporting handled by Allure.

## Prerequisites

To run this project, you will need the following installed on your machine:
* Java (Version 11 or higher)
* Apache Maven
* Allure Commandline

## How to Run the Tests

1.  Open a terminal or command prompt in the main project folder.
2.  Run the following Maven command to execute all the tests:
    ```bash
    mvn clean test
    ```

## How to View the Professional Report

1.  After the tests have finished running, a folder named `allure-results` will be created.
2.  To open the interactive HTML report, run the following command in the terminal:
    ```bash
    allure serve
    ```
