package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import webDriverFactory.driverFactory;

import java.io.File;
import java.io.IOException;

import static webDriverFactory.driverFactory.driver;


public class loginPageHooks {


    @Before
    public void setUp() {
        driverFactory.launchBrowser();
    }

    @After(order = 0)
    public void tearDown() {
        driverFactory.closeBrowser();
    }

    @After(order = 1)
    public void scenarioFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Capture screenshot logic
             File fileName = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(fileName,new File(".//Screenshot/" + scenario.getName() + ".png"));
           }
    }
}