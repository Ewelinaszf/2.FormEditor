package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.*;

import java.util.concurrent.TimeUnit;

public class Rules_CheckingAddingFields extends TestBase {
    private int firstValue;
    private int secondValue;
    private int thirdValue;
    @Test
    public void addProgrammingRule() throws InterruptedException {

        homePage.createNewForm("CIT-14");

        formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania)
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania)
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania);


        formEditor
                .getFormEditorMainSection()
                .clickOnEnteringField(Fields.wprowadzania,1)
                .changeTypeOfInputField(Types.Liczba);

        formEditor
                .getFormEditorMainSection()
                .clickOnEnteringField(Fields.wprowadzania, 2)
                .changeTypeOfInputField(Types.Liczba);

        formEditor
                .getFormEditorMainSection()
                .clickOnEnteringField(Fields.wprowadzania, 3)
                .changeTypeOfInputField(Types.Liczba)
                .getFormEditorRightSectionBar()
                .setProgrammingRule("references(['PoleWprowadzania1', 'PoleWprowadzania2']),\n" +
                                "calculated(({num}) => num['PoleWprowadzania1'] + num['PoleWprowadzania2'])\n");


       Thread.sleep(5000);
       firstValue= formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .enterValue(Fields.wprowadzania, 1);

        secondValue =formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .enterValue(Fields.wprowadzania, 2);

        thirdValue =
                Integer.parseInt((formEditor)
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .findField(Fields.wprowadzania, 3).getAttribute("value"));

        Assert.assertEquals(firstValue+secondValue, thirdValue);
        Thread.sleep(5000);
    }
}