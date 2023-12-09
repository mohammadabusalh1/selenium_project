package com.seleniumproject.activityTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumproject.Base;

public class ActivityTypes extends Base {
    private WebDriver driver;
    private By searchField = By.cssSelector("input");
    private By firstInputField = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div[2]/table/tbody/tr[1]/td[1]/input");
    By editFirstInputButton = By
            .xpath("//*[@id=\"root\"]/div/main/div[1]/div[2]/table/tbody/tr[1]/td[2]/button");
    private By deleteFirstInput = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div[2]/table/tbody/tr[1]/td[3]/button");
    private By searchButton = By.cssSelector(".searchIcon");
    private By AddButton = By.xpath("//*[@id=\"root\"]/div/main/a/button/svg");

    public ActivityTypes(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearch(String search) {
        sendKeys(searchField, search, driver);
    }

    public void clickSearch() {
        click(searchButton, driver);
    }

    public void clickAddButton() {
        click(AddButton, driver);
    }

    public void changeFirstInputField(String newValue) {
        sendKeys(firstInputField, newValue, driver);
    }

    public void clickChangeFirstInputButton() {
        click(editFirstInputButton, driver);
    }

    public void clickDeleteFirstInput() {
        click(deleteFirstInput, driver);
    }

    public String getFirstInputField() {
        return getValue(firstInputField, driver);
    }

    public String getSearchValue() {
        return getValue(searchField, driver);
    }
}
