package webDriverFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class driverFactory {
    public static WebDriver driver;

    public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/webDriverFactory/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void inputData(By locator,String input){
        driver.findElement(locator).sendKeys(input);
    }
    public static void clickOnElement(By locator){
        driver.findElement(locator).click();
    }



}