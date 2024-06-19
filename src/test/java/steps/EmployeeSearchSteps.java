package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Log;

public class EmployeeSearchSteps extends CommonMethods{
    @When("user clicks on Employee List option")
    public void user_clicks_on_employee_list_option() {
        waitForElementToBeClickable(dashboardpage.empListOption);
        click(dashboardpage.empListOption);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Employee Search test case");
        Log.info("Employee List option has been clicked");

    }
    @Then("user successfully entered Employee Information page")
    public void user_successfully_entered_employee_information_page() {
        waitForElementToBeVisible(employeeSearchPage.empInfoTab);
        Assert.assertTrue(employeeSearchPage.empInfoTab.isDisplayed());
        Log.info("Employee Information tab is open");
    }
    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String string, String string2, String string3) {
        waitForElementToBeClickable(employeeSearchPage.empSrchNameField);
        click(employeeSearchPage.empSrchNameField);
        sendText("Aziza Abas", employeeSearchPage.empSrchNameField);
        Log.info("Employees first name and last name has been entered");
    }
    @When("user clicks on Search button")
    public void user_clicks_on_search_button() {
        waitForElementToBeClickable(employeeSearchPage.searchBtn);
        Log.info("Search button has been clicked");
    }
    @Then("user should see employee information")
    public void user_should_see_employee_information() {
        waitForElementToBeVisible(employeeSearchPage.searchResults);
        Assert.assertTrue(employeeSearchPage.searchResults.isDisplayed());
        Log.info("Entered employee successfully appeared on the info table");
    }
    @When("user enters employee id")
    public void user_enters_employee_id() {
        waitForElementToBeClickable(employeeSearchPage.empIdField);
        sendText("16598643", employeeSearchPage.empIdField);
        Log.info("Employee ID has been entered");
    }
    @Then("user should see employee information with matching id")
    public void user_should_see_employee_information_with_matching_id() {
        waitForElementToBeVisible(employeeSearchPage.idSearchResults);
        Assert.assertTrue(employeeSearchPage.idSearchResults.isDisplayed());
        Log.info("Entered employee ID successfully appeared on the info table");
    }
}
