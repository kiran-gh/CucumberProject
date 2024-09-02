package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    private static WebDriver driver = null;
    WebDriverWait wait;
    HomePage homePage;
    private int count = 0;

    //    Constructor for Products page
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        homePage = new HomePage(driver);
        homePage.navigateToProductsPage();
    }

    //    Elements under Exclusive Prime deals section.
    By ppEPDHeadingEle = By.className("primedeals-list-heading");
    By ppEPDProductsListEle = By.xpath("(//ul[@class=\"products-list\"])[1]//li");
    By ppEPDProductsImagesEle = By.xpath("(//ul[@class=\"products-list\"])[1]//img[@alt=\"product\"]");
    By ppEPDProductTitleEle = By.xpath("(//ul[@class=\"products-list\"])[1]//h1[@class=\"title\"]");
    By ppEPDProductBrandEle = By.xpath("(//ul[@class=\"products-list\"])[1]//p[@class=\"brand\"]");
    By ppEPDProductPriceEle = By.xpath("(//ul[@class=\"products-list\"])[1]//p[@class=\"price\"]");

//    Elements under Category section.

    //    Elements under All products section (ap - All Products)
    By allProductsHeadingEle = By.className("products-list-heading");
    By apTotalProductsListEle = By.xpath("(//div[@class=\"all-products-container\"])[1]//li");
    By apTotalProductsImagesEle = By.xpath("(//div[@class=\"all-products-container\"])[1]//img[@alt=\"product\"]");
    By apTotalProductsTitlesEle = By.xpath("(//div[@class=\"all-products-container\"])[1]//h1[@class=\"title\"]");
    By apTotalProductsBrandsEle = By.xpath("(//div[@class=\"all-products-container\"])[1]//p[@class=\"brand\"]");
    By apTotalProductsPriceEle = By.xpath("(//div[@class=\"all-products-container\"])[1]//p[@class=\"price\"]");


    //    Actions / Methods that are related to All products sections.
    //    This is the common methods that is used to check the status of the product and the count of the product
    public int ppEPDProductsStatusAndCount(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            Assert.assertTrue(driver.findElement(locator).isDisplayed());
            count = count + 1;
        }
        return count;
    }

    //    Checks the main heading element under all products section
    public boolean allProductsHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeadingEle));
        return driver.findElement(allProductsHeadingEle).isDisplayed();
    }

    //    Total list of items under All products section
    public int apTotalProductsList() {
        List<WebElement> products = driver.findElements(apTotalProductsListEle);
        return products.size();
    }

    //    Total no of product images under all products section
    public int apTotalProductImages() {
        ppEPDProductsStatusAndCount(apTotalProductsImagesEle);
        return count;
    }

    //    Total no of product titles under all products section
    public int apTotalProductTitles() {
        ppEPDProductsStatusAndCount(apTotalProductsTitlesEle);
        return count;
    }

    //    Total no of brands under all products section
    public int apTotalProductBrands() {
        ppEPDProductsStatusAndCount(apTotalProductsBrandsEle);
        return count;
    }

    //    Total no of prices under all products section
    public int apTotalProductPrice() {
        ppEPDProductsStatusAndCount(apTotalProductsPriceEle);
        return count;
    }


    //    Actions / Methods that are related to exclusive prime deals.
    //    Checks the products page url
    public String ppProductsPageUrl() {
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/products"));
        return driver.getCurrentUrl();
    }

    //    Checks Exclusive prime deals heading element
    public boolean ppEPDHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppEPDHeadingEle));
        return driver.findElement(ppEPDHeadingEle).isDisplayed();
    }

    //    Counts total no of products under Exclusive prime deals section.
    public int ppEPDTotalProductsList() {
        List<WebElement> EPDTotalProducts = driver.findElements(ppEPDProductsListEle);
        return EPDTotalProducts.size();
    }

    //    Checks if each product under exclusive prime deals is displaying or not and returns the count
    public int ppEPDTotalProductsStatus() {
        ppEPDProductsStatusAndCount(ppEPDProductsListEle);
        return count;
    }

    //    Checks if each product image under exclusive prime deals is displaying or not and returns the count
    public int ppEPDProductsImagesStatus() {
        ppEPDProductsStatusAndCount(ppEPDProductsImagesEle);
        return count;
    }

    //    Checks if each product title under exclusive prime deals is displaying or not and returns the count
    public int ppEPDProductsTitlesStatus() {
        ppEPDProductsStatusAndCount(ppEPDProductTitleEle);
        return count;
    }

    //    Checks if each product brand under exclusive prime deals is displaying or not and returns the count
    public int ppEPDProductsBrandsStatus() {
        ppEPDProductsStatusAndCount(ppEPDProductBrandEle);
        return count;
    }

    //    Checks if each product price under exclusive prime deals is displaying or not and returns the count
    public int ppEPDProductsPriceStatus() {
        ppEPDProductsStatusAndCount(ppEPDProductPriceEle);
        return count;
    }

}