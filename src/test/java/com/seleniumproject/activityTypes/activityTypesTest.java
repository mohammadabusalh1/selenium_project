package com.seleniumproject.activityTypes;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumproject.BaseTest;
import com.seleniumproject.ass.URLs;

public class activityTypesTest extends BaseTest {

    @Test(priority = 1)
    public void testChangeFirstInputField() {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        ActivityTypes activityTypes = new ActivityTypes(driver);
        wait.until(ExpectedConditions.urlContains(URLs.home));
        driver.get(URLs.showActivityType);
        wait.until(ExpectedConditions.urlContains(URLs.showActivityType));
        activityTypes.changeFirstInputField("a2");
        activityTypes.clickChangeFirstInputButton();
        wait.until(ExpectedConditions.elementToBeClickable(activityTypes.editFirstInputButton));
        Assert.assertTrue(activityTypes.getFirstInputField().contains("a2"));
        driver.quit();
    }

    @Test(priority = 2)
    public void testSearch() {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ActivityTypes activityTypes = new ActivityTypes(driver);
        driver.get(URLs.showActivityType);
        wait.until(ExpectedConditions.urlContains(URLs.showActivityType));
        activityTypes.enterSearch("a2");
        activityTypes.clickSearch();
        Assert.assertTrue(activityTypes.getFirstInputField().contains("a2"));
        driver.quit();
    }

    @Test(priority = 3)
    public void testDeleteFirstInput() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ActivityTypes activityTypes = new ActivityTypes(driver);
        driver.get(URLs.showActivityType);
        wait.until(ExpectedConditions.urlContains(URLs.showActivityType));
        activityTypes.clickDeleteFirstInput();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
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
