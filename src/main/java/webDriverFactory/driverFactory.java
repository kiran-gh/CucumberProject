package webDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driverFactory {
    public static WebDriver driver;

    public static void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/java/webDriverFactory/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void closeBrowser(){
        driver.quit();
    }



}
