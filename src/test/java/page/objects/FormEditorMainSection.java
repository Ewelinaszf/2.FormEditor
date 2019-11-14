package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class FormEditorMainSection {
    private NameOfFields nameOfFields;
    private WebElement field;
    private FormEditor formEditor;
    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[contains(@class, 'form-creator__wrapper')]/div/div/div/div[3]/i")
    private WebElement addField;

    @FindBy(xpath = "//div[contains(@class, 'editor-modal__footer')]/div/button")
    private WebElement add;

    @FindBy(xpath = "//div[contains(@class, 'form-creator__wrapper')]/div/div/div/div[3]/i")
    private WebElement addIcon;

    @FindBy(xpath = "//span[contains(text(), 'wprowadzania')]/..")
    private WebElement choseTypeOfField;

    @FindBy(xpath = "//button[contains(text(), 'Dodaj')]")
    private WebElement addField2;

    public FormEditorMainSection() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public FormEditorRightSectionBar clickOnEnteringField(Fields fields, int i) throws InterruptedException {
        field = DriverManager.getWebDriver().findElement(By.xpath("//h4[contains(text(), 'Pole " + fields + " " + i + "')]/../.."));
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(field).click().build().perform();
        action.moveToElement(field).click().build().perform();
        return new FormEditorRightSectionBar();
    }

    public FormEditorRightSectionBar clickOnChoiceField(int i) {
        field = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'form-section hover-border hover-borders-vertical PoleWyboru" + i + "')]"));
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(field).click().build().perform();
        action.moveToElement(field).click().build().perform();
        return new FormEditorRightSectionBar();
    }

    public FormEditor addTypeOfField(Fields fields) throws InterruptedException {
        logger.info("Adding type of Field");
        WaitForElement.waitUntilElementIsClickable(addField);
        addField.click();
        WebElement choseTypeOfField= DriverManager.getWebDriver().findElement(By.xpath("//span[contains(text(), '" + fields + "')]/.."));
        WaitForElement.waitUntilElementIsClickable(choseTypeOfField);
        choseTypeOfField.click();
        addField2.click();
        Thread.sleep(2000);
        return new FormEditor();
    }

}
