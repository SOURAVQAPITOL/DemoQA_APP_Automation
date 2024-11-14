package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BaseTest {

    public boolean homeLogo() {
        isElementPresent("//img[@src='/images/Toolsqa.jpg']");
        return false;
    }

    public void isHomeURLPresent() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/", "Failed");
    }

    public void navigateToTheElementsPage() {
        scrollTillTheElementToVisible(locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[1]")));
        locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[1]")).click();
    }
}
