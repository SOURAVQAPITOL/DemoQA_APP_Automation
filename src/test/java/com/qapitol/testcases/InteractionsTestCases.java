package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.pages.AlertsAndFramesPage;
import com.qapitol.pages.ElementsPage;
import com.qapitol.pages.HomePage;
import com.qapitol.pages.InteractionsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class InteractionsTestCases extends BaseTest {

    HomePage homePage;
    ElementsPage elementsPage;
    AlertsAndFramesPage alertsAndFramesPage;
    InteractionsPage interactionsPage;

    @BeforeMethod
    public void setUp() throws IOException {
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        alertsAndFramesPage = new AlertsAndFramesPage();
        interactionsPage = new InteractionsPage();
        initialize();
    }

    @AfterMethod
    public void tearDown() {
        QuitTheDriver();
    }

    @Test
    public void sortableTest() {
        interactionsPage.navigateToAInteractions();
        interactionsPage.navigateToTheBrowserWindow();
        Assert.assertTrue(isElementPresent("//h1[text()='Sortable']"));
        interactionsPage.clickOnList();
    }

    @Test
    public void sortTheGrid() throws InterruptedException {
        interactionsPage.navigateToAInteractions();
        interactionsPage.navigateToTheBrowserWindow();
        Assert.assertTrue(isElementPresent("//h1[text()='Sortable']"));
        Thread.sleep(4000);
        interactionsPage.clickOnGrid();
        Thread.sleep(4000);
    }
}
