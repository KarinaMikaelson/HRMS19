Feature: Edit personal information
  Background: Valid user credentials login
    When Employee enters valid employee username and password
    And Employee clicks login
    Then Employee is successfully logged in
    When user clicks on My Info page

    @test @editPersonalInfo
    Scenario Outline: Employee edits personal information successfully
      #Given  Employee is successfully logged in

      When user clicks on edit button
      And user edits "<firstName>" and "<middleName>" and "<lastName>"
      And user selects "Male" as Gender
      And user selects "American" from Nationality dropdown
      And the employee selects "Single" from the Marital Status dropdown
      And the employee clicks on the Save button
      Then the system should save the changes
      Examples:
        | firstName | middleName | lastName |
        |Fouad      |MS          |Oliinyk   |
        |Matt       |MS          |Aslloun   |
        |Lali       |MS          |Shahad    |