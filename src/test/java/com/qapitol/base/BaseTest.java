package com.qapitol.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;


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

    public void getBackToPreviousPage(){
        driver.navigate().back();
    }
}
