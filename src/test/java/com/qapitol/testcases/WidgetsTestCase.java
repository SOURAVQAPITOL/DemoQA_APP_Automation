package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.base.ExtentListeners;
import com.qapitol.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ExtentListeners.class)
public class WidgetsTestCase extends BaseTest {

    HomePage homePage;
    ElementsPage elementsPage;
    AlertsAndFramesPage alertsAndFramesPage;
    InteractionsPage interactionsPage;
    WidgetsPage widgetsPage;

    @BeforeMethod
    public void setUp() throws IOException {
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        alertsAndFramesPage = new AlertsAndFramesPage(driver);
        interactionsPage = new InteractionsPage();
        widgetsPage = new WidgetsPage();
        initialize();
    }

    @AfterMethod
    public void tearDown() {
        QuitTheDriver();
    }

    @Test
    public void accordianTest() throws InterruptedException {
        widgetsPage.navigateToWidgets();
        widgetsPage.navigateToAccordian();
        Assert.assertTrue(isElementPresent("//h1[text()='Accordian']"));
        widgetsPage.getToTheSecondAccordian();
        Thread.sleep(3000);
        Assert.assertTrue(isElementPresent("(//p[contains(text(),'Contrary to popular belief, Lorem Ipsum is not sim')])[1]"));
    }

    @Test
    public void autoCompleteForMultipleColors() throws InterruptedException {
        widgetsPage.navigateToWidgets();
        widgetsPage.navigateToAutoComplete();
        Thread.sleep(3000);
        Assert.assertTrue(isElementPresent("//h1[text()='Auto Complete']"));
        Thread.sleep(3000);
        widgetsPage.typeMultipleColorNames();
        Thread.sleep(2000);
    }

    @Test
    public void autoCompleteForSingleColor() throws InterruptedException {
        widgetsPage.navigateToWidgets();
        widgetsPage.navigateToAutoComplete();
        Thread.sleep(3000);
        Assert.assertTrue(isElementPresent("//h1[text()='Auto Complete']"));
        Thread.sleep(3000);
        widgetsPage.typeSingleColorName();
        Thread.sleep(2000);
    }

    @Test
    public void pickTheDate() throws InterruptedException {
        widgetsPage.navigateToWidgets();
        widgetsPage.navigateToDatePicker();
        Assert.assertTrue(isElementPresent("//h1[text()='Date Picker']"));
        Thread.sleep(3000);
        widgetsPage.selectDate();
        Thread.sleep(3000);
        Assert.assertTrue(isElementPresent("//input[@id='datePickerMonthYearInput']"));
    }

    @Test
    public void sliderTest() throws InterruptedException {
        widgetsPage.navigateToWidgets();
        widgetsPage.navigateToSlider();
        Assert.assertTrue(isElementPresent("//h1[text()='Slider']"));
        widgetsPage.sliderTest();
        Assert.assertEquals(widgetsPage.verifyTheSliderText(), "64", "Failed");
    }

    @Test
    public void toolTipsTest() throws InterruptedException {
        widgetsPage.navigateToWidgets();
        widgetsPage.navigateToToolTips();
        Assert.assertTrue(isElementPresent("//h1[text()='Tool Tips']"));
        widgetsPage.toolTipTest();
        widgetsPage.verifyTheMouseHover();
    }
}
