package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CreateNewAddressSteps {

    WebDriver driver = BrowserFactory.getDriver();
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    NewAddressFormPage newAddressPage;
    YourAddressesPage yourAddressesPage;

    @Given("a logged in user is on the home page")
    public void aLoggedInUserIsOnTheHomePage() {
        homePage = new HomePage(driver);
        homePage.clickSingInButton();
        loginPage = new LoginPage(driver);
        loginPage.loginAs("kkkggg@kg.com", "kgkgkgkg");
    }

    @And("the user clicks on Addresses button from the footer")
    public void theUserClicksOnAddressesButtonFromTheFooter() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnAddresses();
    }

    @When("the user clicks Create new address button")
    public void theUserClicksCreateNewAddressButton() {
        yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.clickOnNewAddressButton();
    }

    @And("the user fills the address form with {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFillsTheAddressFormWith(String alias, String firstName, String lastName, String address, String zipCode,
                                               String city, String country) {
        newAddressPage = new NewAddressFormPage(driver);
        newAddressPage.fillNewAddressForm(alias, firstName, lastName, address, zipCode, city, country);
    }

    @And("the user clicks the Save button")
    public void theUserClicksTheSaveButton() {
        newAddressPage = new NewAddressFormPage(driver);
        newAddressPage.clickSave();
    }

    @Then("my addresses page should include the new address titled {string}")
    public void myAddressesPageShouldIncludeTheNewAddressTitled(String alias) {
        yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.findMyAddress(alias);
    }
}
