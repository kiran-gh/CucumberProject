package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class LoginPageSteps {
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    LoginPage loginPage = new LoginPage(driver);

    Properties properties = new Properties();
    String filePath = System.getProperty("user.dir") + "\\example.properties";
    FileInputStream file = new FileInputStream(filePath);

    public LoginPageSteps() throws IOException {
        properties.load(file);
        file.close();
    }

    public String stringCasting(String valueOfTheProperty) {
        return properties.getProperty(valueOfTheProperty);
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        String urlOfHomePage = stringCasting("url");
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
        Assert.assertTrue(driver.getTitle().contains(stringCasting("lpTitle")));
    }

    @When("user enters username rahul")
    public void userEntersUsernameRahul() {
        loginPage.enterUserName(stringCasting("username"));
    }

    @And("user enters password")
    public void userEntersPasswordRahul() {
        loginPage.enterPassword(stringCasting("password"));
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @When("user enters invalid username")
    public void userEntersInvalidUsername() {
        loginPage.enterUserName(stringCasting("invalidUserName"));
    }

    @Then("user gets the error message")
    public void userGetsTheErrorMessage() {
        String lpInvalidUserNameErrorMessage = loginPage.lpInvalidError();
    }

    @And("error message should be invalid username")
    public void errorMessageShouldBeInvalidUsername() {
        Assert.assertTrue(loginPage.lpInvalidError().contains(stringCasting("invalidUserNameError")));
    }

    @When("user enters invalid password")
    public void userEntersInvalidPassword() {
        loginPage.enterPassword(stringCasting("invalidPassword"));
    }

    @And("error message should be invalid password")
    public void errorMessageShouldBeInvalidPassword() {
        Assert.assertTrue(loginPage.lpInvalidError().contains(stringCasting("invalidPasswordError")));
    }

    @When("user enters empty username and password")
    public void userEntersEmptyUsernameAndPassword() {
        loginPage.lpEmptyCredentials(stringCasting("emptyUserName"), stringCasting("emptyPassword"));
    }

    @And("error message should be *Username or password is invalid")
    public void errorMessageShouldBeUsernameOrPasswordIsInvalid() {
        Assert.assertTrue(loginPage.lpInvalidError().contains(stringCasting("emptyCredentialsError")));
    }

    @When("user enters invalid username and password")
    public void userEntersEmptyInvalidUsernameAndPassword() {
        loginPage.lpInvalidCredentials(stringCasting("invalidUserName"), stringCasting("invalidPassword"));
    }


}
