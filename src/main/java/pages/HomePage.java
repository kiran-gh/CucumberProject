package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static webDriverFactory.driverFactory.clickOnElement;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    FileInputStream fis = new FileInputStream("data.properties");
    Properties prop = new Properties();


    //**********    HOME PAGE LOCATORS STARTS HERE    **********
    By hpHomeButtonEle = By.xpath("//a[normalize-space()=\"Home\"]");
    By hpProductsButtonEle = By.xpath("//a[normalize-space()=\"Products\"]");
    By hpCartButtonEle = By.xpath("//a[normalize-space()=\"Cart\"]");
    By hpLogoutButtonEle = By.xpath("//button[normalize-space()=\"Logout\"]");
    By hpHeadingEle = By.className("home-heading");
    By hpParagraphEle = By.className("home-description");
    By hpShopNowButtonEle = By.className("shop-now-button");
    //**********    HOME PAGE LOCATORS ENDS HERE    **********

    //**********    HOME PAGE CONSTRUCTOR STARTS HERE    **********
    public HomePage(WebDriver driver) throws IOException {
        prop.load(fis);
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(35));
        loginPage = new LoginPage(driver);
    }
    //**********    HOME PAGE CONSTRUCTOR ENDS HERE    **********

    //**********    HOME PAGE METHODS / FUNCTIONS STARTS HERE    **********
    // hpUrl method captures the current home page url and returns the url value
    public String hpUrl(){
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
    // hpHeading method checks if home page heading element is displayed or not
    public boolean hpHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpHeadingEle));
        return driver.findElement(hpHeadingEle).isDisplayed();
    }
    // hpParagraph method checks if home page paragraph is displayed or not
    public boolean hpParagraph(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpParagraphEle));
        return driver.findElement(hpParagraphEle).isDisplayed();
    }
    // hpShopNowButton method checks if home page shop now button is displayed or not
    public boolean hpShopNowButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpShopNowButtonEle));
        return driver.findElement(hpShopNowButtonEle).isDisplayed();
    }
    // hpProductsButton method is used to click on home page products button and returns products page url
    public String hpProductsButton(){
        clickOnElement(hpProductsButtonEle);
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
    // hpCartButton method is used to click on home page cart button and returns cart page url
    public String hpCartButton(){
        clickOnElement(hpCartButtonEle);
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
    // hpLogoutButton method is used to click on logout button and returns to login page
    public void hpLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpLogoutButtonEle));
        clickOnElement(hpLogoutButtonEle);
    }
    // navigateToProductsPage method is used to navigate to products page
    public void navigateToProductsPage(){
        loginPage.successfulLogin();
        clickOnElement(hpProductsButtonEle);
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("productsPageUrl")));
    }
    //**********    HOME PAGE METHODS / FUNCTIONS ENDS HERE    **********
}