package com.course.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Helpers {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static void waitForElementVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(element));

    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForPageLoaded(WebDriver driver, By locator, String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.ignoring(StaleElementReferenceException.class)
                .until(
                        and(
                                visibilityOfElementLocated(locator)
                                ,urlContains(url)
                        )
                );
    }

    public static String getRandomEmail() {
        return String.format("john_%d@gmail.com", System.currentTimeMillis());
    }

    public static  void selectRadioButtonByText(WebDriver driver , By locatorRadioLabel ,String text) {
        List<WebElement> listLabelRadioButtons = driver.findElements(locatorRadioLabel);
        for (WebElement element : listLabelRadioButtons) {
            if (element.getText().contains(text)) {
                WebElement radioButton = element.findElement(By.cssSelector("input"));
                radioButton.click();

            }
        }
    }

    public static String today() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DATE_FORMATTER);
    }

    public static String nextWeek() {
        LocalDate nextWeek = LocalDate.now().plusDays(7);
        return nextWeek.format(DATE_FORMATTER);
    }
}
