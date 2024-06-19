package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utils.CommonMethods;

import java.io.IOException;

public class Hooks extends CommonMethods {

    @Before
    public void start() throws IOException {
        //will use the start application method from common methods
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario) {
        //creating pic in an array of bytes
        byte[] pic;

        //writing if condition to make sure the method takes a screenshot to the right path at failture or success of the scenario
        if (scenario.isFailed()) {
             pic = takeScreenshot("/failed/"+scenario.getName());
        //using takescreenshot method from common methods and passing the path to failed folder;
        } else {
            pic = takeScreenshot("/passed/"+scenario.getName());
            // takescreenshot method from common methods passing the path to passed screenshots
        }
        //Scenario class holds all scenario data so we can get any information from it
        //using .attach method from Scenario class to attack the screenshot to the report
        scenario.attach(pic,"image/png",scenario.getName());

        //After scenario is executed and screenshot is attached to report, we should close the browser
        //using closeBrowser method from common methods
        closeBrowser();
    }

}
