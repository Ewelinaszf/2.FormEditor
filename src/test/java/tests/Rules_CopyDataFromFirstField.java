package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.Fields;
import page.objects.FillingField;
import page.objects.FormEditor;
import page.objects.HomePage;

public class Rules_CopyDataFromFirstField extends TestBase {

    @Test
    public void copyDataFromFirstField() throws InterruptedException {

        String name = "Wprowadzam tekst tutaj";
        homePage.createNewForm("CIT-14");

        formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania);
       formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania).getFormEditorMainSection()
                .clickOnEnteringField(Fields.wprowadzania, 2).setProgrammingRule("references([\"PoleWprowadzania1\"]),\n" +
                "calculated(({ref}) => ref[\"PoleWprowadzania1\"])\n");

        Thread.sleep(5000);
        formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .findField(Fields.wprowadzania, 1)
                .sendKeys(name);
        String name2 = formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .findField(Fields.wprowadzania, 2)
                .getAttribute("value");
        Assert.assertEquals(name, name2);
        Thread.sleep(5000);

    }
}
