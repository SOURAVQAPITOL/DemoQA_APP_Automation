package com.qapitol.base;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;
    public static Actions actions;


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
        JavascriptExecutor script = (JavascriptExecutor) driver;
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

    public void moveToElementAndEnterTheValue(WebElement ele,String characters) {
        actions = new Actions(driver);
        actions.moveToElement(ele).sendKeys(characters).build().perform();
    }

    public void selectTheDropDownByValue(WebElement ele, String value){
        Select sc = new Select(ele);
        sc.selectByValue(value);
    }
}
