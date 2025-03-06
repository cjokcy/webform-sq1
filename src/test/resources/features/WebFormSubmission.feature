Feature: Submit the web form with valid input

  @WebForm
  Scenario: Fill the text boxes with valid inputs
    Given the user is landing on the form
    And the user fill out the below fields with valid data
      | textinput | password | textarea              |
      | MyTest    | Testing  | Testing this web form |
    Then validate whether disable input is disabled or not
    And validate readonly input field allow text to be read
    And the user selects dropdown option as "One" and datalist as "Seattle"
    And the user uploads a file
    And the user uncheck the checked checkbox and checks the default checkbox
    And the user selects the Default radio button
    And the user change the colour to "#FF5733" and date picker as "03/05/2025"
    And the user sets the example range
    And the user submit the form
    Then the user see a confirmation message as below
      | Form submitted |
      | Received!      |


