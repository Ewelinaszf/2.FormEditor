package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.*;

import java.util.Arrays;

public class Dictionaries_ChangingInternalDictionary extends TestBase {

    @Test
    public void checkingInternalDictionary() throws InterruptedException {


        homePage.createNewForm("CIT-14");

        formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wyboru)
                .getFormEditorMainSection()
                .clickOnChoiceField(1)
                .changeTypeOfChoiceField(1);

        String[] internalDirectionary = formEditor
                .getFormEditorRightSectionBar()
                .CountriesInternalDictionary();

        formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .checkCheckbox(1);
        Thread.sleep(3000);

                fillingField
                        .getFillingFieldButtonActions()
                        .openSimplifiedPreview();

        String[] checkedValue =
                       simpliefiedView
                        .getSimpliefiedViewMainSection()
                        .readData();

        String[] names = {"Polska", "Belgia", "Hiszpania", "Niemcy"};

        for (int i = 0; i < checkedValue.length; i++) {

            Assert.assertTrue(Arrays.asList(names).contains(checkedValue[i]));
        }

        Thread.sleep(5000);


    }
}
