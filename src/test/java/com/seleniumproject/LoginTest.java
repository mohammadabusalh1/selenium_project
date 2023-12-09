package com.seleniumproject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumproject.ass.URLs;
import com.seleniumproject.ass.Variables;

public class LoginTest extends BaseTest {

    @Test
    public void testChangeLanguage() {
        WebDriver driver = getDriver();
        LoginPage login = new LoginPage(driver);
        driver.get(URLs.login);
        login.clickChangeLanguage();
        Assert.assertTrue(login.getTitle().equals("Hello"));
        driver.quit();
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
        WebDriver driver = getDriver();
        LoginPage login = new LoginPage(driver);
        driver.get(URLs.login);
        login.enterUsername("sdi");
        login.enterPassword("assad");
        login.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), URLs.login);
        driver.quit();
    }

    @Test
    public void testLogin() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        LoginPage login = new LoginPage(driver);
        driver.get(URLs.login);
        wait.until(ExpectedConditions.urlContains(URLs.login));
        login.replaceUsernameValue(Variables.username);
        login.replacePasswordValue(Variables.password);
        login.clickLogin();
        wait.until(ExpectedConditions.urlContains(URLs.home));
        Assert.assertEquals(driver.getCurrentUrl(), URLs.home);
        driver.quit();
    }

    @Test
    public void testLogout() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        LoginPage login = new LoginPage(driver);
        driver.get(URLs.login);
        wait.until(ExpectedConditions.urlContains(URLs.login));
        login.replaceUsernameValue(Variables.username);
        login.replacePasswordValue(Variables.password);
        login.clickLogin();
        wait.until(ExpectedConditions.urlContains(URLs.home));
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"navbarColor02\"]/div/button[2]"));
        logoutButton.click();
        wait.until(ExpectedConditions.urlContains(URLs.login));
        Assert.assertEquals(driver.getCurrentUrl(), URLs.login);
        driver.quit();
    }
}