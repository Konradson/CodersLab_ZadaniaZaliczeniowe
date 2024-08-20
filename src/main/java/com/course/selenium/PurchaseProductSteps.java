package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseProductSteps {

    WebDriver driver = BrowserFactory.getDriver();
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    CartPage cartPage;
    PaymentDetailsPage paymentDetailsPage;
    OrderConfirmationPage orderConfirmationPage;
    MyAccountPage myAccountPage;
    OrderHistoryPage orderHistoryPage;


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
        orderConfirmationPage.saveOrderReference();
    }

    @And("payment is on the list with status {string} and correct price")
    public void paymentIsOnTheListWithStatusAwaitingCheckPaymentAndCorrectPrice(String statusToCheck) {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.clickOnLoginIcon();
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnHistory();

        orderHistoryPage = new OrderHistoryPage(driver);
        //Get OrderReference Element (row)
        WebElement lastPaymentInfoRow = orderHistoryPage.findPaymentInfoRow(BrowserFactory.getOrderReference());

        //Check if paymentInfo Status is equal to desired Status
        boolean paymentAwaitingBool = orderHistoryPage.checkIfPaymentIsAwaiting(lastPaymentInfoRow, statusToCheck);
        //Assert message if there is different status
        Assert.assertTrue("Payment has a different status than - " + statusToCheck,paymentAwaitingBool);

        //Check if Price of paymentInfoRow Element is correct
        String priceToCheck = BrowserFactory.getOrderPrice();
        boolean priceCorrect = orderHistoryPage.checkIfPaymentPriceEqualsTo(lastPaymentInfoRow, priceToCheck);
        //Assert message if price is correct
        Assert.assertTrue("There are different prices in the payment info row and real price of the order!",
                priceCorrect);
    }
}