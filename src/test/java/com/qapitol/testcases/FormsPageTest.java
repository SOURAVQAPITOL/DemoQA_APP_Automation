package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.base.ExtentListeners;
import com.qapitol.pages.ElementsPage;
import com.qapitol.pages.FormsPage;
import com.qapitol.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ExtentListeners.class)
public class FormsPageTest extends BaseTest {

    FormsPage formsPage = new FormsPage();
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
    public void practiceForm(){
        formsPage.navigateToPracticeForm();
        Assert.assertTrue(isElementPresent("//h1[text()='Practice Form']"));
        formsPage.studentRegistration();
    }
}
