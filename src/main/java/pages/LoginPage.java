package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
//    By locators
    private By lpUserNameInputEle = By.id("username");
    private By lpPasswordInputEle = By.id("password");
    private By lpLoginButtonEle = By.className("login-button");
//    Constructor of the page class

    public LoginPage(){
        this.driver = driver;
    }

//    page actions

    public String getLoginPageTitle(){
        return driver.getTitle();
    }
    public void enterUserName(String username){
        driver.findElement(lpUserNameInputEle).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(lpPasswordInputEle).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(lpLoginButtonEle).click();
    }



}
