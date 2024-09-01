package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static webDriverFactory.driverFactory.*;

public class LoginPageSteps {
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    LoginPage loginPage = new LoginPage(driver);

    Properties properties = new Properties();
    String filePath = System.getProperty("user.dir")+"\\example.properties";
    FileInputStream file = new FileInputStream(filePath);
    public LoginPageSteps() throws IOException {
        properties.load(file);
        file.close();
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        String urlOfHomePage = (String) properties.getProperty("url");
        driver.get(urlOfHomePage);
        wait.until(ExpectedConditions.urlToBe(urlOfHomePage));
        Assert.assertTrue(driver.getCurrentUrl().contains(urlOfHomePage));
    }

    @When("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        String lpTileName = loginPage.getLoginPageTitle();
    }

    @Then("page title should be React app")
    public void pageTitleShouldBeReactApp() {
        Assert.assertTrue(driver.getTitle().contains((String) properties.getProperty("lpTitle")));
    }

    @When("user enters username rahul")
    public void userEntersUsernameRahul() {
        loginPage.enterUserName((String) properties.getProperty("username"));
    }

    @And("user enters password")
    public void userEntersPasswordRahul() {
        loginPage.enterPassword((String) properties.getProperty("password"));
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @When("user enters invalid username")
    public void userEntersInvalidUsername() {
        loginPage.enterUserName((String) properties.getProperty("invalidUserName"));
    }

    @Then("user gets the error message")
    public void userGetsTheErrorMessage() {
        String lpInvalidUserNameErrorMessage = loginPage.lpInvalidError();
    }

    @And("error message should be invalid username")
    public void errorMessageShouldBeInvalidUsername() {
        Assert.assertTrue(loginPage.lpInvalidError().contains((String) properties.getProperty("invalidUserNameError")));
    }

    @When("user enters invalid password")
    public void userEntersInvalidPassword() {
        loginPage.enterPassword((String) properties.getProperty("invalidPassword"));
    }

    @And("error message should be invalid password")
    public void errorMessageShouldBeInvalidPassword() {
        Assert.assertTrue(loginPage.lpInvalidError().contains((String) properties.getProperty("invalidPasswordError")));
    }

    @When("user enters empty username and password")
    public void userEntersEmptyUsernameAndPassword() {
        loginPage.lpEmptyCredentials((String) properties.getProperty("emptyUserName"), (String) properties.getProperty("emptyPassword"));
    }

    @And("error message should be *Username or password is invalid")
    public void errorMessageShouldBeUsernameOrPasswordIsInvalid() {
        Assert.assertTrue(loginPage.lpInvalidError().contains((String) properties.getProperty("emptyCredentialsError")));
    }

    @When("user enters invalid username and password")
    public void userEntersEmptyInvalidUsernameAndPassword() {
        loginPage.lpInvalidCredentials((String) properties.getProperty("invalidUserName"),(String) properties.getProperty("invalidPassword"));
    }


}
