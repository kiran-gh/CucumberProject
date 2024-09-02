package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;


//    The following are the web elements that are used in home page.
    By hpLogoEle = By.className("website-logo");
    By hpHomeButtonEle = By.xpath("//a[normalize-space()=\"Home\"]");
    By hpProductsButtonEle = By.xpath("//a[normalize-space()=\"Products\"]");
    By hpCartButtonEle = By.xpath("//a[normalize-space()=\"Cart\"]");
    By hpLogoutButtonEle = By.xpath("//button[normalize-space()=\"Logout\"]");
    By hpHeadingEle = By.className("home-heading");
    By hpParagraphEle = By.className("home-description");
    By hpShopNowButtonEle = By.className("shop-now-button");
//    This is the constructor for home page class
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(35));
        loginPage = new LoginPage(driver);
    }
    public String hpUrl(){
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
    public boolean hpHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpHeadingEle));
        return driver.findElement(hpHeadingEle).isDisplayed();
    }
    public boolean hpParagraph(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpParagraphEle));
        return driver.findElement(hpParagraphEle).isDisplayed();
    }
    public boolean hpShopNowButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpShopNowButtonEle));
        return driver.findElement(hpShopNowButtonEle).isDisplayed();
    }
    public String hpProductsButton(){
        driver.findElement(hpProductsButtonEle).click();
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
    public String hpCartButton(){
        driver.findElement(hpCartButtonEle).click();
        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
    public void hpLogoutButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(hpLogoutButtonEle).click();
    }

    public void navigateToProductsPage(){
        loginPage.successfulLogin("rahul","rahul@2021");
        driver.findElement(hpProductsButtonEle).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/products"));
    }

}