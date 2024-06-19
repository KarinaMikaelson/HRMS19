Feature: Accessing the Memberships section feature

  Background: Valid user credentials login
    When Employee enters valid employee username and password
    And Employee clicks login
    Then Employee is sucessfully logged in

  @test @karina @accessingMembershipSection
  Scenario: Accessing the Memberships section
    When user clicks on My Info page
    And user clicks on the Memberships section
    Then user successfully entered Assigned Memberships page