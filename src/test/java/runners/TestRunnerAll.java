package runners;

import io.cucumber.testng.*;

@CucumberOptions
        (
                features = {"src/test/java/features"},
                glue = {"stepDefinitions"},
                plugin = {"pretty"}
        )

public class TestRunnerAll extends AbstractTestNGCucumberTests {
}
