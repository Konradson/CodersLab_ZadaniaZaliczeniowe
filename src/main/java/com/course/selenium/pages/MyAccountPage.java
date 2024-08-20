package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class MyAccountPage {

    private final WebDriver driver;
    private By locatorToInit = By.cssSelector(".link-item .material-icons");

    @FindBy(xpath = "//ul[@class='account-list collapse']/li/a[@title='Addresses']")
    private WebElement addressesButton;
    @FindBy(css=".logo")
    private WebElement logoButton;
    @FindBy(id="history-link")
    private WebElement historyButton;

    public MyAccountPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"my-account");
    }

    public void clickOnAddresses(){
        addressesButton.click();
    }

    public void clickLogoButton(){
        logoButton.click();
    }

    public void clickOnHistory(){
        historyButton.click();
    }
}
