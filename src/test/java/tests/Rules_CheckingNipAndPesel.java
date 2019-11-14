package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.*;

public class Rules_CheckingNipAndPesel extends TestBase {


    @Test
    public void checkingNipAndPesel() throws InterruptedException {

        homePage.createNewForm("CIT-14");

        formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wyboru)
                .getFormEditorMainSection()
                .clickOnChoiceField(1)
                .changeTypeOfChoiceField(1)
                .NipInternalDictionary();

        formEditor
                .getFormEditorRightSectionBar()
                .useMultipleValues();

        formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania)
                .getFormEditorMainSection()
                .clickOnEnteringField(Fields.wprowadzania, 1)
                .setProgrammingRule("references([\"PoleWyboru1\"]),\n" +
                        "visibleWhen(({ref}) => ref[\"PoleWyboru1\"] == \"Nip\"),\n" +
                        "should.beNip,\n" +
                        "should.beSet\n");

        Thread.sleep(5000);

        formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .checkCheckbox(1);

        WebElement errorMessage = driver.findElement(By.xpath("//span[contains(@class, 'error-message')]"));

        Assert.assertTrue(errorMessage.isDisplayed());
        fillingField
                .getFillingFieldMainSection()
                .findField(Fields.wprowadzania, 1).sendKeys("1111111111");


        Thread.sleep(5000);
    }
}