package com.course.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class SearchResultPage {

    private final WebDriver driver;
    private By locatorToInit = By.id("js-product-list-header");
    @FindBy (xpath = "//article[@data-id-product='2']//*[text()='Hummingbird printed sweater']")
    private WebElement productTile;

    public SearchResultPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(this.driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"controller=search");
    }

    public void checkProductDiscount(String dataIdProduct, String discount){
        //Find product with id "<dataIdProduct>" (id 2 in this case) and save it to xpath string variable
        String productWithID = String.format("//article[@data-id-product='%s']//span[text()='-%s']", dataIdProduct, discount);
        //Wait a few second for the Element to appear on the screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        //Get Text of this Element (in this case "-20%") and save it to variable
        String discountedElement = driver.findElement(By.xpath(productWithID)).getText();
        //Print Error if any discount is not found
        Assert.assertFalse("Discount on product with id " + dataIdProduct + " did not found!",
                discountedElement.contains("-" + discount));
    }

    public void clickOnProduct(String dataIdProduct){
        //FIND PRODUCT WITH ID "<dataIdProduct>" AND CLICK ON IT

        //Get xpath string of product with id "<dataIdProduct>" and save it to variable
        String productWithID = String.format("//article[@data-id-product='%s']//*[text()='Hummingbird printed sweater']", dataIdProduct);
        //Wait a few second for the Element to appear on the screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        //Find product Element with id "<dataIdProduct>" (id 2 in this case) and save variable
        WebElement productElement = driver.findElement(By.xpath(productWithID));
        //Click on product
        productElement.click();
    }




}
