package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static webDriverFactory.driverFactory.clickOnElement;
import static webDriverFactory.driverFactory.inputData;


public class CartPage {
    // Declare WebDriver and WebDriverWait for managing browser actions
    private WebDriver driver;
    private WebDriverWait wait;
    ProductsPage productsPage;
    HomePage homePage;


    // Page objects representing elements on the Cart Page
    private By shopNowButton = By.className("shop-now-btn");
    By cpTotalListOfItems = By.xpath("//li[@class=\"cart-item\"]");
    By cpProductHeading = By.xpath("//h1[@class=\"product-name\"]");
    By cpDeleteButtonEle = By.xpath("//button[@testid=\"remove\"]");


    // Properties file to load URLs and configurations
    private Properties prop = new Properties();

    // Constructor to initialize WebDriver, WebDriverWait, and load the properties file
    public CartPage(WebDriver driver) throws IOException {
        this.driver = driver;
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);

        // Load properties from the data.properties file
        FileInputStream fis = new FileInputStream("data.properties");
        prop.load(fis);

        // Initialize WebDriverWait with a 35-second timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    // Method to get the current URL of the cart page
    public String getCartPageUrl() {
        return driver.getCurrentUrl();
    }

    // Method to click the "Shop Now" button and wait until the user is redirected to the Products Page
    public void clickShopNowButton() {
        // Click on the "Shop Now" button element
        driver.findElement(shopNowButton).click();
        // Wait until the URL changes to the Products Page URL defined in the properties file
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("productsPageUrl")));
    }

    public void searchForAProduct(String string) {
        inputData(productsPage.searchButtonEle, string);
        driver.findElement(productsPage.searchButtonEle).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.ppAPSectionTotalListOfProductsEle));
    }

    public void selectProductAndQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.searchForAProductEle));
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(productsPage.searchForAProductEle);
        actions.moveToElement(ele).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.searchForAProductEle));
        clickOnElement(productsPage.searchForAProductEle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.ppQuantityIncreaseButtonEle));
        clickOnElement(productsPage.ppQuantityIncreaseButtonEle);
    }

    public void clickOnCartIcon() {
        clickOnElement(productsPage.ppCartCountBadgeEle);
    }

    public int totalCartItemsCount() {
        List<WebElement> elements = driver.findElements(cpTotalListOfItems);
        return elements.size();
    }

    public void selectingMultipleProducts() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Select and add multiple products by calling the reusable method
        selectAndAddProduct("Chronograph black Watch");
        selectAndAddProduct("Sheer Anarkali");
        selectAndAddProduct("Knitted Rabbit");
    }

    public int removeItemFromCart(){
        List<WebElement> deleteItems =  driver.findElements(cpDeleteButtonEle);
        return deleteItems.size();
//        for (WebElement deleteItem : deleteItems) {
//            if(deleteItems.size()>1){
//                clickOnElement(cpDeleteButtonEle);
//            }else{
//                System.out.println("Unable to delete item");
//            }
//        }
    }


    /**
     * Reusable method to select a product, increase its quantity, and add it to the cart.
     *
     * @param productTitle The title of the product to select and add to the cart.
     */
    public void selectAndAddProduct(String productTitle) {
        // Wait for the products page to load
//        wait.until(ExpectedConditions.urlToBe(prop.getProperty("productsPageUrl")));

        // Locate the product by its title
        WebElement productElement = driver.findElement(By.xpath("//h1[normalize-space()='" + productTitle + "']"));

        // Scroll down to the product element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", productElement);

        // Click on the product to open its details
        productElement.click();

        // Wait for the quantity increase button to be visible and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.ppQuantityIncreaseButtonEle));
        clickOnElement(productsPage.ppQuantityIncreaseButtonEle);

        // Wait for the Add to Cart button to be visible and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.ppAddToCartButtonEle));
        clickOnElement(productsPage.ppAddToCartButtonEle);

        // Wait for the "Products" button to be visible and click it to return to the products page
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.hpProductsButtonEle));
        clickOnElement(homePage.hpProductsButtonEle);
    }

    public void removingItemFromCart() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cpDeleteButtonEle)));
        clickOnElement(cpDeleteButtonEle);
    }


}