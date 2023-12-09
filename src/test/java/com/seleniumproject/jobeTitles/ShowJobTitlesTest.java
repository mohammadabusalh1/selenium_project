package com.seleniumproject.jobeTitles;

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

public class ShowJobTitlesTest extends BaseTest {

    @Test(priority = 1)
    public void testChangeFirstInputField() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ShowJobTitles jobTitles = new ShowJobTitles(driver);
        driver.get(URLs.showJobTitles);
        wait.until(ExpectedConditions.urlContains(URLs.showJobTitles));
        jobTitles.changeFirstInputField("a2");
        jobTitles.clickChangeFirstInputButton();
        Assert.assertTrue(jobTitles.getFirstInputField().contains("a2"));
        driver.quit();
    }

    @Test(priority = 2)
    public void testSearch() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ShowJobTitles jobTitles = new ShowJobTitles(driver);
        driver.get(URLs.showJobTitles);
        wait.until(ExpectedConditions.urlContains(URLs.showJobTitles));
        jobTitles.enterSearch("a2");
        jobTitles.clickSearch();
        Assert.assertTrue(jobTitles.getFirstInputField().contains("a2"));
        driver.quit();
    }

    @Test(priority = 3)
    public void testDeleteFirstInput() throws InterruptedException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        ShowJobTitles jobTitles = new ShowJobTitles(driver);
        driver.get(URLs.showJobTitles);
        wait.until(ExpectedConditions.urlContains(URLs.showJobTitles));
        jobTitles.clickDeleteFirstInput();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        try {
            String element = jobTitles.getFirstInputField();
            Assert.assertTrue(true);
        } catch (org.openqa.selenium.NoSuchElementException e) {

            Assert.assertTrue(false);
        }
        driver.quit();
    }

}
