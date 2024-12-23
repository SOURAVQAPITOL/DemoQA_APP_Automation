package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class AlertsAndFramesPage extends BaseTest {

    public AlertsAndFramesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='category-cards']//*[name()='svg'])[3]")
    WebElement alerts;

    @FindBy(xpath = "//span[text()='Browser Windows']")
    WebElement browserWindow;

    @FindBy(id = "tabButton")
    WebElement tabButton;

    @FindBy(xpath = "//button[text()='New Window']")
    WebElement newWindowButton;

    @FindBy(xpath = "//button[text()='New Window Message']")
    WebElement newWindowMsg;

    @FindBy(xpath = "//span[text()='Alerts']")
    WebElement alertsTabb;


    public void navigateToAlertsAndFrames() {
//        waitUntilTheElementAppear(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[3]"));
        scrollTillTheElementToVisible(alerts);
        alerts.click();
//        locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[3]")).click();
    }

    public void navigateToTheBrowserWindow() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Browser Windows']"));
        browserWindow.click();
    }

    public void openNewTabAndGetBackToCurrentTab() {
        scrollTillTheElementToVisible(locateElement(By.id("tabButton")));
        tabButton.click();
        Set<String> wid = driver.getWindowHandles();
        Iterator<String> it = wid.iterator();
        String parentWindow = it.next();
        String ChildWindow = it.next();
        driver.switchTo().window(ChildWindow);
        driver.switchTo().defaultContent();
    }

    public void openANewWindow() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//button[text()='New Window']")));
        newWindowButton.click();
        String currentWid = driver.getWindowHandle();
        Set<String> wids = driver.getWindowHandles();
        for (String wid : wids) {
            if (!wid.equals(currentWid)) {
                driver.switchTo().window(wid);
                break;
            }
        }
    }

    public void verifyTheNewWindow() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/sample", "Assertion failed");
    }

    public void getAnewWindowMessage() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//button[text()='New Window Message']")));
        newWindowMsg.click();
        String currentWid = driver.getWindowHandle();
        Set<String> wids = driver.getWindowHandles();
        for (String wid : wids) {
            if (!wid.equals(currentWid)) {
                driver.switchTo().window(wid);
                break;
            }
        }
        String newWinMessage = locateElement(By.xpath("//body")).getAttribute("body");
        System.out.println(newWinMessage);
    }

    public void navigateToAlerts() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Alerts']"));
        alertsTabb.click();
    }

    public void clickToSeeTheAlert() {
        locateElement(By.id("alertButton")).click();
    }

    public void acceptThAlertMessage() {
        driver.switchTo().alert().accept();
    }

    public void seeTheAlertAfter5Seconds() throws InterruptedException {
        locateElement(By.id("timerAlertButton")).click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        driver.switchTo().activeElement();
    }

    public void navigateToTheConfirmBox() {
        locateElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
    }

    public void verifyTheConfirmResult() {
        String actConfirmationMsg = locateElement(By.id("confirmResult")).getText();
//        actConfirmationMsg.trim();
        System.out.println(actConfirmationMsg.trim());
    }

    public void navigateToPrompAlert() {
        locateElement(By.id("promtButton")).click();
        driver.switchTo().alert().accept();
    }

    public void navigateToFrames() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Frames']"));
        locateElement(By.xpath("//span[text()='Frames']")).click();
    }

    public void getInToTheFrame() {
        WebElement iframe = locateElement(By.id("frame1"));
        driver.switchTo().frame(iframe);
    }

    public void verifyTheNewIframeText() {
        String iFrameHeaderText = locateElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(iFrameHeaderText, "This is a sample page", "Assertion Failed");
    }

    public void navigateToNestedFrames() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Nested Frames']"));
        locateElement(By.xpath("//span[text()='Nested Frames']")).click();
    }

    public void getIntoTheNestedFrames() {
        driver.switchTo().frame("frame1");
    }

    public void verifyParentFrame() {
        String parentText = locateElement(By.xpath("//body")).getText();
        Assert.assertEquals(parentText, "Parent frame", "Assertion failed");
    }

    public void getIntoTheChildFrame() {
        driver.switchTo().frame(0);
    }

    public void verifyTheChildFrame() {
        String childText = locateElement(By.xpath("//p[text()='Child Iframe']")).getText();
        Assert.assertEquals(childText, "Child Iframe", "Assertion failed");
    }

    public void navigateToModalDialogs() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Modal Dialogs']"));
        locateElement(By.xpath("//span[text()='Modal Dialogs']")).click();
    }

    public void clickOnSmallModal() {
        locateElement(By.id("showSmallModal")).click();
        waitUntilTheElementAppear(By.xpath("//div[text()='Small Modal']"));
    }

    public void clickOnCloseForSmallModal() {
        locateElement(By.id("closeSmallModal")).click();
        waitUntilTheElementAppear(By.xpath("//h1[text()='Modal Dialogs']"));
    }

    public void clickOnLargeModal() {
        locateElement(By.id("showLargeModal")).click();
        waitUntilTheElementAppear(By.xpath("//div[text()='Large Modal']"));
    }

    public void clickOnCloseForLargeModal() {
        locateElement(By.id("closeLargeModal")).click();
        waitUntilTheElementAppear(By.xpath("//h1[text()='Modal Dialogs']"));
    }
}
