package com.course.selenium.helpers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static final String URL = "https://mystore-testlab.coderslab.pl/";
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static String orderReference = "XYZ";
    private static String orderPrice = "€0.0";

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    //ORDER REFERENCE getters and setters
    public static String getOrderReference(){
        return orderReference;
    }

    public static void setOrderReference(String newString){
        orderReference = newString;
    }

    //ORDER PRICE getters and setters
    public static String getOrderPrice(){
        return orderPrice;
    }

    public static void setOrderPrice(String newString){
        orderPrice = newString;
    }

    @Before
    public void setUp(){
        driverThreadLocal.set(new FirefoxDriver());
        WebDriver driver = driverThreadLocal.get();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @After
    public void tearDown(){
        if(driverThreadLocal.get() != null){
            driverThreadLocal.get().quit();
        }

    }
}
