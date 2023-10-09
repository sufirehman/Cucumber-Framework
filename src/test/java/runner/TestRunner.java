package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", // Location of your feature files
        glue = {"StepDefinitions", "Utility"},// Package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    public TestRunner() throws Exception {
        super();
    }
}