package runners;

import io.cucumber.testng.*;

@CucumberOptions
        (
        tags = "@Regression",
        features = {"src/test/java/features"},
        glue = {"stepDefinitions"},
        plugin = {"pretty"}
        )

public class TestRunnerRegression extends AbstractTestNGCucumberTests {
}
