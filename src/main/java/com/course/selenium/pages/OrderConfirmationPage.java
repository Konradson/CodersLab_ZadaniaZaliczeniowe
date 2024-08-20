package com.course.selenium.pages;

import com.course.selenium.helpers.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

import static com.course.selenium.helpers.BrowserFactory.setOrderPrice;
import static com.course.selenium.helpers.BrowserFactory.setOrderReference;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class OrderConfirmationPage {

    private final WebDriver driver;
    private By locatorToInit = By.xpath("//span[contains(text(), 'Order confirmation')]");
    @FindBy(id = "content")
    private WebElement paymentConfirmationElement;
    @FindBy(xpath = "//div[@id='_desktop_user_info']//span[@class='hidden-sm-down']")
    private WebElement loginIcon;
    @FindBy(xpath = "//section[@id='content-hook_payment_return']//span/strong")
    private WebElement priceElement;


    public OrderConfirmationPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(this.driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"controller=order-confirmation");
    }

    public void takeScreenShot(){

        //Get current date to string
        String currentDate = LocalDate.now().toString();

        //Set source and destination of Screenshot Element
        File source = paymentConfirmationElement.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("D:\\OrderConfirmation_" + currentDate + ".png");

        //Take Screenshot
        try {
            FileHandler.copy(source, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveOrderReference(){
        //Get whole text of order reference (eg. "Order reference: DUUUKASWD")
        String orderRef = driver.findElement(By.id("order-reference-value")).getText();

        //Cut the text and leave only last 9 letters
        orderRef = orderRef.substring(orderRef.length() - 9);
        //Another way
        //orderRef = orderRef.replace("Order reference: ","");

        //Save undercut text of orderRef to orderReference into BrowserFactory variable
        setOrderReference(orderRef);
        //Save price (with currency) into BrowserFactory variable
        setOrderPrice(priceElement.getText());
    }

    public void clickOnLoginIcon(){
        loginIcon.click();
    }
}
