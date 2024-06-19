package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Log;

public class ManageEmployeeMembershipSteps extends CommonMethods {
    @When("user clicks on add button")
    public void user_clicks_on_add_button() {
        click(manageEmployeeMembershipPage.addMembershipBtn);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Create a new membership with valid membership details test case");
        Log.info("Add button has been clicked");
    }
    @And("user enters valid membership details")
    public void user_enters_valid_membership_details() {
        click(manageEmployeeMembershipPage.selectMembDD);
        selectFromDropdown("2502",manageEmployeeMembershipPage.selectMembDD);
        Log.info("Membership type has been selected");


        click(manageEmployeeMembershipPage.selectMembSubscriptionDD);
        selectFromDropdown("Company", manageEmployeeMembershipPage.selectMembSubscriptionDD);
        Log.info("Membership subscription type has been selected");


        sendText("5000",manageEmployeeMembershipPage.subscriptionAmountField);
        Log.info("Subscription amount has been entered");


        click(manageEmployeeMembershipPage.currencyDropdown);
        selectFromDropdown("USD",manageEmployeeMembershipPage.currencyDropdown);
        Log.info("Currency has been selected");


        click(manageEmployeeMembershipPage.subscriptionStartCalendar);
        selectFromDropdown("9", manageEmployeeMembershipPage.subStartMonth);
        selectFromDropdown("2020", manageEmployeeMembershipPage.subStartYear);
        Log.info("Subscription starting  month and year has been selected");

        waitForElementToBeVisible(manageEmployeeMembershipPage.subStartDate);
        chooseCalendarDate(manageEmployeeMembershipPage.subStartDate,"6");
        Log.info("Subscription starting date has been selected");


        click(manageEmployeeMembershipPage.subscriptionRenewalDate);
        selectFromDropdown("2",manageEmployeeMembershipPage.subRenewMonth);
        selectFromDropdown("2024", manageEmployeeMembershipPage.subRenewYear);
        Log.info("Subscription Renew  month and year has been selected");
        waitForElementToBeVisible(manageEmployeeMembershipPage.subRenewDate);
        chooseCalendarDate(manageEmployeeMembershipPage.subRenewDate,"10");
        Log.info("Subscription Renew date has been selected");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(manageEmployeeMembershipPage.saveMembershipBtn);
        Log.info("Save button has been clicked");
    }

    @Then("user should see successfully saved message on the assigned memberships page")
    public void user_should_see_successfully_saved_message_on_the_assigned_membership_page() {
        waitForElementToBeVisible(manageEmployeeMembershipPage.successfullyAddedMessage);
        Log.info("Successfully Saved message has appeared");
    }

    @When("user clicks save button with empty mandatory fields")
    public void user_clicks_save_button_with_empty_mandatory_fields() {
        click(manageEmployeeMembershipPage.saveMembershipBtn);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Add new membership with empty fields Test Case");
        Log.info("Save button has been clicked with empty mandatory fields");
    }
    @Then("user should see validation messages for the required fields")
    public void user_should_see_validation_messages_for_the_required_fields() {

        waitForElementToBeVisible(manageEmployeeMembershipPage.requiredFieldErrorMsg);
        if(manageEmployeeMembershipPage.requiredFieldErrorMsg.isDisplayed()){
            String actualErrorMessage = manageEmployeeMembershipPage.requiredFieldErrorMsg.getText();
            String expectedErrorMessage = "Required";
            Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
            Log.info("Required error message has appeared after empty fields saving attempt");
        }
    }


    @When("user clicks on the membership code in the Assigned Memberships page")
    public void user_clicks_on_the_membership_code_in_the_assigned_memberships_page() throws InterruptedException {
        click(manageEmployeeMembershipPage.membCode);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Edit existing membership details");
        Log.info("Existing Membership code has been clicked");

    }

    @Then("the Edit Membership section should open")
    public void the_edit_membership_section_should_open() {

        Assert.assertTrue(manageEmployeeMembershipPage.editMembPage.isDisplayed());
        if(manageEmployeeMembershipPage.editMembPage.isDisplayed()){
            System.out.println("Edit Membership Section is open");
        }else {
            System.out.println("Could not open Edit Membership Section ");
        }
        Log.info("Edit Membership section has been open");

    }

    @When("user edits one or more fields in the Memberships section")
    public void user_edits_one_or_more_fields_in_the_memberships_section() {

        click(manageEmployeeMembershipPage.selectMembSubscriptionDD);
        selectFromDropdown("Individual", manageEmployeeMembershipPage.selectMembSubscriptionDD);
        Log.info("Membership type has been changed to Individual");

        click(manageEmployeeMembershipPage.currencyDropdown);
        selectFromDropdown("AUD",manageEmployeeMembershipPage.currencyDropdown);
        Log.info("Currency type has been changed to AUD");
    }
    @And("user should see updated membership details displayed on the Assigned Memberships page")
    public void user_should_see_updated_membership_details_displayed_on_the_assigned_memberships_page() {
        String actualResult = manageEmployeeMembershipPage.subsPaidByColumnValue.getText();
        String expectedResult = "Individual";
        Assert.assertEquals(expectedResult,actualResult);
        Log.info("Membership details has been updated");
    }

    @When("user clicks on checkbox next to the membership name")
    public void user_clicks_on_checkbox_next_to_the_membership_name() {
        clickCheckbox(manageEmployeeMembershipPage.newMembershipCheckbox);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Delete existing membership Test Case");
        Log.info("Checkbox next to membership name has been clicked");
    }
    @When("user clicks on delete button")
    public void user_clicks_on_delete_button() {
        click(manageEmployeeMembershipPage.deleteMembershipBtn);
        Log.info("DELETE button has been clicked");
    }
    @Then("user should see Successfully removed message")
    public void user_should_see_successfully_removed_message() {
        waitForElementToBeVisible(manageEmployeeMembershipPage.membSuccessDeletedMessage);
        Assert.assertTrue(manageEmployeeMembershipPage.membSuccessDeletedMessage.isDisplayed());
        Log.info("Successfully removed message has appeared");
    }
}
