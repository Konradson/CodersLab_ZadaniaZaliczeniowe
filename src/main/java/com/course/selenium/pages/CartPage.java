package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class CartPage {

    private final WebDriver driver;
    private By locatorToInit = By.xpath("//h1[contains(text(), 'Shopping Cart')]");
    @FindBy(xpath = "//a[contains(text(), 'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(this.driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"controller=cart");
    }

    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}
