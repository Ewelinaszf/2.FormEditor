package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.objects.Fields;
import page.objects.FormEditor;
import page.objects.HomePage;

public class AddingAllTypesOfFields extends TestBase {
    @Test
    public void copyDataFromFirstField() throws InterruptedException {

        homePage.createNewForm("CIT-14");

        formEditor.getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania)
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wyboru)
                .getFormEditorMainSection()
                .addTypeOfField(Fields.daty);

        Thread.sleep(5000);


    }
}
