package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static webDriverFactory.driverFactory.*;

public class LoginPage {
    private final WebDriver driver;
    WebDriverWait wait;
    FileInputStream fis = new FileInputStream("data.properties");
    Properties prop = new Properties();

    //**********    LOGIN PAGE LOCATORS STARTS HERE    **********
    private final By lpUserNameInputEle = By.id("username");
    private final By lpPasswordInputEle = By.id("password");
    private final By lpLoginButtonEle = By.className("login-button");
    private final By lpErrorTextEle = By.className("error-message");
    //**********    LOGIN PAGE LOCATORS ENDS HERE    **********


    //**********    LOGIN PAGE CONSTRUCTOR STARTS HERE    **********
    public LoginPage(WebDriver driver) throws IOException {
        prop.load(fis);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }
    //**********    LOGIN PAGE CONSTRUCTOR ENDS HERE    **********

    //**********    LOGIN PAGE METHODS / FUNCTIONS STARTS HERE    **********

    // getLoginPageTitle method returns the title of the current page(in this case login page)
    public String getLoginPageTitle() {
        driver.get(prop.getProperty("loginPageUrl"));
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("loginPageUrl")));
        return driver.getTitle();
    }
    // enterUserName method is used to enter username in the username input field
    public void enterUserName(String username) {
        inputData(lpUserNameInputEle,username);
    }
    // enterPassword method is used to enter password in the password input field
    public void enterPassword(String password) {
        inputData(lpPasswordInputEle,password);
    }
    // clickOnLoginButton method is used to click on login button that is present in the login page
    public void clickOnLoginButton() {
        clickOnElement(lpLoginButtonEle);
    }
    // lpInvalidError method catches error method and return the error method
    public boolean lpErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpErrorTextEle));
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        return driver.findElement(lpErrorTextEle).isDisplayed();
    }
    public String errorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpErrorTextEle));
        return driver.findElement(lpErrorTextEle).getText();
    }

    // successfulLogin method is used to enter valid username and valid password inside username input field and password input field
    public void successfulLogin(){
        driver.get(prop.getProperty("loginPageUrl"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpUserNameInputEle));
        inputData(lpUserNameInputEle,prop.getProperty("username"));
        inputData(lpPasswordInputEle,prop.getProperty("password"));
        clickOnElement(lpLoginButtonEle);
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageUrl")));
    }
    public String homePageUrl(){
        successfulLogin();
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageUrl")));
        return driver.getCurrentUrl();
    }

    //**********    LOGIN PAGE METHODS / FUNCTIONS ENDS HERE    **********
}