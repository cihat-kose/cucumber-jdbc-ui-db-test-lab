package runners;

import io.cucumber.testng.*;

@CucumberOptions
        (
                tags = "@Smoke",
                features = "src/test/java/features",
                glue = "stepDefinitions",
                plugin = {"pretty", "html:target/site/cucumber-pretty.html"},
                dryRun = false
        )

public class TestRunnerWithPlugin extends AbstractTestNGCucumberTests {
}
