Feature: Adding Employee to the HRMS application without providing employee ID

  Background: Valid admin credentials login
    When Admin user enters valid admin username and password
    And User click login
    Then user is successfully logged in and navigated to dashboard page

    @addEmployee @test @addEmpWithoutId
    Scenario: Adding employee without providing employee ID
      When user navigates on PIM option
      And user clicks on Add member option
      Then user successfully entered Add membership page
      When user enters employees firstName and lastName
      And user leaves Employee ID field empty
      And user clicks on save button on Personal Details Page
      Then user should see successfully saved employee Personal Details page
