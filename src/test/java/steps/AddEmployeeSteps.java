package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import utils.CommonMethods;
import utils.Log;

import javax.swing.*;

public class AddEmployeeSteps extends CommonMethods {
    @When("user navigates on PIM option")
    public void user_navigates_on_pim_option() {
        waitForElementToBeClickable(dashboardpage.pimOption);
        Actions actions = new Actions(driver);
        actions.moveToElement(dashboardpage.pimOption).perform();
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Navigating to PIM option");
        Log.info("PIM option has been clicked");

    }
    @When("user clicks on Add member option")
    public void user_clicks_on_add_member_option() {
        waitForElementToBeClickable(dashboardpage.addEmployeeOption);
        click(dashboardpage.addEmployeeOption);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Adding Employee to the HRMS application without providing employee ID");
        Log.info("Add Employee option has been clicked");
    }
    @Then("user successfully entered Add membership page")
    public void user_successfully_entered_add_membership_page() {
        waitForElementToBeVisible(addEmployeePage.addEmployeeTab);
        Assert.assertTrue(addEmployeePage.addEmployeeTab.isDisplayed());
        Log.info("Add Employee tab is open");

    }
    @When("user enters employees firstName and lastName")
    public void user_enters_employees_first_name_and_last_name() {
        click(addEmployeePage.firstNameField);
        sendText("John", addEmployeePage.firstNameField);

        click(addEmployeePage.lastNameField);
        sendText("Snow",addEmployeePage.lastNameField);

        Log.info("Employee first name and last name has been entered");
    }
    @When("user leaves Employee ID field empty")
    public void user_leaves_employee_id_field_empty() {
        addEmployeePage.employeeIdField.clear();
        Log.info("Employee ID field is cleared");
    }
    @When("user clicks on save button on Personal Details Page")
    public void user_clicks_on_save_button_on_personal_details_page() {
        click(addEmployeePage.svBtn);
        Log.info("Save button has been clicked");
    }
    @Then("user should see successfully saved employee Personal Details page")
    public void user_should_see_successfully_saved_employee_personal_details_page() {
        waitForElementToBeVisible(addEmployeePage.newEmpPersonalDetailsTab);
        Assert.assertTrue(addEmployeePage.newEmpPersonalDetailsTab.isDisplayed());
        Log.info("New Employee was successfully added");
    }
}
