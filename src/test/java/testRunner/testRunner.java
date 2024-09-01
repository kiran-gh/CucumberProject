package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/features"},
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty"}
)
public class testRunner extends AbstractTestNGCucumberTests {
}
