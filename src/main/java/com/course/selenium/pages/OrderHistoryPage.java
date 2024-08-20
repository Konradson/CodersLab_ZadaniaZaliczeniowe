package com.course.selenium.pages;

import com.course.selenium.helpers.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class OrderHistoryPage {

    private final WebDriver driver;
    private By locatorToInit = By.xpath("//span[contains(text(), 'Order history')]");
    private List<WebElement> paymentInfoRows;

    public OrderHistoryPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(this.driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"controller=history");
    }

    public WebElement findPaymentInfoRow(String orderRef){
        //Create new list of paymentInfoRows WebElements
        paymentInfoRows = driver.findElements(By.xpath("//tbody/tr"));

        //Row to return
        WebElement wantedRow = null;

        //Find desired row from paymentInfoRows list
        for (WebElement row : paymentInfoRows) {
            //If OrderReference is equal to desired string value (orderRef) then return this row (as WebElement)
            if (row.findElement(By.xpath(".//th[@scope='row']")).getText().equals(orderRef)){
                wantedRow = row;
                break;
            }
        }

        return wantedRow;
    }

    public boolean checkIfPaymentIsAwaiting(WebElement paymentInfoRow, String paymentStatus){
        //Save order reference text to String
        String orderRefText = paymentInfoRow.findElement(By.xpath(".//td/span")).getText();
        //Return if "Awaiting check payment" status is displayed
        return orderRefText.contains(paymentStatus);
    }

    public boolean checkIfPaymentPriceEqualsTo(WebElement paymentInfoRow, String paymentPrice){
        //Save payment price (with currency) to String
        String paymentInfoPrice = paymentInfoRow.findElement(By.xpath(".//td[@class='text-xs-right']")).getText();
        //Return if price of paymentInfoRow element is equal to desired price (with currency) - e.g. "€19.12"
        return paymentInfoPrice.contains(paymentPrice);
    }
}
