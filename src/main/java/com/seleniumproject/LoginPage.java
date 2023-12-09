package com.seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {
    private WebDriver driver;
    private By usernameField = By.name("Username");
    private By passwordField = By.name("Password");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[4]/button");
    private By changeLanguage = By.xpath("//*[@id=\"root\"]/div/main/div/button");
    private By title = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[1]/h1[1]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        sendKeys(usernameField, username, driver);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password, driver);
    }

    public void clickChangeLanguage() {
        click(changeLanguage, driver);
    }

    public void clickLogin() {
        click(loginButton, driver);
    }

    public String getTitle() {
        return getText(title, driver);
    }

    public void replaceUsernameValue(String newValue) {
        replaceValue(newValue, usernameField, driver);
    }

    public void replacePasswordValue(String newValue) {
        replaceValue(newValue, passwordField, driver);
    }

}
