package com.qapitol.pages;

import com.qapitol.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class InteractionsPage extends BaseTest {

    public void navigateToAInteractions() {
        waitUntilTheElementAppear(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[5]"));
        scrollTillTheElementToVisible(locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[5]")));
        locateElement(By.xpath("(//div[@class='category-cards']//*[name()='svg'])[5]")).click();
    }

    public void navigateToSortableWindow() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Sortable']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[text()='Sortable']")));
        locateElement(By.xpath("//span[text()='Sortable']")).click();
    }

    public void clickOnList() {
        Actions actions = new Actions(driver);
        locateElement(By.xpath("//a[text()='List']")).click();
        scrollTillTheElementToVisible(locateElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[text()='One']")));
        WebElement src = locateElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[text()='One']"));
        WebElement targ = locateElement(By.xpath("//div[@class='vertical-list-container mt-4']/div[text()='Two']"));
        actions.clickAndHold().pause(2000).dragAndDrop(src, targ).pause(2000).build().perform();
    }

    public void clickOnGrid() {
        scrollTillTheElementToVisible(locateElement(By.id("demo-tab-grid")));
        waitUntilTheElementAppear(By.id("demo-tab-grid"));
        locateElement(By.id("demo-tab-grid")).click();
        Actions actions = new Actions(driver);

        List<WebElement> Grids = driver.findElements(By.cssSelector(".create-grid .list-group-item.list-group-item-action"));
        for (WebElement Grid : Grids) {
            if (Grid.getText().equalsIgnoreCase("One")) {
                WebElement src = Grid;
                for (int i = 0; i <= Grids.size(); i++) {
                    WebElement targ = Grid;
                    actions.pause(2000).clickAndHold(src).pause(2000).release(targ).build().perform();
                }
            }
        }
    }

    public void navigateToSelectable() {
        waitUntilTheElementAppear(By.xpath("//span[text()='Selectable']"));
        scrollTillTheElementToVisible(locateElement(By.xpath("//span[text()='Selectable']")));
        locateElement(By.xpath("//span[text()='Selectable']")).click();
    }

    public void selectAllTheListsAndDeselectIt() {
        scrollTillTheElementToVisible(locateElement(By.xpath("//a[text()='List']")));
        locateElement(By.xpath("//a[text()='List']")).click();
        List<WebElement> lists = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']/ul/li"));
        for (WebElement list : lists) {
            for (int i =0; i<=3;i++) {list.click();}
        }
    }
}
