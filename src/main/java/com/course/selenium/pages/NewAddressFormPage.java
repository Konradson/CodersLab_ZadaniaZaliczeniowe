package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class NewAddressFormPage {

    private final WebDriver driver;
    private By locatorToInit = By.cssSelector("#field-alias");

    @FindBy(id = "field-alias")
    WebElement aliasField;
    @FindBy(id = "field-firstname")
    WebElement firstNameField;
    @FindBy(id = "field-lastname")
    WebElement lastNameField;
    @FindBy(id = "field-address1")
    WebElement addressField;
    @FindBy(id = "field-city")
    WebElement cityField;
    @FindBy(id = "field-postcode")
    WebElement zipCodeField;
    @FindBy(id = "field-id_country")
    WebElement countryDropDownButton;
    @FindBy(css = ".form-control-submit")
    WebElement saveButton;

    public NewAddressFormPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(this.driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"address");
    }

    public void fillNewAddressForm(String alias, String first_name, String last_name, String address,  String zip_code,
                                   String city, String country)
    {
        //Use country name with xpath locator and save to string variable
        String xpathCountryFormatedName = String.format("//select[@id='field-id_country']/option[contains(text(), '%s')]", country);

        //Local element of Country dropdown list
        WebElement countryDroppedDownElement;
        //set country dropped down list element
        if (driver.findElement(By.xpath(xpathCountryFormatedName)) != null){
            //Choose entered country (if found)
            countryDroppedDownElement = driver.findElement(By.xpath(xpathCountryFormatedName));
        } else {
            //Choose default country (if entered country is not found)
            countryDroppedDownElement = driver.findElement(By.xpath("//select[@id='field-id_country']/option[@value=17]"));
        }

        //Fill all required new address form fields
        aliasField.clear();
        aliasField.sendKeys(alias);
        firstNameField.clear();
        firstNameField.sendKeys(first_name);
        lastNameField.clear();
        lastNameField.sendKeys(last_name);
        addressField.clear();
        addressField.sendKeys(address);
        zipCodeField.clear();
        zipCodeField.sendKeys(zip_code);
        cityField.clear();
        cityField.sendKeys(city);
        countryDropDownButton.click();
        countryDroppedDownElement.click();
    }

    public void clickSave(){
        //Click create new address button
        saveButton.click();
    }

}
