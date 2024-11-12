package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.pages.AlertsAndFramesPage;
import com.qapitol.pages.ElementsPage;
import com.qapitol.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertsAndFramesTestCases extends BaseTest {

    HomePage homePage;
    ElementsPage elementsPage;
    AlertsAndFramesPage alertsAndFramesPage;

    @BeforeMethod
    public void setUp() throws IOException {
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        alertsAndFramesPage = new AlertsAndFramesPage();
        initialize();
    }

    @AfterMethod
    public void tearDown() {
        QuitTheDriver();
    }

    @Test
    public void browsersWindowTest() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToTheBrowserWindow();
        Assert.assertTrue(isElementPresent("//h1[text()='Browser Windows']"));
        alertsAndFramesPage.openNewTabAndGetBackToCurrentTab();
    }

    @Test
    public void openANewWindow() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToTheBrowserWindow();
        Assert.assertTrue(isElementPresent("//h1[text()='Browser Windows']"));
        alertsAndFramesPage.openANewWindow();
        alertsAndFramesPage.verifyTheNewWindow();
    }

    @Test
    public void newWindowMessage() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToTheBrowserWindow();
        Assert.assertTrue(isElementPresent("//h1[text()='Browser Windows']"));
        alertsAndFramesPage.getAnewWindowMessage();
    }

    @Test
    public void handleTheAlerts() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToAlerts();
        alertsAndFramesPage.clickToSeeTheAlert();
        alertsAndFramesPage.acceptThAlertMessage();
    }

    @Test
    public void handleTheAlertsAfter5Seconds() throws InterruptedException {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToAlerts();
        alertsAndFramesPage.seeTheAlertAfter5Seconds();
    }

    @Test
    public void confirmBoxAfterAlert() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToAlerts();
        alertsAndFramesPage.navigateToTheConfirmBox();
    }

    @Test
    public void promptBoxAlert() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToAlerts();
        alertsAndFramesPage.navigateToPrompAlert();
    }

    @Test
    public void frameTest() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToFrames();
        Assert.assertTrue(isElementPresent("//h1[text()='Frames']"));
        alertsAndFramesPage.getInToTheFrame();
        alertsAndFramesPage.verifyTheNewIframeText();
    }

    @Test
    public void nestedFrameTest() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToNestedFrames();
        Assert.assertTrue(isElementPresent("//h1[text()='Nested Frames']"));
        alertsAndFramesPage.getIntoTheNestedFrames();
        alertsAndFramesPage.verifyParentFrame();
        alertsAndFramesPage.getIntoTheChildFrame();
        alertsAndFramesPage.verifyTheChildFrame();
    }

    @Test
    public void modalDialougesTest() {
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToModalDialogs();
        Assert.assertTrue(isElementPresent("//h1[text()='Modal Dialogs']"));
        alertsAndFramesPage.clickOnSmallModal();
        Assert.assertTrue(isElementPresent("//div[text()='Small Modal']"));
        alertsAndFramesPage.clickOnCloseForSmallModal();
        Assert.assertTrue(isElementPresent("//h1[text()='Modal Dialogs']"));
    }

    @Test
    public void largeModalTest(){
        alertsAndFramesPage.navigateToAlertsAndFrames();
        alertsAndFramesPage.navigateToModalDialogs();
        Assert.assertTrue(isElementPresent("//h1[text()='Modal Dialogs']"));
        alertsAndFramesPage.clickOnLargeModal();
        Assert.assertTrue(isElementPresent("//div[text()='Large Modal']"));
        alertsAndFramesPage.clickOnCloseForLargeModal();
        Assert.assertTrue(isElementPresent("//h1[text()='Modal Dialogs']"));
    }
}
