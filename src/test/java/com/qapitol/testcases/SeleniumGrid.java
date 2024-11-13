package com.qapitol.testcases;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SeleniumGrid {

    public static void main(String[] args) {
        String hubURL = " http://192.168.2.116:4444";

        Capabilities capabilities = new ChromeOptions();

        try {
            WebDriver driver = new RemoteWebDriver(new URL(hubURL), capabilities);

            driver.get("https://www.google.com");
            Thread.sleep(5000);
            System.out.println("Page Title is: " + driver.getTitle());

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
