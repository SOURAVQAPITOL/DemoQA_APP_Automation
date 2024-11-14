package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SeleniumGrid extends BaseTest {

    public static void main(String[] args) {
        String hubURL = "http://192.168.3.89:7777";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WIN11);
        caps.setBrowserName("chrome");

        try {
            WebDriver driver = new RemoteWebDriver(new URL(hubURL), caps);

            driver.get("https://google.com");
            Thread.sleep(5000);
            System.out.println("Page Title is: " + driver.getTitle());

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
