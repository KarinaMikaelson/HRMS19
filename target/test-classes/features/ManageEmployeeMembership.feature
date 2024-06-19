Feature: Manage employee membership section

  Background: Valid user credentials login
    When Employee enters valid employee username and password
    And Employee clicks login
    Then Employee is successfully logged in
    When user clicks on My Info page
    And user clicks on the Memberships section
    Then user successfully entered Assigned Memberships page

  @test @karina @addNewMembership
  Scenario: Create a new membership with valid details
    When user clicks on add button
    And user enters valid membership details
    When user clicks on save button
    Then user should see successfully saved message on the assigned memberships page

  @test @karina @addNewMembershipWithEmptyFields
  Scenario: Add new membership with empty fields
    When user clicks on add button
    And user clicks save button with empty mandatory fields
    Then user should see validation messages for the required fields

  @test @karina @editExistingMembership
  Scenario: Edit existing membership details
    When user clicks on the membership code in the Assigned Memberships page
    Then the Edit Membership section should open
    When user edits one or more fields in the Memberships section
    When user clicks on save button
    Then user should see successfully saved message on the assigned memberships page
    And user should see updated membership details displayed on the Assigned Memberships page

  @test @karina @deleteExistingMembership
  Scenario: Delete existing membership
    When user clicks on checkbox next to the membership name
    And user clicks on delete button
    Then user should see Successfully removed message