package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static webDriverFactory.driverFactory.driver;

public class ProductsPageSteps {
    private static final Logger log = LoggerFactory.getLogger(ProductsPageSteps.class);
    HomePage homePage;
    ProductsPage productsPage;
    FileInputStream fis = new FileInputStream("data.properties");
    Properties prop = new Properties();

    public ProductsPageSteps() throws IOException {
        prop.load(fis);
        homePage = new HomePage(driver);
        homePage.navigateToProductsPage();
        productsPage = new ProductsPage(driver);
    }

    @When("user is on products page")
    public void user_is_on_products_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("productsPageUrl")));
    }

    @Then("user exclusive prime deals heading should be displayed")
    public void userExclusivePrimeDealsHeadingShouldBeDisplayed() {
        Assert.assertTrue(productsPage.ppEPDHeading());
    }

    @Then("all products main heading element should be displayed")
    public void allProductsMainHeadingElementShouldBeDisplayed() {
        Assert.assertTrue(productsPage.apHeading());
    }

    @Then("category heading should be displayed")
    public void categoryHeadingShouldBeDisplayed() {
        Assert.assertTrue(productsPage.categoryHeading());
    }

    @And("ratings heading should be displayed")
    public void ratingsHeadingShouldBeDisplayed() {
        Assert.assertTrue(productsPage.ratingsHeading());
    }

    @And("all products under exclusive prime deals should be displayed.")
    public void allProductsUnderExclusivePrimeDealsShouldBeDisplayed() {
        Assert.assertTrue(productsPage.ppEPDTotalListOfItemsDisplayStatus());
    }

    @And("all categories under category section should be displayed.")
    public void allCategoriesUnderCategorySectionShouldBeDisplayed() {
        Assert.assertTrue(productsPage.ppTotalListOfCategoriesDisplayStatus());
    }

    @And("all ratings under ratings section should be displayed")
    public void allRatingsUnderRatingsSectionShouldBeDisplayed() {
        Assert.assertTrue(productsPage.ppTotalListOfRatingsDisplayStats());
    }

    @And("all products under All products section should be displayed")
    public void allProductsUnderAllProductsSectionShouldBeDisplayed() {
        Assert.assertTrue(productsPage.apTotalListOfProductsDisplayStatus());
    }

    @And("searches for a specific product with {string}")
    public void searchesForASpecificProductWith(String string) {
         productsPage.searchForAProduct(string);
    }

    @Then("the product with the searched title should be present in the list of items.")
    public void theProductWithTheSearchedTitleShouldBePresentInTheListOfItems() {
        Assert.assertTrue(productsPage.checkForASelectedProduct());
    }

    @And("clicks on any specific rating under category list")
    public void clicksOnAnySpecificRatingUnderCategoryList() {
        productsPage.ppFourStarAndAbove();
    }

    @Then("all the products with specified rating should be displayed.")
    public void allTheProductsWithSpecifiedRatingShouldBeDisplayed() {
        Assert.assertTrue(productsPage.ppProductsWithSelectedRatingStatus());
    }
}