package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import com.qapitol.util.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;


public class ElementsPage extends BaseTest {

    public ElementsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//button[@title='Toggle']")
    WebElement toggleButton;

    public void navigateToTextBox() {
        locateElement(By.xpath("//span[text()='Text Box']")).click();
    }

    public void enterValueInTheField() {
        userName.click();
        userName.sendKeys(TestData.USER_NAME);
        userEmail.click();
        userEmail.sendKeys(TestData.USER_EMAIL);
        waitUntilTheElementAppear(By.id("currentAddress"));
        scrollTillTheElementToVisible(currentAddress);
        currentAddress.click();
        currentAddress.sendKeys(TestData.CURRENT_ADDRESS);
    }

    public void clickOnSubmitButton() {
        scrollTillTheElementToVisible(submitButton);
        waitUntilTheElementAppear(By.id("submit"));
        submitButton.click();
    }

    public void navigateTOCheckBox() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Check Box']")));
        locateElement(By.xpath("//span[normalize-space()='Check Box']")).click();
    }

    public void clickOnExtendCheckBox() {
        waitUntilTheElementAppear(By.xpath("//button[@title='Toggle']"));
        locateElement(By.xpath("//button[@title='Toggle']")).click();
    }

    public void extendToDocCheckBox() {
        locateElement(By.xpath("(//button[@title='Toggle'])[3]")).click();
    }

    public void clickOnCheckBox() {
        locateElement(By.xpath("(//input[@id='tree-node-workspace']/../..//span)[1]")).click();
    }

    public void navigateToRadioButton() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Check Box']")));
        locateElement(By.xpath("//span[normalize-space()='Radio Button']")).click();
    }

    public void getTheRadioButton() {
//        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
//        for (WebElement radioButton : radioButtons)
//        {
//            radioButton.getAttribute("");
//        }
        scrollTillTheElementToVisible(locateElement(By.xpath("(//input[@type='radio'])[1]/..")));
        waitUntilTheElementAppear(By.xpath("(//input[@type='radio'])[1]/.."));
        locateElement(By.xpath("(//input[@type='radio'])[1]/..")).click();
    }

    public boolean isRadioButtonEnabled() {
        return locateElement(By.xpath("(//input[@type='radio'])[1]/..")).isEnabled();
    }

    public void navigateToWebTables() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Web Tables']")));
        locateElement(By.xpath("//span[normalize-space()='Web Tables']")).click();
    }

    public void insertTheValueIntoTheTable() {
        locateElement(By.id("addNewRecordButton")).click();
    }

    public void isRegistrationPageDisplay() {
        Assert.assertTrue(locateElement(By.id("registration-form-modal")).isDisplayed());
    }

    public void fillRegFormForWebTables() {
        locateElement(By.id("firstName")).sendKeys(TestData.FIRST_NAME);
        locateElement(By.id("lastName")).sendKeys(TestData.LAST_NAME);
        locateElement(By.id("userEmail")).sendKeys(TestData.USER_EMAIL);
        locateElement(By.id("age")).sendKeys(TestData.AGE);
        locateElement(By.id("salary")).sendKeys(TestData.SALARY);
        locateElement(By.id("department")).sendKeys(TestData.DEPARTMENT);
        locateElement(By.id("submit")).submit();
    }

    public void navigateToTheButtonLinks() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Buttons']")));
        locateElement(By.xpath("//span[normalize-space()='Buttons']")).click();
    }

    public void doubleClickOnTheButton() {
        doubleClick(locateElement(By.id("doubleClickBtn")));
    }

    public void isDoubleClickMessagePresent() {
        waitUntilTheElementAppear(By.id("doubleClickMessage"));
        String exp = locateElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("You have done a double click", exp, "not a valid message");
    }

    public void navigateToLinks() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Links']")));
        locateElement(By.xpath("//span[normalize-space()='Links']")).click();
    }

    public void navigateToTheHomeLink() {
        scrollTillTheElementToVisible(locateElement(By.id("simpleLink")));
        locateElement(By.id("simpleLink")).click();
        Set<String> wid = driver.getWindowHandles();
        Iterator<String> it = wid.iterator();
        String parentWindow = it.next();
        String ChildWindow = it.next();
        driver.switchTo().window(ChildWindow);
    }

    public void navigateToBrokenLinks() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Broken Links - Images']")));
        locateElement(By.xpath("//span[normalize-space()='Broken Links - Images']")).click();
    }

    public void goToValidLinks() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//a[text()='Click Here for Valid Link']")));
        locateElement(By.xpath("//a[text()='Click Here for Valid Link']")).click();
    }

    public void goToInValidLinks() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//a[text()='Click Here for Broken Link']")));
        waitUntilTheElementAppear(By.xpath("//a[text()='Click Here for Broken Link']"));
        locateElement(By.xpath("//a[text()='Click Here for Broken Link']")).click();
    }

    public String getStatusCodeError() {
        waitUntilTheElementAppear(By.xpath("//h3[text()='Status Codes']"));
        return locateElement(By.xpath("//h3[text()='Status Codes']")).getText();
    }

    public void navigateToFileUploadAndDownload() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Upload and Download']")));
        locateElement(By.xpath("//span[normalize-space()='Upload and Download']")).click();
    }

    public void downloadTheElement() {
        waitUntilTheElementAppear(By.xpath("//a[text()='Download']"));
        locateElement(By.xpath("//a[text()='Download']")).click();
    }

    public void uploadAFile() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//input[@type='file']")));
        waitUntilTheElementAppear(By.xpath("//input[@type='file']"));
        locateElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir") + "//src//test//resources//Files//Book 5.xlsx");
//        locateElement(By.xpath("//input[@type='file']")).sendKeys("src/test/resources/Files/Book 5.xlsx");
    }

    public void navigateToDynamicProperties() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[normalize-space()='Dynamic Properties']")));
        locateElement(By.xpath("//span[normalize-space()='Dynamic Properties']")).click();
    }

}
