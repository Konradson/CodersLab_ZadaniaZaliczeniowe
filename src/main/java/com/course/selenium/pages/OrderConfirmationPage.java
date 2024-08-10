package com.course.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class OrderConfirmationPage {

    private final WebDriver driver;
    private By locatorToInit = By.xpath("//span[contains(text(), 'Order confirmation')]");
    @FindBy(id = "content")
    private WebElement paymentConfirmationElement;


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
}
