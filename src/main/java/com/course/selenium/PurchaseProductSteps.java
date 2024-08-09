package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class PurchaseProductSteps {

    WebDriver driver = BrowserFactory.getDriver();
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    CartPage cartPage;
    PaymentDetailsPage paymentDetailsPage;
    OrderConfirmationPage orderConfirmationPage;


    @And("the user types {string} and searches it")
    public void theUserTypesAndSearchesIt(String product) {
        homePage = new HomePage(driver);
        homePage.searchProductInInputField(product);
    }

    @And("the user checks if product is discounted on {string} and clicks on it")
    public void theUserChecksIfProductHasDiscountAndClicksOnIt(String discountedOn) {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkProductDiscount("2", discountedOn);
        searchResultPage.clickOnProduct("2");
    }

    @When("the user chooses product values with {string}, {string}")
    public void theUserChoosesProductValuesWithProduct_countProduct_size(String count, String size){
        productPage = new ProductPage(driver);
        productPage.chooseSize(size);
        productPage.chooseCount(count);
    }

    @And("the user clicks AddToCart and ProceedToCheckout Button")
    public void theUserClicksAddToCartAndProceedToCheckoutButton() {
        productPage = new ProductPage(driver);
        productPage.addToCartAndProceed();
        cartPage = new CartPage(driver);
        cartPage.clickProceedToCheckout();
    }

    @And("the user makes payment")
    public void theUserMakesPayment() {
        paymentDetailsPage = new PaymentDetailsPage(driver);
        paymentDetailsPage.chooseAddress();
        paymentDetailsPage.clickContinuePersonalInfoButton();
        paymentDetailsPage.selectShippingMethod();
        paymentDetailsPage.clickContinueShippingMethodButton();
        paymentDetailsPage.clickPayByCheckRadioButton();
        paymentDetailsPage.clickAgreeTermsCheckBox();
        paymentDetailsPage.clickPlaceOrderButton();
    }

    @Then("the user makes a screenshot of made purchase")
    public void theUserMakesAScreenshotOfMadePurchase() {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.takeScreenShot();
    }
}