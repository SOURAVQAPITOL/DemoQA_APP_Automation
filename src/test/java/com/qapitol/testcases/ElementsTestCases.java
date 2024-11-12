package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.pages.ElementsPage;
import com.qapitol.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ElementsTestCases extends BaseTest {

    HomePage homePage;
    ElementsPage elementsPage;

    @BeforeMethod
    public void setUp() throws IOException {
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        initialize();
    }

    @AfterMethod
    public void tearDown() {
        QuitTheDriver();
    }

    @Test
    public void textBoxTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToTextBox();
        Assert.assertTrue(isElementPresent("//h1[text()='Text Box']"));
        elementsPage.enterValueInTheField();
        elementsPage.clickOnSubmitButton();
    }

    @Test
    public void checkBoxTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateTOCheckBox();
        Assert.assertTrue(isElementPresent("//h1[text()='Check Box']"));
        elementsPage.clickOnExtendCheckBox();
        elementsPage.extendToDocCheckBox();
        elementsPage.clickOnCheckBox();
    }

    @Test
    public void RadioButtonTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToRadioButton();
        Assert.assertTrue(isElementPresent("//h1[text()='Radio Button']"));
        elementsPage.getTheRadioButton();
        Assert.assertTrue(elementsPage.isRadioButtonEnabled());
    }

    @Test
    public void WebTableTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToWebTables();
        Assert.assertTrue(isElementPresent("//h1[text()='Web Tables']"));
        elementsPage.insertTheValueIntoTheTable();
        elementsPage.isRegistrationPageDisplay();
        elementsPage.fillRegFormForWebTables();
    }

    @Test
    public void ButtonTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToTheButtonLinks();
        Assert.assertTrue(isElementPresent("//h1[text()='Buttons']"));
        elementsPage.doubleClickOnTheButton();
        elementsPage.isDoubleClickMessagePresent();
    }

    @Test
    public void LinkTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToLinks();
        Assert.assertTrue(isElementPresent("//h1[text()='Links']"));
        elementsPage.navigateToTheHomeLink();
        homePage.isHomeURLPresent();
    }

    @Test
    public void BrokenLinkTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToBrokenLinks();
        Assert.assertTrue(isElementPresent("//h1[text()='Broken Links - Images']"));
        elementsPage.goToValidLinks();
        homePage.isHomeURLPresent();
        getBackToPreviousPage();
        elementsPage.goToInValidLinks();
        Assert.assertEquals(elementsPage.getStatusCodeError(), "Status Codes");
    }

    @Test
    public void fileDownloadTest() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToFileUploadAndDownload();
        locateElement(By.xpath("//h1[text()='Upload and Download']")).click();
        elementsPage.downloadTheElement();
        elementsPage.uploadAFile();
    }

    @Test
    public void waitForTheColorChange() {
        homePage.navigateToTheElementsPage();
        elementsPage.navigateToDynamicProperties();
        Assert.assertTrue(isElementPresent("//h1[text()='Dynamic Properties']"));
    }


}
