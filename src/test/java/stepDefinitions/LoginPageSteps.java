package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static webDriverFactory.driverFactory.*;

public class LoginPageSteps {

    LoginPage loginPage  = new LoginPage(driver);
    FileInputStream fis = new FileInputStream("data.properties");
    Properties prop = new Properties();

    WebDriverWait wait;

    public LoginPageSteps() throws IOException {
        prop.load(fis);
        driver.get(prop.getProperty("loginPageUrl"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Assert.assertTrue(driver.getTitle().contains(loginPage.getLoginPageTitle()));
    }

    @Given("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }


    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.lpErrorMessage());
    }


    @Then("user gets the title of the login page")
    public void user_gets_the_title_of_the_login_page() {
        Assert.assertTrue(driver.getTitle().contains(loginPage.getLoginPageTitle()));
    }

    @When("user enters username")
    public void user_enters_username() {
        loginPage.enterUserName(prop.getProperty("username"));
    }

    @When("user enters password")
    public void user_enters_password() {
        loginPage.enterPassword(prop.getProperty("password"));
    }


    @When("user enters invalid username")
    public void user_enters_invalid_username() {
        loginPage.enterUserName(prop.getProperty("invalidUserName"));
    }

    @When("user enters invalid password")
    public void user_enters_invalid_password() {
        loginPage.enterPassword(prop.getProperty("invalidPassword"));
    }

    @When("user enters empty username")
    public void user_enters_empty_username() {
        loginPage.enterUserName(prop.getProperty("emptyUsername"));
    }

    @When("user enters empty password")
    public void user_enters_empty_password() {
        loginPage.enterPassword(prop.getProperty("emptyPassword"));
    }


    @Then("user navigates to home page")
    public void userNavigatesToHomePage() {
        Assert.assertEquals(loginPage.homePageUrl(),prop.getProperty("homePageUrl"));
    }
}