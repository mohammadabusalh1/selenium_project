package com.seleniumproject.activityTypes;

import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumproject.Base;

public class AddActivityTypes extends Base {
    private WebDriver driver;
    By InputField = By.cssSelector("input");
    By SaveButton = By.cssSelector(".sfi_admin_AddFinancier > button");

    public AddActivityTypes(WebDriver driver) {
        this.driver = driver;
    }

    public void enter(String jobTitle) {
        sendKeys(InputField, jobTitle, driver);
    }

    public void clickSaveButton() {
        click(SaveButton, driver);
    }

    public void replaceInputValue(String newValue) {
        replaceValue(newValue, InputField, driver);
    }

    public LinkedList<String> getActivityTypesFromSheet() throws EncryptedDocumentException, IOException {
        return getTestValues("src\\main\\java\\com\\seleniumproject\\activityTypes\\testData.xlsx", "activityType");
    }

}
