Feature: Add Employee Dependents
  Background: Valid user credentials login
    When Employee enters valid employee username and password
    And Employee clicks login
    Then Employee is successfully logged in

    Scenario: Accessing employee dependents section
      When user clicks on My Info page
      And user clicks on Dependents section
      Then user should see Assigned dependents tab open

    Scenario: Add employee dependents
      When user clicks on add button
      And user enters "John Doe" in the full name textbox
      And the employee selects "Child" from the relationship dropdown
      And user selects dependents dob from the calendar "005-05-15"


