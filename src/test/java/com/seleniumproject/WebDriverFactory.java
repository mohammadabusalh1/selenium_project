package com.seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String type) {

        WebDriver driver = null;

        if (type.equals("chrome")) {
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "src\\drivers\\chromedriver.exe");
        } else if (type.equals("edge")) {
            System.setProperty("webdriver.edge.verboseLogging", "src\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (type.equals("firefox")) {
            driver = new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", "src\\drivers\\geckodriver.exe");
        }

        driver.manage().window().maximize();

        return driver;

    }

}
