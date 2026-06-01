Feature: User Registration

  Scenario: Successful registration
    Given the user enters valid registration data
    When the user submits the registration form
    Then the account should be created successfully

  Scenario: Registration with existing email
    Given a user with the same email already exists
    When the user submits the registration form
    Then an error message should be displayed

  Scenario: Registration with empty email
    Given the email field is empty
    When the user submits the registration form
    Then registration should fail

  Scenario: Registration with short password
    Given the password is shorter than 6 characters
    When the user submits the registration form
    Then registration should fail

  Scenario: Registration with empty name
    Given the name field is empty
    When the user submits the registration form
    Then registration should fail