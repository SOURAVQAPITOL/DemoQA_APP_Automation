package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.base.ExtentListeners;
import com.qapitol.pages.ElementsPage;
import com.qapitol.pages.FormsPage;
import com.qapitol.pages.HomePage;
import com.qapitol.util.ExcelDataDriven;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(ExtentListeners.class)
public class FormsPageTest extends BaseTest {

    String filePath = System.getProperty("user.dir") + "//src//test//resources//Files//FormTestData.xlsx";

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

    //TODO- Test case is pending
    @Test
    public void practiceForm() throws InterruptedException {
        formsPage.navigateToPracticeForm();
        Assert.assertTrue(isElementPresent("//h1[text()='Practice Form']"));
        formsPage.studentRegistration();
    }

    @Test(dataProvider = "mytestdata")
    public void practiceFormWithExcelData(String firstName, String lastName, String email,
                                          String gender, String mobile, String dob, String subjects,
                                          String hobbies, String picture, String currentAddress, String state,
                                          String city) throws InterruptedException {

        System.out.println(firstName);
        System.out.println(lastName);

        formsPage.navigateToPracticeForm();
        Assert.assertTrue(isElementPresent("//h1[text()='Practice Form']"));
        waitUntilTheElementAppear(By.id("firstName"));
        scrollTillTheElementToVisible(locateElement((By.id("firstName"))));
        Thread.sleep(2000);
        locateElement(By.id("firstName")).sendKeys(firstName);
        Thread.sleep(2000);
        locateElement(By.id("lastName")).sendKeys(lastName);
        Thread.sleep(2000);
        locateElement(By.id("userEmail")).sendKeys(email);
        Thread.sleep(2000);
        formsPage.chooseTheGender(gender);
        scrollThePages();
        Thread.sleep(2000);
        locateElement(By.id("userNumber")).sendKeys(mobile);
        Thread.sleep(2000);
        driver.findElement(By.id("subjectsInput")).sendKeys(subjects);
        Thread.sleep(2000);
        formsPage.chooseHobbies(hobbies);
        Thread.sleep(2000);
        locateElement(By.id("uploadPicture")).sendKeys(System.getProperty("user.dir") + picture);
        Thread.sleep(2000);
        scrollThePages();
        locateElement(By.id("currentAddress")).sendKeys(currentAddress);
        locateElement(By.xpath("//div[text()='Select State']")).click();
        locateElement(By.id("react-select-3-option-0")).click();
        Thread.sleep(2000);
        locateElement(By.xpath("//div[text()='Select City']")).click();
        Thread.sleep(3000);
        locateElement(By.id("react-select-4-option-0")).click();
    }

    @DataProvider(name = "mytestdata")
    public Object[][] getMydata() throws IOException {
        ExcelDataDriven reader = new ExcelDataDriven();
        return reader.getExcelData(filePath);
    }


}
