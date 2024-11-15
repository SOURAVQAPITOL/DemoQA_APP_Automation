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

    public void studentRegistration() throws InterruptedException {
        waitUntilTheElementAppear(By.id("firstName"));
        scrollTillTheElementToVisible(locateElement((By.id("firstName"))));
        Thread.sleep(3000);
        locateElement(By.id("firstName")).sendKeys("dd");
        Thread.sleep(3000);
        locateElement(By.id("lastName")).sendKeys("tnrsgbfs");
        Thread.sleep(3000);
        locateElement(By.id("userEmail")).sendKeys("rngbfsdv");
        Thread.sleep(3000);
//        chooseTheGender("Male");
//        Thread.sleep(3000);
        locateElement(By.id("userNumber")).sendKeys("978654");
        Thread.sleep(3000);
    }

    public void chooseTheGender(String GenderName) {
        switch (GenderName) {
            case "Male":
                locateElement(By.xpath("//label[@for='gender-radio-1']")).click();
                break;
            case "Female":
                locateElement(By.xpath("//label[@for='gender-radio-2']")).click();
                break;
            case "Others":
                locateElement(By.xpath("//label[@for='gender-radio-3']")).click();
                break;
            default:
                System.out.println("This is the invalid gender");
                break;
        }
    }

    //TODO - Element is not interactable - Do not use this code
//    public void chooseHobbies(String value){
//        List<WebElement> hobbies = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        for (WebElement hobby : hobbies){
//            if (hobby.getAttribute("value").equalsIgnoreCase(value))
//            {
//                hobby.click();
//            }
//        }
//    }

    public void chooseHobbies(String hobbies) {
        switch (hobbies) {
            case "Sports":
                locateElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
                break;
            case "Reading":
                locateElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
                break;
            case "Music":
                locateElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
                break;
            default:
                System.out.println("This is the invalid gender");
                break;
        }
    }

    public void chooseCity(String cityName) {
        List<WebElement> cities = driver.findElements(By.cssSelector(".css-yt9ioa-option"));
        for (WebElement city : cities) {
            if (city.getText().equalsIgnoreCase(cityName)) {
                city.click();
            }
        }
    }
}
