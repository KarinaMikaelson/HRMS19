Feature: Employee Search Scenarios

  Background: Valid admin credentials login
    When Admin user enters valid admin username and password
    And User click login
    Then user is successfully logged in and navigated to dashboard page
    When user navigates on PIM option

    @test @employeeSearch
    Scenario Outline: Employee search using firstName and lastName
      When user clicks on Employee List option
      Then user successfully entered Employee Information page
      When user enters "<firstname>" and "<middlename>" and "<lastname>"
      And user clicks on Search button
      Then user should see employee information
      Examples:
        | firstname | middlename | lastname |
        |Fouad      |MS          |Oliinyk   |
        |Matt       |MS          |Aslloun   |
        |Lali       |MS          |Shahad    |

      @test @empSearchId
        Scenario: Employee search using unique id
        When user clicks on Employee List option
        Then user successfully entered Employee Information page
        When user enters employee id
        And user clicks on Search button
        Then user should see employee information with matching id

