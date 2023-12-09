package com.seleniumproject.Officials;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumproject.BaseTest;
import com.seleniumproject.LoginPage;
import com.seleniumproject.ass.URLs;
import com.seleniumproject.ass.Variables;

public class addOfficialsTest extends BaseTest {

    @Test(invocationCount = 2)
    public void addOfficial() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        AddOfficials addOfficialPage = new AddOfficials(driver);
        driver.get(URLs.addOfficial);
        wait.until(ExpectedConditions.urlContains(URLs.addOfficial));
        addOfficialPage.selectUser(1);
        addOfficialPage.selectJobTitle(1);
        addOfficialPage.clickSaveButton();
        WebElement element = null;
        try {
            element = driver.findElement(By.cssSelector(".errors"));
            Assert.assertTrue(true);
        } catch (org.openqa.selenium.NoSuchElementException e) {

            Assert.assertTrue(false);
        }
        driver.quit();
    }
}
