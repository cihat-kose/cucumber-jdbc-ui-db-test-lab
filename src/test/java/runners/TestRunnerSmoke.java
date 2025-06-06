package runners;

import io.cucumber.testng.*;

@CucumberOptions
        (
                tags = "@Smoke",
                features = {"src/test/java/features"},
                glue = {"stepDefinitions"},
                plugin = {"pretty"}
        )

public class TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
