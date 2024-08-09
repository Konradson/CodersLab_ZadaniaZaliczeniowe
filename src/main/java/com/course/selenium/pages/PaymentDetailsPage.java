package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class PaymentDetailsPage {

    private final WebDriver driver;
    private By locatorToInit = By.id("checkout-personal-information-step");
    @FindBy(css = ".h4 .radio-block")
    private WebElement defaultAddressRadioButton;
    @FindBy(xpath = "//button[contains(text(), 'Continue') and @name='confirm-addresses']")
    private WebElement continuePersonalInfoButton;
    @FindBy(css = ".float-xs-left #delivery_option_8")
    private WebElement selfPickUpRadioButton;
    @FindBy(xpath = "//button[contains(text(), 'Continue') and @name='confirmDeliveryOption']")
    private WebElement continueShippingMethodButton;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheckRadioButton;
    @FindBy(xpath = "//input[@class='ps-shown-by-js' and @value='1']")
    private WebElement agreeTermsCheckBox;
    @FindBy(css = "#payment-confirmation .ps-shown-by-js")
    private WebElement placeOrderButton;

    public PaymentDetailsPage(WebDriver driver) {
        //Init driver
        this.driver = driver;
        //PageFactory is need to "@FindBy" functionality was working correctly
        PageFactory.initElements(this.driver, this);
        //Check if page loaded
        waitForPageLoaded(driver, locatorToInit,"controller=order");
    }

    public void chooseAddress(){
        defaultAddressRadioButton.click();
    }

    public void clickContinuePersonalInfoButton(){
        continuePersonalInfoButton.click();
    }

    public void selectShippingMethod(){
        //Click Button if not selected
        if (!selfPickUpRadioButton.isSelected()){
            selfPickUpRadioButton.click();
        }
    }

    public void clickContinueShippingMethodButton(){
        //Click Button
        continueShippingMethodButton.click();
    }

    public void clickPayByCheckRadioButton(){
        //Click RadioButton
        payByCheckRadioButton.click();
    }

    public void clickAgreeTermsCheckBox(){
        //Click "Agree Terms..."
        agreeTermsCheckBox.click();
    }

    public void clickPlaceOrderButton(){
        //Wait for placeOrderButton
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> placeOrderButton.isEnabled());
        //Click placeOrderButton
        placeOrderButton.click();
    }
}
