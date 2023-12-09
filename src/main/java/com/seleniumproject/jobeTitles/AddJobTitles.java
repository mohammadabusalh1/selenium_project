package com.seleniumproject.jobeTitles;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumproject.Base;

public class AddJobTitles extends Base {
    private WebDriver driver;
    By JobTitleField = By.cssSelector("input");
    By SaveButton = By.cssSelector(".sfi_admin_AddFinancier > button");

    public AddJobTitles(WebDriver driver) {
        this.driver = driver;
    }

    public void enterJobTitle(String jobTitle) {
        sendKeys(JobTitleField, jobTitle, driver);
    }

    public void clickSaveButton() {
        click(SaveButton, driver);
    }

    public void replaceInputValue(String newValue) {
        replaceValue(newValue, JobTitleField, driver);
    }

    public LinkedList<String> getActivityTypesFromSheet() throws EncryptedDocumentException, IOException {
        return getTestValues("src\\main\\java\\com\\seleniumproject\\jobeTitles\\testData.xlsx", "jobs");
    }

}
