package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.devtools.v85.dom.DOM;
import utils.CommonMethods;
import utils.Log;

public class EditEmployeeDetailsSteps extends CommonMethods {

    @When("user clicks on edit button")
    public void user_clicks_on_edit_button(){
            waitForElementToBeClickable(editEmployeeDetailsPage.editBtn);
            //Thread.sleep(30000);
            click(editEmployeeDetailsPage.editBtn);
            Log.info("Edit button was clicked");
        }

    @When("user edits {string} and {string} and {string}")
    public void user_edits_and_and(String string, String string2, String string3) {
        waitForElementToBeClickable(editEmployeeDetailsPage.editFirstName);
        click(editEmployeeDetailsPage.editFirstName);
        sendText("Cassandra", editEmployeeDetailsPage.editFirstName);

        waitForElementToBeClickable(editEmployeeDetailsPage.editMidName);
        click(editEmployeeDetailsPage.editMidName);
        sendText("Mid", editEmployeeDetailsPage.editMidName);

        waitForElementToBeClickable(editEmployeeDetailsPage.editLastName);
        click(editEmployeeDetailsPage.editLastName);
        sendText("Lastovich", editEmployeeDetailsPage.editLastName);

        Log.info("First name, middle name and last name has been changed");
    }
    @When("user selects {string} as Gender")
    public void user_selects_as_gender(String string) {
        waitForElementToBeClickable(editEmployeeDetailsPage.selectMaleGender);
        click(editEmployeeDetailsPage.selectMaleGender);
        Log.info("Gender Male has been selected");
    }
    @When("user selects {string} from Nationality dropdown")
    public void user_selects_from_nationality_dropdown(String string) {
        waitForElementToBeClickable(editEmployeeDetailsPage.selectNation);
        click(editEmployeeDetailsPage.selectNation);
        selectFromDropdown(editEmployeeDetailsPage.selectNation,"American");
        Log.info("American nation has been selected from dropdown");
    }
    @When("the employee selects {string} from the Marital Status dropdown")
    public void the_employee_selects_from_the_marital_status_dropdown(String string) {
        waitForElementToBeClickable(editEmployeeDetailsPage.selectMaritStatus);
        click(editEmployeeDetailsPage.selectMaritStatus);
        selectFromDropdown(editEmployeeDetailsPage.selectMaritStatus,"Single");
        Log.info("Single marital status has been selected");
    }
    @When("the employee clicks on the Save button")
    public void the_employee_clicks_on_the_save_button() {
        waitForElementToBeClickable(editEmployeeDetailsPage.saveBtn);
        click(editEmployeeDetailsPage.saveBtn);
        Log.info("Save button clicked");
    }
    @Then("the system should save the changes")
    public void the_system_should_save_the_changes() {
        waitForElementToBeVisible(manageEmployeeMembershipPage.successfullyAddedMessage);
        Assert.assertTrue(manageEmployeeMembershipPage.successfullyAddedMessage.isDisplayed());
        Log.endTestCase("Edit Employee Personal Details test case completed");
        Log.info("Successfully Saved message has appeared");
    }
}
