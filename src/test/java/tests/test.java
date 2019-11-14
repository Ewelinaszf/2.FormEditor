package tests;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import page.objects.Fields;
import page.objects.SimpliefiedView;

public class test extends TestBase {

    @FindBy(xpath="//div[contains(@class, 'wcag-display-value')]")
    private WebElement windowWithEnteredValue;
    @Test
    public void copyDataFromFirstField() throws InterruptedException {
        homePage.createNewForm("CIT-14");

        formEditor.getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania);

        formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .findField(Fields.wprowadzania, 1)
                .sendKeys("123456");

        Thread.sleep(3000);
        fillingField
                .getFillingFieldButtonActions()
                .openSimplifiedPreview();
        Thread.sleep(5000);
      SimpliefiedView simpliefiedView = new SimpliefiedView();
       simpliefiedView.getSimpliefiedViewMainSection().readData();
   //     simpliefiedView.getSimpliefiedViewMainSection();
   //    WebElement el= DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'wcag-display-value')]"));
    //   System.out.println(el.getText());
    }
}