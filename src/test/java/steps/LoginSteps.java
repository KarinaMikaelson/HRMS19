package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.ExcelReader;
import utils.Log;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("User enters invalid credentials and get error message")
    public void user_enters_invalid_credentials_and_get_error_message() throws IOException {
        //Add the following data to excel, empty username and actual password, error :"Username cannot be empty."
        //Add actual username but empty password, error : "Password cannot be empty."
        //Add invalid credentials, error : "Invalid credentials. Please check your username and password and try again."
        Log.info("Entering invalid credentials");
        Log.info("Blank username + valid password");
        Log.info("actual username + blank password");
        Log.info("wrong username + wrong password");

        List<Map<String, String>> invalidLoginData = ExcelReader.read(System.getProperty("user.dir") + "/src/test/resources/testdata/LoginInvalidCredentials.xlsx", "data");

        for (Map<String, String> data : invalidLoginData) {

            sendText(data.get("userName"), loginPage.usernameField);
            sendText(data.get("password"), loginPage.passwordField);
            click(loginPage.loginButton);
            Assert.assertEquals(data.get("errorMessage"), loginPage.errorMessage.getText());
            Assert.assertTrue(loginPage.usernameField.isEnabled());
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        }
        //take screenshot of the error message to make sure its visible near the respective input fields or
        // use .getLocation method on both the input field and the error message to make sure they are close
        //After error message is displayed, user isDisplayed or isEnabled to make sure user can still try again

    }

    @When("Admin user enters valid admin username and password")
    public void admin_user_enters_valid_admin_username_and_password() throws IOException {
        Log.info("Login Test Case Starting");
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
        Log.info("Entered valid admin credentials");

    }

    @When("User click login")
    public void user_click_login() {
        //access the login button locator from Login page and perform a click using click from common methods
        click(loginPage.loginButton);
        Log.info("Clicked Login Button");
    }

    @Then("user is successfully logged in and navigated to dashboard page")
    public void userIsSuccessfullyLoggedInAndNavigatedToDashboardPage() {
        //retrieve the welcome message from the dashboard page and use Assertion to compare it
        Assert.assertEquals("Welcome Admin", dashboardpage.welcomeAdmin.getText());
        Log.info("Validating welcome message from Dashboard page");

    }


    @When("Employee enters valid employee username and password")
    public void employee_enters_valid_employee_username_and_password() throws IOException {
      sendText(ConfigReader.read("empUsername"),loginPage.usernameField);
      sendText(ConfigReader.read("empPassword"), loginPage.passwordField);
    }
    @When("Employee clicks login")
    public void employee_clicks_login() {
     click(loginPage.loginButton);
    }
    @Then("Employee is sucessfully logged in")
    public void employee_is_sucessfully_logged_in() {
      Assert.assertTrue(dashboardpage.welcomeMessage.isDisplayed());
    }
}
