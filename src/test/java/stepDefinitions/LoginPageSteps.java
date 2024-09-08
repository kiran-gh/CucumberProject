package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static webDriverFactory.driverFactory.*;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage(driver);
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
    @Then("user gets the title of the login page")
    public void user_gets_the_title_of_the_login_page() {
        Assert.assertTrue(driver.getTitle().contains(loginPage.getLoginPageTitle()));
    }
    @When("user enters {string} in username input filed and {string} in password input field")
    public void user_enters_in_username_input_filed_and_in_password_input_field(String string, String string2, DataTable dataTable) {
        List<Map<String,String>> listData =  dataTable.asMaps(String.class,String.class);
        for(Map<String,String> e : listData){
            loginPage.enterUserName(e.get("userName"));
            loginPage.enterPassword(e.get("password"));
        }
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }
    @Then("user navigates to home page")
    public void user_navigates_to_home_page() {
       Assert.assertTrue(driver.getCurrentUrl().contains(loginPage.homePageUrl()));
    }
    @When("user enter {string} and {string}")
    public void user_enter_and(String string, String string2) {
        loginPage.enterUserName(string);
        loginPage.enterPassword(string2);
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.lpErrorMessage());
        System.out.println(loginPage.errorMessage());
    }
}