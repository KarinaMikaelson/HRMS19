package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Log;

public class AccessingMembershipSectionSteps extends CommonMethods {
    @When("user clicks on My Info page")
    public void user_clicks_on_my_info_page() {
        click(accessingMembershipSectionPage.myInfo);
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("Accessing Membership Section Test Case");
        Log.info("my info page has been clicked");
    }
    @When("user clicks on the Memberships section")
    public void user_clicks_on_the_memberships_section() {
        click(accessingMembershipSectionPage.membershipsSection);
        Log.info("Membership Section has been clicked");
    }
    @Then("user successfully entered Assigned Memberships page")
    public void user_successfully_entered_assigned_memberships_page() {
        Assert.assertTrue(accessingMembershipSectionPage.assignedMembershipPage.isDisplayed());
        Log.info("Assigned Memberships page has been successfully opened");

    }
}
