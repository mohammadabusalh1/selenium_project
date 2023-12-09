package com.seleniumproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Base {

    public void click(By locator, WebDriver driver) {
        driver.findElement(locator).click();
    }

    public void sendKeys(
            By locator,
            String value, WebDriver driver) {
        driver.findElement(locator).sendKeys(value);
    }

    public void select(
            By locator,
            int index, WebDriver driver) {

        WebElement element = driver.findElement(locator);
        Select drpCountry = new Select(element);
        drpCountry.selectByIndex(index);
    }

    public String getText(
            By locator, WebDriver driver) {

        return driver.findElement(locator).getText();
    }

    public String getValue(
            By locator, WebDriver driver) {

        return driver.findElement(locator).getAttribute("value");
    }

    public void replaceValue(String newValue, By locator, WebDriver driver) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(newValue);
    }

    public LinkedList<String> getTestValues(String fileName, String sheetName)
            throws EncryptedDocumentException, IOException {
        LinkedList<String> list = new LinkedList<>();
        FileInputStream fis = new FileInputStream(fileName);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);

        for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                list.add(cell.getStringCellValue());
            }
        }

        wb.close();
        return list;
    }

}
