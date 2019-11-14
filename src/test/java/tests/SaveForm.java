package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.Fields;
import page.objects.FormEditor;
import page.objects.HomePage;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class SaveForm extends TestBase {

    @Test
    public void saveForm() throws InterruptedException {

        homePage.createNewForm("CIT-14");

        formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania)
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldButtonActions()
                .openSimplifiedPreview()
                .getSimplifiedViewButtonActions()
                .returnToFillingField()
                .getFormEditorNavBar()
                .saveFormEditor();


        Thread.sleep(5000);


    }
}
