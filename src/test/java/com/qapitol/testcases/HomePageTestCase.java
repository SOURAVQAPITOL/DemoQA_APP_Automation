package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.base.ExtentListeners;
import com.qapitol.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ExtentListeners.class)
public class HomePageTestCase extends BaseTest{

    HomePage homePage = new HomePage();

    @Test
    public void verifyTheHomePage()
    {
        Assert.assertTrue(homePage.homeLogo());
    }

}
