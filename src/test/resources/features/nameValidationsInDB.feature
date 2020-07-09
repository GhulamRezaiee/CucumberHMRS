Feature: Name validations against DB

  Scenario: First Name Validation against DB
    Given user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "14688"
    And click on search button
    Then verify table is displayed
    And get first name from table
    When get data from DB
    Then Validate first name from UI against DB
