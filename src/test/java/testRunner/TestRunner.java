package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/java/features"},
        glue = {"stepDefinitions", "hooks"},
//        tags = "@cartPage",
        plugin = {"pretty",
                "json:target/MyReports/report.json",
                "json:target/MyReports/report.xml"},
        publish = true,
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
 }