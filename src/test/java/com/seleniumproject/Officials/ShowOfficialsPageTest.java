package com.seleniumproject.Officials;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.seleniumproject.BaseTest;
import com.seleniumproject.ass.URLs;

public class ShowOfficialsPageTest extends BaseTest {

    @Test(priority = 1)
    public void testChangeFirstInputField() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ShowOfficialsPage showOfficialsPage = new ShowOfficialsPage(driver);
        driver.get(URLs.official);
        wait.until(ExpectedConditions.urlContains(URLs.official));
        showOfficialsPage.changeFirstInputField(0);
        showOfficialsPage.clickChangeFirstInputButton();
        Assert.assertEquals(showOfficialsPage.getFirstInputField(), "1");
        driver.quit();
    }

    @Test(priority = 2)
    public void testSearch() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ShowOfficialsPage showOfficialsPage = new ShowOfficialsPage(driver);
        driver.get(URLs.official);
        wait.until(ExpectedConditions.urlContains(URLs.official));
        showOfficialsPage.enterSearch("a");
        showOfficialsPage.clickSearch();
        Assert.assertEquals(showOfficialsPage.getSearchValue(), "a");
        driver.quit();
    }

    @Test(priority = 3)
    public void testDeleteFirstInput() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ShowOfficialsPage showOfficialsPage = new ShowOfficialsPage(driver);
        driver.get(URLs.official);
        wait.until(ExpectedConditions.urlContains(URLs.official));
        showOfficialsPage.clickDeleteFirstInput();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        try {
            String element = showOfficialsPage.getFirstInputField();
            Assert.assertTrue(true);
        } catch (org.openqa.selenium.NoSuchElementException e) {

            Assert.assertTrue(false);
        }
        driver.quit();
    }
}
