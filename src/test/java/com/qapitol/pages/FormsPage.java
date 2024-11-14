package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormsPage extends BaseTest {


    public void navigateToPracticeForm() {
        waitUntilTheElementAppear(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[2]"));
        scrollTillTheElementToVisible(locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[2]")));
        locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[2]")).click();
        waitUntilTheElementAppear(By.xpath("//span[text()='Practice Form']"));
        locateElement(By.xpath("//span[text()='Practice Form']")).click();
    }

    public void studentRegistration() {
        waitUntilTheElementAppear(By.id("firstName"));
        scrollTillTheElementToVisible(locateElement((By.id("firstName"))));
        locateElement(By.id("firstName")).sendKeys("dd");
        locateElement(By.id("lastName")).sendKeys("tnrsgbfs");
        locateElement(By.id("userEmail")).sendKeys("rngbfsdv");
        chooseTheGender("Male");
        locateElement(By.id("userNumber")).sendKeys("978654");
    }

    public void chooseTheGender(String GenderName) {
        List<WebElement> genders = driver.findElements(By.xpath("//div[text()='Gender']/..//input[@type='radio']"));
        for (WebElement gender : genders) {

            if (gender.getAttribute("value").equalsIgnoreCase(GenderName)) {
                gender.submit();
            }
        }
    }
}
