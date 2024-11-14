package com.qapitol.testcases;

import com.qapitol.base.BaseTest;
import com.qapitol.base.ExtentListeners;
import com.qapitol.pages.ElementsPage;
import com.qapitol.pages.FormsPage;
import com.qapitol.pages.HomePage;
import com.qapitol.util.ExcelDataDriven;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

@Listeners(ExtentListeners.class)
public class FormsPageTest extends BaseTest {

    String filePath = System.getProperty("user.dir")+"//src//test//resources//Files//FormTestData.xlsx";

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
    public void practiceForm() throws InterruptedException {
        formsPage.navigateToPracticeForm();
        Assert.assertTrue(isElementPresent("//h1[text()='Practice Form']"));
        formsPage.studentRegistration();
    }

    //TODO- Test case is pending
    @Test(dataProvider = "mytestdata")
    public void practiceFormWithExcelData(String firstName,String lastName, String email,
                                          String gender, String mobile, String dob, String subjects,
                                          String hobbies, String picture, String currentAddress, String state,
                                          String city){

        System.out.println(firstName);
        System.out.println(lastName);

    }

    @DataProvider(name = "mytestdata")
    public Object[][] getMydata() throws IOException {

        ExcelDataDriven reader = new ExcelDataDriven();
        return reader.getExcelData(filePath);
    }


}
