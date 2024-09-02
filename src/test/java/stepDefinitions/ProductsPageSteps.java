package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsPage;

import static webDriverFactory.driverFactory.driver;

public class ProductsPageSteps {

    ProductsPage productsPage = new ProductsPage(driver);


    @When("user is on products page.")
    public void user_is_on_products_page() {
        Assert.assertEquals(driver.getCurrentUrl(),productsPage.ppProductsPageUrl());
    }

    @Then("user exclusive prime deals heading should be displayed.")
    public void user_exclusive_prime_deals_heading_should_be_displayed() {
        Assert.assertTrue(productsPage.ppEPDHeading());
    }


    @And("all the list of products under prime deals should be displayed.")
    public void allTheListOfProductsUnderPrimeDealsShouldBeDisplayed() {
        Assert.assertEquals(productsPage.ppEPDTotalProductsList(),productsPage.ppEPDTotalProductsStatus());
    }

    @Then("all the EPD product images should be displayed.")
    public void allTheEPDProductImagesShouldBeDisplayed() {
        Assert.assertEquals(productsPage.ppEPDTotalProductsList(),productsPage.ppEPDProductsImagesStatus());
    }

    @Then("all the EPD product titles should be displayed.")
    public void allTheEPDProductTitlesShouldBeDisplayed() {
        Assert.assertEquals(productsPage.ppEPDTotalProductsList(),productsPage.ppEPDProductsTitlesStatus());
    }

    @Then("all the EPD product brands should be displayed.")
    public void allTheEPDProductBrandsShouldBeDisplayed() {
        Assert.assertEquals(productsPage.ppEPDTotalProductsList(),productsPage.ppEPDProductsBrandsStatus());
    }

    @Then("all the EPD product prices should be displayed.")
    public void allTheEPDProductPricesShouldBeDisplayed() {
        Assert.assertEquals(productsPage.ppEPDTotalProductsList(),productsPage.ppEPDProductsPriceStatus());
    }

    @Then("all products main heading element should be displayed.")
    public void allProductsMainHeadingElementShouldBeDisplayed() {
        Assert.assertTrue(productsPage.allProductsHeading());
    }

    @And("all the products under all products section should be displayed.")
    public void allTheProductsUnderAllProductsSectionShouldBeDisplayed() {
        Assert.assertEquals(productsPage.apTotalProductsList(),productsPage.apTotalProductTitles());
    }


    @Then("all product images should be displayed under all products section.")
    public void allProductImagesShouldBeDisplayedUnderAllProductsSection() {
        Assert.assertEquals(productsPage.apTotalProductsList(),productsPage.apTotalProductImages());
    }

    @Then("all product titles should be displayed under all products section.")
    public void allProductTitlesShouldBeDisplayedUnderAllProductsSection() {
        Assert.assertEquals(productsPage.apTotalProductsList(),productsPage.apTotalProductTitles());
    }

    @Then("all product brands should be displayed under all products section.")
    public void allProductBrandsShouldBeDisplayedUnderAllProductsSection() {
        Assert.assertEquals(productsPage.apTotalProductsList(),productsPage.apTotalProductBrands());
    }

    @Then("all product prices should be displayed under all products section.")
    public void allProductPricesShouldBeDisplayedUnderAllProductsSection() {
        Assert.assertEquals(productsPage.apTotalProductsList(),productsPage.apTotalProductPrice());
    }
}
