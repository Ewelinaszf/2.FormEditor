package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormEditorRightSectionBar  {

    public String[] names = {"Polska", "Belgia", "Hiszpania", "Niemcy"};
    private Types type;
    public WebElement systemName;
    public String NIP = "should.beNip";

    @FindBy(xpath = "//LABEL[text()='Nazwa systemowa']/../../../div[3]/div[1]")
    private WebElement setProgrammingRule;

    @FindBy(xpath = "//pre[contains(@class, 'prism-editor__code language-js')]")
    private WebElement ruleWindow;

    @FindBy(xpath = "//button[contains(@class,'button__outline button__outline--primary')]")
    private WebElement saveProgrammingRule;

    public FormEditorRightSectionBar( ) {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public Types types() {
        return type;
    }

    //FIELD SECTION
    public void removeField() throws InterruptedException {
        systemName = DriverManager.getWebDriver().findElement(By.xpath("//LABEL[text()='Nazwa systemowa']/../../div[1]/span/i[2]"));
        systemName.click();
        WebElement clickOk = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\"app\"]/div[4]/div[2]/div[4]/div/div[2]/div/div/div[1]"));
        clickOk.click();
    }

    public void changeFieldLocation() {
        Select drpLocation = new Select(DriverManager.getWebDriver().findElement(By.id("input55")));
        List<WebElement> list = drpLocation.getOptions();
        list.size();
        drpLocation.selectByIndex(1);
    }

    //LOCATION SECTION
    public void systemName() throws InterruptedException {

        systemName = DriverManager.getWebDriver().findElement(By.xpath("//LABEL[text()='Nazwa systemowa']/../INPUT"));
        systemName.click();
    }

    public void changePositionUp(int amountOfClicks) {
        WebElement positionUp = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\'app\']/div[4]/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]"));
        for (int i = 1; i <= amountOfClicks; i++) {
            positionUp.click();
        }
    }

    public void changePositionDown(int amountOfClicks) {
        WebElement positionDown = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\'app\']/div[4]/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[1]"));
        for (int i = 1; i <= amountOfClicks; i++) {
            positionDown.click();
        }
    }

    //PROGRAMMING SECTION
    public void setProgrammingRule(String nameOfRule) {

        setProgrammingRule.click();
        ruleWindow.click();
        ruleWindow.sendKeys(nameOfRule);
        saveProgrammingRule.click();
    }

    private String adding() {
        return "references(['PoleWprowadzania1', 'PoleWprowadzania2']),\\n\" +\n" +
                "                \"calculated(({num}) => num['PoleWprowadzania1'] + num['PoleWprowadzania2'])\\n";
    }

    private String NIP() {
        return "should.beNip";
    }

    //NAME SECTION
    public void changeName(String newName) {
        // WebElement name = driver.findElement(By.xpath("//div[contains(@class, 'uniqueName-label text')]/input"));
        WebElement name = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'field-block field-name')]/div/input"));
        name.clear();
        name.sendKeys(newName);
    }

    public void giveDescription(String newDescription) {
        WebElement description = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'field-block field-name')]/span[2]/div/div/textarea"));
        description.sendKeys(newDescription);
    }

    //INPUT FIELD SECTION
    public void checkManyLines() {
        //   WebElement manyLines = driver.findElement(By.name("input90"));
        //  manyLines.click();
    }

    public FormEditor changeTypeOfInputField(Types type) {
        WebElement contentType = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'field-block field-input')]/div[2]/select"));
        Select selectType = new Select(contentType);
        selectType.selectByVisibleText(String.valueOf(type));
        return new FormEditor();
    }

    //MAPPING SECTION

    public void clickOnRepresentationOfTheChart() {
        WebElement representationOfTheChart = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'field-block field-mapping')]/div[2]"));
        if (representationOfTheChart.isDisplayed()) {
            representationOfTheChart.click();
        }

    }

    //CHOICE FIELD
    public FormEditorRightSectionBar changeTypeOfChoiceField(int i) {
        Select type = new Select(DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'field-block field-section')]/div/div/select")));
        List<WebElement> list = type.getOptions();
        list.size();
        type.selectByIndex(i);
        return new FormEditorRightSectionBar();
    }

    public String[] NipInternalDictionary() throws InterruptedException {
        String[] keys = {"Pesel", "Nip", " "};
        String[] names  = {"Pesel", "Nip", " "};
        internalDictionary(keys,names);
        return names;
    }

    public String[] CountriesInternalDictionary() throws InterruptedException {
        String[] keys = {"PL", "BE", "ES", "DE"};
        String[] names = {"Polska", "Belgia", "Hiszpania", "Niemcy"};
        internalDictionary(keys,names);
        return names;

        }

    public String[] internalDictionary(String[] keys, String[] names ) throws InterruptedException {
        WebElement radioButtonInternal = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'radio-group--inline')]/div/input"));
        WebElement changeDatas = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\'app\']/div[4]/div[2]/div[3]/div/div[1]/div[5]/div[2]/div[2]/div[2]/div/button"));
        if (radioButtonInternal.isSelected()) {
            changeDatas.click();
            WebElement table = DriverManager.getWebDriver().findElement(By.xpath("//table[contains(@class, 'dictionary-edit__table')]/tbody"));

            WebElement keyName;

            for (int i = 1; i <= keys.length; i++) {

                keyName = table.findElement(By.xpath("tr[" + i + "]/td[2]/div/input"));
                WebElement name = table.findElement(By.xpath("tr[" + i + "]/td[3]/div/input"));
                keyName.clear();
                keyName.sendKeys(keys[i-1]);
                name.clear();
                name.sendKeys(names[i-1]);
            }
            WebElement confirm = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'modal-buttons-actions')]/div[2]/button"));
            confirm.click();
            Thread.sleep(3000);

        } else{
            System.out.println("No");

        }
        return names;

    }

    public void displayValuesAsKeys() {
        WebElement valuesAsKeys = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'field-block field-section')]/div[4]/input"));
        valuesAsKeys.click();
    }

    public void useMultipleValues() {
        WebElement multipleValues = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'field-block field-section')]/div[3]/input"));
        multipleValues.click();
    }


    }
