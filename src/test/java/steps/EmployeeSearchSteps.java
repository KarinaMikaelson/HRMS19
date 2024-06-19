package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Log;

import java.util.List;

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
        click(employeeSearchPage.searchBtn);
        Log.info("Search button has been clicked");
    }
    @Then("user should see employee information")
    public void user_should_see_employee_information() {
        waitForElementToBeVisible(employeeSearchPage.searchResults);
        Assert.assertTrue(employeeSearchPage.searchResults.isDisplayed());
        Log.endTestCase("Employee Search using full name test case completed");
        Log.info("Entered employee successfully appeared on the info table");
    }
    @When("user enters employee id {string}")
    public void user_enters_employee_id(String employeeId) {
        waitForElementToBeClickable(employeeSearchPage.empIdField);
        sendText(employeeId, employeeSearchPage.empIdField);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Search Employee using ID test case");
        Log.info("Employee ID has been entered");
    }
    @Then("user should see employee information with matching id {string}")
    public void user_should_see_employee_information_with_matching_id(String expectedEmpId) {
        waitForElementToBeVisible(employeeSearchPage.searchRestTable);

        boolean idFound = false;
        List<WebElement> rows = employeeSearchPage.searchRestTable.findElements(By.tagName("tr"));
        for(WebElement row:rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for(WebElement cell:cells){
                if(cell.getText().equals(expectedEmpId)){
                    idFound = true;
                    break;
                }
            }
            if(idFound){
                break;
            }
        }
        Assert.assertTrue("Employee ID not found",idFound);
        Log.endTestCase("Employee Search using ID test case completed");
        Log.info("Entered employee ID successfully appeared on the info table");
    }
}
