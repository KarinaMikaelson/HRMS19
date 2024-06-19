Feature: Login scenarios


  @test
  Scenario: Invalid credentials and validating error message
    When User enters invalid credentials and get error message

  @test
  Scenario: Valid admin credentials login
    When Admin user enters valid admin username and password
    And User click login
    Then user is successfully logged in and navigated to dashboard page

  @test
  Scenario: Valid user credentials login
    When Employee enters valid employee username and password
    And Employee clicks login
    Then Employee is successfully logged in
