package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "@target/failed.txt",
        glue = "steps",
        dryRun = false,
        tags = "@",
        plugin = {"pretty"}


)

public class FailedRunner {
}
