package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class HomePage {

    private final WebDriver driver;
    private By locatorToInit = By.id("carousel");

    @FindBy(xpath = "//span[@class='hidden-sm-down' and contains(text(), 'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//ul[@class='account-list collapse']/li/a[@title='Addresses']")
    private WebElement addressesButton;

    @FindBy(css = ".search-widgets .ui-autocomplete-input")
    private WebElement searchField;


    public HomePage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"index.php");
    }

    public void clickSingInButton(){
        signInButton.click();
    }

    public void clickOnAddresses(){
        addressesButton.click();
    }

    public void searchProductInInputField(String product){
        searchField.click();
        searchField.sendKeys(product);
        searchField.sendKeys(Keys.ENTER);
    }

}
