package stepDefinitions;

import io.cucumber.java.en.And;
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
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    Properties properties = new Properties();
    String filePath = System.getProperty("user.dir") + "\\example.properties";
    FileInputStream file = new FileInputStream(filePath);
    //    stringCasting is the method which is used frequently in this class
    public String stringCasting(String valueOfTheProperty) {
        return properties.getProperty(valueOfTheProperty);
    }
//    Constructor for homepage
    public HomePageSteps() throws IOException {
        properties.load(file);
//        file.close();
        loginPage.successfulLogin(stringCasting("username"),stringCasting("password"));
    }


    @When("user is on home page.")
    public void user_is_on_home_page() {
       Assert.assertTrue(homePage.hpUrl().contains(stringCasting("homePageUrl")));
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

    @And("user clicks on products button in the navbar.")
    public void userClicksOnProductsButtonInTheNavbar() {
        homePage.hpProductsButton();
    }

    @Then("user should be able to navigate to products page.")
    public void userShouldBeAbleToNavigateToProductsPage() {
        Assert.assertTrue(homePage.hpProductsButton().contains((String) stringCasting("productsPageUrl")));
    }

    @And("user clicks on cart button in the navbar.")
    public void userClicksOnCartButtonInTheNavbar() {
        homePage.hpCartButton();
    }

    @Then("user should be able to navigate to cart page.")
    public void userShouldBeAbleToNavigateToCartPage() {
        Assert.assertTrue(homePage.hpCartButton().contains((String) stringCasting("cartPageUrl")));
    }


    @When("user clicks on logout button.")
    public void userClicksOnLogoutButton() throws InterruptedException {
        homePage.hpLogoutButton();
    }

    @Then("user should be able to navigate to home page.")
    public void userShouldBeAbleToNavigateToHomePage() {
        Assert.assertTrue(driver.getCurrentUrl().contains(stringCasting("url")));
    }
}
