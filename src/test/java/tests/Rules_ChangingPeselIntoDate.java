package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.Fields;
import page.objects.FillingField;
import page.objects.FormEditor;
import page.objects.HomePage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rules_ChangingPeselIntoDate extends TestBase {

    @Test
    public void copyDataFromFirstField() throws InterruptedException, ParseException {

        homePage.createNewForm("CIT-14");

        formEditor
                .getFormEditorMainSection()
                .addTypeOfField(Fields.wprowadzania)
                .getFormEditorMainSection().addTypeOfField(Fields.daty)
                .getFormEditorMainSection()
                .clickOnEnteringField(Fields.daty, 1)
                .setProgrammingRule("references(['PoleWprowadzania1']),\n" +
                        "calculated(({ref}) => {\n" +
                        "  const pesel = ref['PoleWprowadzania1'];\n" +
                        "  const year = Number(pesel.slice(0, 2));\n" +
                        "  let month = Number(pesel.slice(2, 4));\n" +
                        "  const day = pesel.slice(4, 6);\n" +
                        "  let century;\n" +
                        "  if (month < 13) {\n" +
                        "    century = 1900;\n" +
                        "  } else if (month < 33) {\n" +
                        "    century = 2000;\n" +
                        "    month -= 20;\n" +
                        "  } else if (month < 53) {\n" +
                        "    century = 2100;\n" +
                        "    month -= 40;\n" +
                        "  } else if (month < 73) {\n" +
                        "    century = 2200;\n" +
                        "    month -= 60;\n" +
                        "  } else {\n" +
                        "    century = 1800;\n" +
                        "    month -= 80;\n" +
                        "  }\n" +
                        "  if (month < 10) month = '0' + String(month);\n" +
                        "  return day + '.' + String(month) + '.' + String(century + year);\n" +
                        "})\n");
        Thread.sleep(3000);
        formEditor
                .getFormEditorNavBar()
                .openFillingField()
                .getFillingFieldMainSection()
                .enterPesel(Fields.wprowadzania, 1);

        fillingField.getFillingFieldMainSection();
        String dateOfField = fillingField
                .getFillingFieldMainSection()
                .findField(Fields.daty, 1)
                .getAttribute("value");
        validateJavaDate(dateOfField);


        Thread.sleep(5000);
    }

    public static boolean validateJavaDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM.dd.yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }

            return true;
        }
    }
}