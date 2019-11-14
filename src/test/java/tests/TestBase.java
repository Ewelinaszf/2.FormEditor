package tests;


import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.objects.FillingField;
import page.objects.FormEditor;
import page.objects.HomePage;
import page.objects.SimpliefiedView;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static navigation.ApplicationURLs.APPLICATION_URL;
public class TestBase {
    HomePage homePage;
    FormEditor formEditor;
    FillingField fillingField;
    SimpliefiedView simpliefiedView;
    public WebDriver driver;



    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
        homePage = new HomePage();
        formEditor = new FormEditor();
        simpliefiedView = new SimpliefiedView();
        fillingField = new FillingField();

    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}