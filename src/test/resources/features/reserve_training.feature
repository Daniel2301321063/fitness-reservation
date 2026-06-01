Feature: Reserve Training

  Scenario: Successful training reservation
    Given the user is logged in
    And the training has available spots
    When the user reserves the training
    Then the reservation should be successful

  Scenario: Reservation without logged user
    Given the user is not logged in
    And the training has available spots
    When the user reserves the training
    Then the reservation should fail

  Scenario: Reservation for full training
    Given the user is logged in
    And the training has no available spots
    When the user reserves the training
    Then the reservation should fail

  Scenario: Reservation for missing training
    Given the user is logged in
    And the training does not exist
    When the user reserves the training
    Then the reservation should fail

  Scenario: Reserved spots increase after reservation
    Given the user is logged in
    And the training has available spots
    When the user reserves the training
    Then the number of reserved spots should increase