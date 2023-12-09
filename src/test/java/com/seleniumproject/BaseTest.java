package com.seleniumproject;

import org.openqa.selenium.WebDriver;
import com.seleniumproject.ass.URLs;
import com.seleniumproject.ass.Variables;

public class BaseTest {

    public static WebDriver getDriver() {
        return WebDriverFactory.getDriver(Variables.driver);
    }

    public WebDriver login() {
        WebDriver driver = getDriver();
        LoginPage login = new LoginPage(driver);
        driver.get(URLs.login);
        login.enterUsername(Variables.username);
        login.enterPassword(Variables.password);
        login.clickLogin();
        return driver;
    }
}
