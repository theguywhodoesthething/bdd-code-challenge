Feature: Register New User

  Background:
    Given there is a user on the registration page

  Scenario: Navigate to the testing page
    Then the register new user page should be displayed

  Scenario: First Name Field is required
    And all required fields are filled out except for the first name field
    And all checkboxes are checked
    When the user saves the form
    Then an error message should display indicating that the first name field requires a value

  Scenario: First Name Field only accepts 15 characters
    And all required fields are filled out except for the first name field
    And all checkboxes are checked
    When the user fills in the first name field with EXTRATERRESTRIAL
    Then the first name field should contain EXTRATERRESTRIA

  Scenario: Suffix Field is not required
    And all required fields are filled out except for the suffix field
    And all checkboxes are checked
    When the user saves the form
    Then the user should be redirected to the success page

  Scenario: Title Field does not accept numbers
    And all required fields are filled out except for the title field
    And all checkboxes are checked
    When the user fills in the title field with W1LL N0T W0RK
    And the user saves the form
    Then an error message should display indicating that the title field does not accept numbers

  Scenario: Valid Title Field is accepted
    And all required fields are filled out except for the title field
    And all checkboxes are checked
    When the user fills in the title field with WILL WORK
    And the user saves the form
    Then the user should be redirected to the success page
