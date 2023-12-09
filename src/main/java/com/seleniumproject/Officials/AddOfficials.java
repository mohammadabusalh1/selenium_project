package com.seleniumproject.Officials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.seleniumproject.Base;

public class AddOfficials extends Base {
    private WebDriver driver;
    By UserSelect = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div[2]/div/div[1]/select");
    By JobTitleSelect = By.xpath("//*[@id=\"root\"]/div/main/div[1]/div[2]/div/div[2]/select");
    By SaveButton = By.xpath("//*[@id=\"root\"]/div/main/div[1]/button");

    public AddOfficials(WebDriver driver) {
        this.driver = driver;
    }

    public void selectUser(int user) {
        select(UserSelect, user, driver);
    }

    public void selectJobTitle(int jobTitle) {
        select(JobTitleSelect, jobTitle, driver);
    }

    public void clickSaveButton() {
        click(SaveButton, driver);
    }

}
