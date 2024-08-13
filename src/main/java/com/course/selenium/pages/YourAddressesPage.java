package com.course.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class YourAddressesPage {

    private final WebDriver driver;
    private By locatorToInit = By.xpath("//h1[contains(text(), 'Your addresses')]");

    @FindBy(xpath =  "//a[@data-link-action='add-address']")
    private WebElement createNewAddressButton;

    public YourAddressesPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"addresses");
    }

    public void clickOnNewAddressButton(){
        createNewAddressButton.click();
    }

    public void findMyAddress(String alias){
        //Use title with xpath locator and save to string variable
        String myAddressTitleXpath = String.format("//div[@class='address-body']/h4[contains(text(), '%s')]", alias);
        //Address element with entered title
        WebElement addressElement = driver.findElement(By.xpath(myAddressTitleXpath));
        //Print Error if there is no address found
        Assert.assertEquals("There is no address with this title!", addressElement.getText(), alias);
    }

    public void deleteAddress(String alias){

        //Find and save Address by xpath
        String myAddressTitleXpath = String.format(".//div[@class='address-body']/h4[(text()= '%s')]", alias);
        //Find all addresses
        List<WebElement> allAddresses = driver.findElements(By.cssSelector(".col-sm-6"));

        //Check all addresses and find the one with desired title (and delete it)
        for (WebElement addressElement : allAddresses){

            //If desired title
            if (addressElement.findElement(By.xpath(".//div[@class='address-body']/h4")).getText().equals(alias)) {
                //Save deleteButton of address to variable
                WebElement deleteAddressButton = addressElement.findElement(By.xpath(".//a[@data-link-action='delete-address']"));
                //Click deleteButton
                deleteAddressButton.click();
                //Get out from loop
                break;
            }

        }

        //Check if Address deleted
        WebElement successAlertElement = driver.findElement(By.xpath("//*[contains(text(), 'Address successfully deleted!')]"));
        Assert.assertNotNull("Address deletion failed!", successAlertElement);

    }

}
