package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WidgetsPage extends BaseTest {

    public void navigateToWidgets() {
        waitUntilTheElementAppear(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[4]"));
        scrollTillTheElementToVisible(locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[4]")));
        locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[4]")).click();
    }

    public void navigateToAccordian() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Accordian']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[text()='Accordian']")));
        locateElement(By.xpath("//span[text()='Accordian']")).click();
    }

    public void getToTheSecondAccordian() {
        locateElement(By.id("section1Heading")).click();
        scrollTillTheElementToVisible(locateElement(By.id("section2Heading")));
        locateElement(By.id("section2Heading")).click();
    }

    public void navigateToAutoComplete() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Auto Complete']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[text()='Auto Complete']")));
        locateElement(By.xpath("//span[text()='Auto Complete']")).click();
    }

    public void typeMultipleColorNames() throws InterruptedException {
        scrollTillTheElementToVisible(locateElement(By.xpath("//h1[text()='Auto Complete']")));
        Thread.sleep(2000);
        locateElement(By.cssSelector(".auto-complete__value-container--is-multi.css-1hwfws3")).click();
        Thread.sleep(3000);
        moveToElementAndEnterTheValue(locateElement(By.cssSelector(".auto-complete__value-container--is-multi.css-1hwfws3")),"a");
        waitUntilTheElementAppear(By.xpath("//div[text()='Black']"));
        locateElement(By.xpath("//div[text()='Black']")).click();
        moveToElementAndEnterTheValue(locateElement(By.cssSelector(".auto-complete__value-container--is-multi.css-1hwfws3")),"a");
        waitUntilTheElementAppear(By.xpath("//div[text()='Magenta']"));
        locateElement(By.xpath("//div[text()='Magenta']")).click();
        moveToElementAndEnterTheValue(locateElement(By.cssSelector(".auto-complete__value-container--is-multi.css-1hwfws3")),"a");
        locateElement(By.xpath("//div[text()='Aqua']")).click();
        locateElement(By.xpath("//div[text()='Aqua']")).click();

    }

    public void typeSingleColorName() throws InterruptedException {
        waitUntilTheElementAppear(By.xpath("//h1[text()='Auto Complete']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//h1[text()='Auto Complete']")));
        Thread.sleep(2000);
        locateElement(By.xpath("(//div[@class='auto-complete__value-container css-1hwfws3'])[1]")).click();
        Thread.sleep(3000);
        moveToElementAndEnterTheValue(locateElement(By.xpath("(//div[@class='auto-complete__value-container css-1hwfws3'])[1]")),"a");
        waitUntilTheElementAppear(By.xpath("//div[text()='Black']"));
        locateElement(By.xpath("//div[text()='Black']")).click();
    }

    public void navigateToDatePicker() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Date Picker']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[text()='Date Picker']")));
        locateElement(By.xpath("//span[text()='Date Picker']")).click();
    }

    public void selectDate() throws InterruptedException {
        waitUntilTheElementAppear(By.id("datePickerMonthYearInput"));
        scrollTillTheElementToVisible(locateElement(By.id("datePickerMonthYearInput")));
        locateElement(By.id("datePickerMonthYearInput")).click();
        WebElement monthDropDown = locateElement(By.className("react-datepicker__month-select"));
        selectTheDropDownByValue(monthDropDown,"0");
        WebElement yearDropDown = locateElement(By.className("react-datepicker__year-select"));
        selectTheDropDownByValue(yearDropDown,"1999");
        Thread.sleep(2000);
        locateElement(By.xpath("//div[text()='2' and @aria-label='Choose Saturday, January 2nd, 1999' ]")).click();
    }

    public void navigateToSlider() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Slider']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[text()='Slider']")));
        locateElement(By.xpath("//span[text()='Slider']")).click();
    }

    public void sliderTest() throws InterruptedException {
        Thread.sleep(2000);
        WebElement sliderButton = locateElement(By.xpath("//input[@type='range']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//input[@type='range']")));
        moveToElementByOffSet(sliderButton,60,0);
        Thread.sleep(3000);
    }

    public String verifyTheSliderText(){
        return locateElement(By.id("sliderValue")).getAttribute("value");
    }
}