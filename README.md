# Selenium WebDriver Java Testing Example

This repository provides an example of using **Selenium WebDriver** with **Java**, **JUnit**, **TestNG** , **Cucumber**, and **Gherkin** for browser automation and UI testing. It includes a simple framework for managing WebDriver instances, reusable UI methods, page objects, and example tests that interact with a web form on [SquareOneExercise_Web-form](https://www.selenium.dev/selenium/web/web-form.html).

The tests are written using the **Cucumber** framework in **Gherkin** syntax, which allows for behavior-driven development (BDD) style scenarios. **JUnit** is used as the test runner to execute the feature files.


## Overview

This project demonstrates how to build a basic Selenium WebDriver testing framework in Java. The repository contains:

- **Driver management** with thread-safe WebDriver instances.
- **Reusable UI methods** and **page objects** for interacting with web elements.
- **Sample test scenarios** that cover various web components (text input, password fields, checkboxes, dropdowns, etc.).
- **Cucumber-based feature files** for defining test scenarios in a behavior-driven development (BDD) style.

## Cucumber-Based Feature Files  

This repository include one comprehensive Cucumber feature files written in Gherkin syntax. These files define test scenarios for behavior-driven development (BDD):

- **Web Form Components**:  
  - Covers interaction with various form elements, including:  
    - Text inputs and password fields.  
    - Dropdown menus (select and data list).  
    - File uploads.  
    - Checkboxes and radio buttons.  
    - Date picker, color picker, and range slider components.  
 
## Class Structure:

### `context`

- **`DriverManager`**
  - Manages web driver instances for multiple threads.
  - Likely includes methods for creating, getting, and removing WebDriver instances in a thread-safe manner.


### `pages.`

- **`WebFormPage`**
  - A Page Object for handling form components such as text fields, checkboxes, dropdowns, etc.
  - Includes elements like `WebFormTextElement` to distinguish different types of form inputs.

### `Runner`
- The test runner class that uses Cucumber to run the tests.
- Defines the location of feature files and configures reporting options for the test execution.

  
### `stepsdefinitions`

- **`StepDefinitions`**
  - Step definition class for interacting with web form components like input fields, buttons, and dropdowns.

---


  ## Test Reports

- Make sure you have maven installed, from the commandline - navigate to folder where this project is located
- Run mvn clean test -X
- mvn test or mvn verify -DskipTests
- After running the tests, you can find the test execution reports in the `target` directory. The reports are generated in HTML format, providing a detailed overview of the test results.

---

    




