package com.seleniumproject.jobeTitles;

import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumproject.BaseTest;
import com.seleniumproject.ass.URLs;

public class addJobTitlesTest extends BaseTest {

    @Test(invocationCount = 1)
    public void testAddTobTitle() throws InterruptedException, EncryptedDocumentException, IOException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        AddJobTitles addJobTitlesPage = new AddJobTitles(driver);
        driver.get(URLs.addJobTitles);
        wait.until(ExpectedConditions.urlContains(URLs.addJobTitles));
        boolean result = true;
        LinkedList<String> list = addJobTitlesPage.getActivityTypesFromSheet();
        for (int i = 0; i < list.size(); i++) {
            addJobTitlesPage.replaceInputValue(list.get(i));
            addJobTitlesPage.clickSaveButton();
            WebElement element = null;
            try {
                element = driver.findElement(By.cssSelector(".errors"));
            } catch (org.openqa.selenium.NoSuchElementException e) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
        driver.quit();
    }
}
