package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    //    By locators
    private final By lpUserNameInputEle = By.id("username");
    private final By lpPasswordInputEle = By.id("password");
    private final By lpLoginButtonEle = By.className("login-button");
    private final By lpErrorTextEle = By.className("error-message");
    WebDriverWait wait;
//    Constructor of the page class

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

//    page actions

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void enterUserName(String username) {
        driver.findElement(lpUserNameInputEle).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(lpPasswordInputEle).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(lpLoginButtonEle).click();
    }

    public void lpEmptyCredentials(String emptyUserName, String emptyPassword) {
        driver.findElement(lpUserNameInputEle).sendKeys(emptyUserName);
        driver.findElement(lpPasswordInputEle).sendKeys(emptyPassword);
    }

    public void lpInvalidCredentials(String invalidUserName, String invalidPassword) {
        driver.findElement(lpUserNameInputEle).sendKeys(invalidUserName);
        driver.findElement(lpPasswordInputEle).sendKeys(invalidPassword);
    }

    public String lpInvalidError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpErrorTextEle));
        return driver.findElement(lpErrorTextEle).getText();
    }
}
