Feature: Add Training

  Scenario: Successfully adding a training
    Given the admin is logged in
    And the admin enters valid training data
    When the admin adds the training
    Then the training should be added successfully

  Scenario: Adding training with empty title
    Given the admin is logged in
    And the training title is empty
    When the admin adds the training
    Then adding training should fail

  Scenario: Adding training with invalid capacity
    Given the admin is logged in
    And the training capacity is negative
    When the admin adds the training
    Then adding training should fail

  Scenario: Adding training without admin login
    Given the admin is not logged in
    And the admin enters valid training data
    When the admin adds the training
    Then adding training should fail

  Scenario: Training count increases
    Given the admin is logged in
    And the admin enters valid training data
    When the admin adds the training
    Then the number of trainings should increase