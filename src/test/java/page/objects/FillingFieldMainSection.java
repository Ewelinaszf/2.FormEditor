package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class FillingFieldMainSection {
    private Logger logger = LogManager.getRootLogger();
    public FillingFieldMainSection() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public WebElement findField(Fields fields, int i) {
        WebElement inputField = DriverManager.getWebDriver().findElement(By.xpath("//span[contains(text(),'Pole " + fields + " " + i + "')]/../span[2]/input"));
        return inputField;
    }

    public int enterValue(Fields fields, int i) {
        logger.info("Entering value into input Field");
        WebElement inputField = findField(fields, i);
        int num = generateNumber(i);
        inputField.sendKeys(Integer.toString(num));
        return num;
    }

    public String enterPesel(Fields fields, int i) {
        logger.info("Entering pesel into input Field");
        WebElement inputField = findField(fields, i);
        String pesel = "86030245678";
        inputField.sendKeys(pesel);
        return pesel;
    }

    public int generateNumber(int i) {
        Random r = new Random();
        int number = r.nextInt(10 ^ i);
        return number;
    }

    public void checkCheckbox(int choiceField) throws InterruptedException {
        List<WebElement> checkboxesAmount = DriverManager.getWebDriver().findElements(By.xpath(("//legend[contains(text(), 'Pole wyboru 1')]/../div/div")));
        for (int i = 1; i <= checkboxesAmount.size(); i++) {
            DriverManager.getWebDriver().findElement(By.xpath("//legend[contains(text(), 'Pole wyboru " + choiceField + "')]/../div[1]/div[" + i + "]/label[1]/span[2]")).click();

        }
    }

}
