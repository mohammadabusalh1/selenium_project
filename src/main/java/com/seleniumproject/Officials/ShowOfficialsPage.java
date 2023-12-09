package com.seleniumproject.Officials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumproject.Base;

public class ShowOfficialsPage extends Base {
    private WebDriver driver;
    private By searchField = By.cssSelector("input");
    private By firstInputField = By.cssSelector("select");
    private By changeFirstButton = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div[2]/table/tbody/tr[1]/td[4]/button");
    private By deleteFirstInput = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div[2]/table/tbody/tr[1]/td[5]/button");
    private By searchButton = By.xpath("//*[@id=\"search\"]");
    private By AddButton = By.xpath("//*[@id=\"root\"]/div/main/a/button/svg");

    public ShowOfficialsPage(WebDriver driver) {
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

    public void changeFirstInputField(int newValue) {
        select(firstInputField, newValue, driver);
    }

    public void clickChangeFirstInputButton() {
        click(changeFirstButton, driver);
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
