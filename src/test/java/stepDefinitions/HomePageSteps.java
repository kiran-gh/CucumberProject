package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class HomePageSteps {
    HomePage homePage;
    LoginPage loginPage;
    FileInputStream fis = new FileInputStream("data.properties");
    Properties prop = new Properties();


    public HomePageSteps() throws IOException {
        prop.load(fis);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.successfulLogin();
    }

    @When("user is on home page.")
    public void user_is_on_home_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains(homePage.hpUrl()));
    }

    @Then("home page heading should be displayed.")
    public void home_page_heading_should_be_displayed() {
        Assert.assertTrue(homePage.hpHeading());
    }

    @Then("home page description should be displayed.")
    public void home_page_description_should_be_displayed() {
        Assert.assertTrue(homePage.hpParagraph());
    }

    @Then("shopNow button should be displayed.")
    public void shop_now_button_should_be_displayed() {
        Assert.assertTrue(homePage.hpShopNowButton());
    }

    @When("user clicks on products button in the navbar.")
    public void user_clicks_on_products_button_in_the_navbar() {
        homePage.hpProductsButton();
    }

    @Then("user should be able to navigate to products page.")
    public void user_should_be_able_to_navigate_to_products_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains(homePage.hpProductsButton()));
    }

    @When("user clicks on cart button in the navbar.")
    public void user_clicks_on_cart_button_in_the_navbar() {
        homePage.hpCartButton();
    }

    @Then("user should be able to navigate to cart page.")
    public void user_should_be_able_to_navigate_to_cart_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains(homePage.hpCartButton()));
    }

    @When("user clicks on logout button.")
    public void user_clicks_on_logout_button() {
        homePage.hpLogoutButton();
    }

    @Then("user should be able to navigate to login page.")
    public void user_should_be_able_to_navigate_to_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("loginPageUrl")));
    }
}