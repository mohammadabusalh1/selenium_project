package com.seleniumproject.activityTypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumproject.BaseTest;
import com.seleniumproject.ass.URLs;

public class addActivityTypesTest extends BaseTest {

    @Test(invocationCount = 1)
    public void addActivityType() throws InterruptedException, EncryptedDocumentException, IOException {
        WebDriver driver = login();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains(URLs.home));
        AddActivityTypes addActivityTypes = new AddActivityTypes(driver);
        driver.get(URLs.addActivityType);
        wait.until(ExpectedConditions.urlContains(URLs.addActivityType));
        boolean result = true;
        LinkedList<String> list = addActivityTypes.getActivityTypesFromSheet();
        for (int i = 0; i < list.size(); i++) {
            addActivityTypes.replaceInputValue(list.get(i));
            addActivityTypes.clickSaveButton();
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
