package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static webDriverFactory.driverFactory.clickOnElement;
import static webDriverFactory.driverFactory.inputData;

public class ProductsPage {
    private static WebDriver driver;
    WebDriverWait wait;
    FileInputStream fis = new FileInputStream("data.properties");
    Properties prop = new Properties();

    //**********    PRODUCT PAGE LOCATORS STARTS HERE    **********
    //    ********** THE FOLLOWING ARE THE EXCLUSIVE PRIME DEALS SECTION ELEMENT LOCATORS **********
    By ppEPDHeadingEle = By.className("primedeals-list-heading");
    By ppEPDTotalListOfProducts = By.xpath("(//div[@class=\"product-sections\"]//ul)[1]//li");


    //    ********** THE FOLLOWING ARE THE CATEGORY SECTION ELEMENT LOCATORS **********
    By categoryHeadingEle = By.className("category-heading");
    By ppTotalListOfCategoriesEle = By.className("category-item");
    By categoryClearButtonEle = By.className("clear-filters-btn");
    By searchButtonEle = By.className("search-input");
    By searchIconEle = By.className("search-icon");



    //    ********** THE FOLLOWING ARE THE RATING SECTION ELEMENT LOCATORS **********
    By ratingHeadingEle = By.className("rating-heading");
    By ppTotalListOfRatings = By.className("rating-item");
    By ppFourStarAndAboveEle = By.xpath("//img[@alt=\"rating 4\"]");
    By ppProductsRating = By.xpath("(//ul[@class=\"products-list\"])[2]//p[@class=\"rating\"]");


    //    ********** THE FOLLOWING ARE THE ALL PRODUCTS SECTION ELEMENT LOCATORS **********
    By apHeadingEle = By.className("products-list-heading");
    By ppAPSectionTotalListOfProductsEle = By.xpath("(//div[@class=\"product-sections\"]//ul)[4]//li");

    By titleOfProduct = By.xpath("//h1[@class=\"title\"]");
    //    ********** THE FOLLOWING IS THE CONSTRUCTOR FOR PRODUCTS PAGE **********
    public ProductsPage(WebDriver driver) throws IOException {
        prop.load(fis);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }
    //**********    PRODUCTS PAGE METHODS / FUNCTIONS STARTS HERE    **********
    public String ppTitle(){
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("productsPageUrl")));
        return driver.getTitle();
    }

    public boolean ppEPDHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppEPDHeadingEle));
        return driver.findElement(ppEPDHeadingEle).isDisplayed();
    }
    public boolean ppEPDTotalListOfItemsDisplayStatus(){
        List<WebElement> epdTotalItems = driver.findElements(ppEPDTotalListOfProducts);
        return epdTotalItems.stream().allMatch(WebElement::isDisplayed);
    }


    public void inputDataInToSearchButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryClearButtonEle));
        clickOnElement(categoryClearButtonEle);
        inputData(searchButtonEle, prop.getProperty("searchForAProduct"));
        clickOnElement(searchIconEle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppAPSectionTotalListOfProductsEle));
    }
    public boolean categoryHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryHeadingEle));
        return driver.findElement(categoryHeadingEle).isDisplayed();
    }

    public boolean checkForASpecificProductStatus(){
        inputDataInToSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppAPSectionTotalListOfProductsEle));
        return driver.findElements(titleOfProduct).stream()
                .anyMatch(title -> title.getText().equals(prop.getProperty("searchForAProduct")));
    }
    public boolean ppTotalListOfCategoriesDisplayStatus(){
        List<WebElement> categoriesCount = driver.findElements(ppTotalListOfCategoriesEle);
        return categoriesCount.stream().allMatch(WebElement::isDisplayed);
    }
    public boolean ratingsHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingHeadingEle));
        return driver.findElement(ratingHeadingEle).isDisplayed();
    }
    public boolean ppTotalListOfRatingsDisplayStats(){
        List<WebElement> ratingsCount = driver.findElements(ppTotalListOfRatings);
        return ratingsCount.stream().allMatch(WebElement::isDisplayed);
    }
    public void ppFourStarAndAbove(){
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("productsPageUrl")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryClearButtonEle));
        clickOnElement(categoryClearButtonEle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppFourStarAndAboveEle));
        clickOnElement(ppFourStarAndAboveEle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppTotalListOfCategoriesEle));
    }

    public boolean ppProductsWithSelectedRatingStatus() {
        ppFourStarAndAbove();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppAPSectionTotalListOfProductsEle));
        return driver.findElements(ppProductsRating).stream()
                .anyMatch(element -> Float.parseFloat(element.getText()) >= 4.0);
    }

    public boolean apHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(apHeadingEle));
        return driver.findElement(apHeadingEle).isDisplayed();
    }
    public boolean apTotalListOfProductsDisplayStatus() {
        List<WebElement> apSectionTotalProducts = driver.findElements(ppAPSectionTotalListOfProductsEle);
        return apSectionTotalProducts.stream().allMatch(WebElement::isDisplayed);
    }
    //**********    PRODUCTS PAGE METHODS / FUNCTIONS ENDS HERE    **********
}