package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class CartPageSteps {

    // Page objects for interacting with various pages in the application
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final ProductsPage productsPage;
    private final CartPage cartPage;
    private final WebDriverWait wait;

    // File input stream and properties for configuration
    private final FileInputStream fis = new FileInputStream("data.properties");
    private final Properties prop = new Properties();

    // Constructor to initialize the CartPageSteps and setup the necessary configurations
    public CartPageSteps() throws IOException {
        // Load properties file containing configuration data like URLs
        prop.load(fis);

        // Initialize login page and perform a successful login
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin();

        // Initialize home page and navigate to the cart page
        homePage = new HomePage(driver);
        homePage.hpCartButton();

        // Initialize products and cart page objects for further operations
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        // Setup WebDriverWait with a timeout of 35 seconds for synchronization
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    // Step definition to verify that the user is on the cart page
    @Given("User is on the cart page")
    public void user_is_on_the_cart_page() {
        // Assert that the current URL contains the expected cart page URL
        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("cartPageUrl")));
    }

    // Step to verify that the cart page URL matches the expected value
    @Then("the cart page URL should match the expected URL")
    public void theCartPageURLShouldMatchTheExpectedURL() {
        // Assert that the current URL matches the cart page URL from the properties file
        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("cartPageUrl")));
    }

    // Step to handle clicking a specific button (e.g., "Shop Now")
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        // Click the "Shop Now" button to navigate to the products page
        cartPage.clickShopNowButton();
    }

    // Step to verify that the user is redirected to the products page
    @Then("the user is redirected to the products page")
    public void theUserIsRedirectedToTheProductsPage() {
        // Assert that the current URL contains the expected products page URL
        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("productsPageUrl")));
    }

    // Step to search for a specific product by title
    @And("the user searches for a product titled {string}")
    public void theUserSearchesForAProductTitled(String productTitle) {
        // Search for a product using the provided title
        cartPage.searchForAProduct(productTitle);
    }

    // Step to select a product and specify the quantity
    @When("the user selects the desired product with a specified quantity")
    public void theUserSelectsTheDesiredProductWithASpecifiedQuantity() {
        // Select the product and specify the desired quantity
        cartPage.selectProductAndQuantity();
    }

    // Step to add the selected product to the cart
    @And("the product is added to the cart")
    public void theProductIsAddedToTheCart() {
        // Add the selected product to the cart
        productsPage.addProductToCart();
    }

    // Step to click the cart icon and view the cart
    @When("the user clicks on the cart icon")
    public void theUserClicksOnTheCartIcon() {
        // Click on the cart icon to navigate to the cart page
        cartPage.clickOnCartIcon();
    }

    // Step to verify that the total number of products in the cart matches the cart icon count
    @Then("the total number of products in the cart page should match the cart icon count")
    public void theTotalNumberOfProductsInTheCartPageShouldMatchTheCartIconCount() {
        // Assert that the number of items in the cart matches the count displayed on the cart icon
        Assert.assertEquals(cartPage.totalCartItemsCount(), productsPage.cartCountBadge());
    }

    // Step to add multiple items to the cart
    @And("the user adds multiple items to the cart")
    public void theUserAddsMultipleItemsToTheCart() {
        // Select and add multiple products to the cart
        cartPage.selectingMultipleProducts();
    }

    @Then("user deletes a product from the cart")
    public void userDeletesAProductFromTheCart() {
        int beforeDeletingCartSize = productsPage.cartCountBadge();
        System.out.println("Before deleting a product cart size is: " + beforeDeletingCartSize);
        cartPage.removingItemFromCart();
        int afterDeletingCartSize = productsPage.cartCountBadge();
        System.out.println("After deleting a product cart size is: " + afterDeletingCartSize);
        Assert.assertTrue(beforeDeletingCartSize > afterDeletingCartSize);
    }
}









































//==============================================








//package stepDefinitions;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import pages.CartPage;
//import pages.HomePage;
//import pages.LoginPage;
//import pages.ProductsPage;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.List;
//import java.util.Properties;
//
//import static webDriverFactory.driverFactory.driver;
//
//public class CartPageSteps {
//    // Declare page objects and utilities for the CartPageSteps class
//    LoginPage loginPage;
//    HomePage homePage;
//    ProductsPage productsPage;
//    CartPage cartPage;
//    WebDriverWait wait;
//    FileInputStream fis = new FileInputStream("data.properties");
//    Properties prop = new Properties();
//
//    // Constructor for CartPageSteps to initialize required objects and properties
//    public CartPageSteps() throws IOException {
//        // Load properties file containing URL and other configurations
//        prop.load(fis);
//
//        // Initialize LoginPage object and perform a successful login
//        loginPage = new LoginPage(driver);
//        loginPage.successfulLogin();
//
//        // Initialize HomePage object and click the cart button
//        homePage = new HomePage(driver);
//        homePage.hpCartButton();
//
//        // Initialize ProductsPage and CartPage objects
//        productsPage = new ProductsPage(driver);
//        cartPage = new CartPage(driver);
//
//        // Initialize WebDriverWait with a timeout of 35 seconds
//        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
//    }
//
//    @Given("User is on the cart page")
//// Verify that the user is on the cart page by checking if the current URL contains the expected cart page URL
//    public void user_is_on_the_cart_page() {
//        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("cartPageUrl")));
//    }
//
//    @Then("the cart page URL should match the expected URL")
//    public void theCartPageURLShouldMatchTheExpectedURL() {
//        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("cartPageUrl")));
//    }
//
//    @When("the user clicks on the {string} button")
//    public void theUserClicksOnTheButton(String arg0) {
//        cartPage.clickShopNowButton();
//    }
//
//    @Then("the user is redirected to the products page")
//    public void theUserIsRedirectedToTheProductsPage() {
//        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("productsPageUrl")));
//    }
//
//    @And("the user searches for a product titled {string}")
//    public void theUserSearchesForAProductTitled(String string) {
//        cartPage.searchForAProduct(string);
//    }
//    @When("the user selects the desired product with a specified quantity")
//    public void theUserSelectsTheDesiredProductWithASpecifiedQuantity() {
//        cartPage.selectProductAndQuantity();
//    }
//    @And("the product is added to the cart")
//    public void theProductIsAddedToTheCart() {
//        productsPage.addProductToCart();
//    }
//
//    @When("the user clicks on the cart icon")
//    public void theUserClicksOnTheCartIcon() {
//        cartPage.clickOnCartIcon();
//    }
//    @Then("the total number of products in the cart page should match the cart icon count")
//    public void theTotalNumberOfProductsInTheCartPageShouldMatchTheCartIconCount() {
//        Assert.assertEquals(cartPage.totalCartItemsCount(),productsPage.cartCountBadge());
//    }
//
//    @And("the user adds multiple items to the cart")
//    public void theUserAddsMultipleItemsToTheCart() {
//        cartPage.selectingMultipleProducts();
//    }
//}