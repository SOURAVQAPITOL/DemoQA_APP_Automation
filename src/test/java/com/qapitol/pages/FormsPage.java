package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class FormsPage extends BaseTest {

    public FormsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='category-cards']//*[name()='svg'])[2]")
    WebElement practiceFormTab;

    @FindBy(xpath = "//span[text()='Practice Form']")
    WebElement practiceFormLink;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastElement;

    @FindBy(id = "userNumber")
    WebElement mobileNumber;

    public void navigateToPracticeForm() {
        waitUntilTheElementAppear(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[2]"));
        scrollTillTheElementToVisible(practiceFormTab);
        practiceFormTab.click();
        waitUntilTheElementAppear(By.xpath("//span[text()='Practice Form']"));
        practiceFormLink.click();
    }

    public void studentRegistration() throws InterruptedException {
        waitUntilTheElementAppear(By.id("firstName"));
        scrollTillTheElementToVisible(firstName);
        Thread.sleep(3000);
        firstName.sendKeys("dd");
        Thread.sleep(3000);
        lastElement.sendKeys("tnrsgbfs");
        Thread.sleep(3000);
        lastElement.sendKeys("rngbfsdv");
        Thread.sleep(3000);
//        chooseTheGender("Male");
//        Thread.sleep(3000);
        mobileNumber.sendKeys("978654");
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

    public void selectDateOfBirth() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

}
