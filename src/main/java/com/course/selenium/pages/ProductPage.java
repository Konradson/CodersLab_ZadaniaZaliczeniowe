package com.course.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class ProductPage {

    private final WebDriver driver;
    private By locatorToInit = By.cssSelector(".add-to-cart");
    @FindBy(css = ".form-control-select")
    private WebElement sizeDropDown;
    @FindBy(id = "quantity_wanted")
    private WebElement countElement;
    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[contains(text(), 'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;

    public ProductPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(this.driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"controller=product");
    }

    public void chooseSize(String size){

        //Click on SizeDropDownTile
        sizeDropDown.click();

        //xpath sizeTileElement (with chosen size)
        String xpathSizeElement = String.format("//option[@title='%s']", size);
        //Find sizeTileElement and save to variable
        WebElement sizeTileElement = sizeDropDown.findElement(By.xpath(xpathSizeElement));
        //Drop Error if there is no Element with this size
        Assert.assertNotNull(sizeTileElement);

        //Click on chosen sizeTileElement
        sizeTileElement.click();
    }

    public void chooseCount(String count){
        //Set product quantity
        countElement.clear();
        countElement.sendKeys(Keys.BACK_SPACE + count);
    }

    public void addToCartAndProceed(){
        //Add to cart
        addToCartButton.click();
        //Wait for ProceedToCheckoutButton
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> proceedToCheckoutButton.isDisplayed());
        //Click on ProceedToCheckoutButton
        proceedToCheckoutButton.click();
    }
}
