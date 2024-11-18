package com.qapitol.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;
    public static Actions actions;
    JavascriptExecutor script;

    public static void initialize() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//resources//config//application.properties");
        prop.load(fis);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
        driver.manage().deleteAllCookies();
    }

    public static void QuitTheDriver() {
        driver.quit();
    }

    public boolean isElementPresent(String locators) {
        return driver.findElement(By.xpath(locators)).isDisplayed();
    }

    public void scrollTillTheElementToVisible(WebElement element) {
        script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public WebElement locateElement(By by) {
        return driver.findElement(by);
    }

    public void waitUntilTheElementAppear(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void doubleClick(WebElement ele) {
        Actions actions = new Actions(driver);
        locateElement(By.id("doubleClickBtn"));
        actions.moveToElement(ele).doubleClick().build().perform();
    }

    public static void getBackToPreviousPage() {
        driver.navigate().back();
    }

    public void dragAnddROP(WebElement src, WebElement targ) {
        actions = new Actions(driver);
        actions.dragAndDrop(src, targ).build().perform();
    }

    public void moveToElementAndEnterTheValue(WebElement ele, String characters) {
        actions = new Actions(driver);
        actions.moveToElement(ele).sendKeys(characters).build().perform();
    }

    public void selectTheDropDownByValue(WebElement ele, String value) {
        Select sc = new Select(ele);
        sc.selectByValue(value);
    }

    public void moveToElementByOffSet(WebElement ele, int x, int y) {
        actions = new Actions(driver);
        actions.clickAndHold(ele).moveByOffset(x, y).release().build().perform();
    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, destFile);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

    public void scrollThePages() {
        script = (JavascriptExecutor) driver;
        script.executeScript("window.scrollBy(0,350)", "");
    }

    public void moveToElement(WebElement ele) {
        actions = new Actions(driver);
        actions.moveToElement(ele).build().perform();
    }
}
