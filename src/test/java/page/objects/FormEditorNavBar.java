package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormEditorNavBar  {

    private static String fileName = "src\\file\\chromedriver.exe";
    private HomePage homePage;
    private FormEditor formEditor;
    private FillingField fillingField;
    @FindBy(id="app")
    private WebElement homeIcon;

    @FindBy(id = "edit")
    private WebElement formEditorIcon;

    @FindBy(id="preview")
    private WebElement fillingFieldIcon;




    public FormEditorNavBar() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


    public HomePage goHome(){
        homeIcon.click();
        return this.homePage;
    }

    public void loadXSD(){
        String filePath = "C:\\FormEditor-Selenium\\schemat.xsd";
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'editor-upload-file')]//../div[1]/input")));
        DriverManager.getWebDriver().findElement(By.xpath("//input[1]")).sendKeys(filePath);

    }

    public FormEditor openFormEditor() {
        formEditorIcon.click();
        return new FormEditor();
    }

    public FillingField openFillingField() throws InterruptedException {
        fillingFieldIcon.click();
        return new FillingField();
    }

    public void saveFormEditor() throws InterruptedException {
        Thread.sleep(3000);
        WebElement download = DriverManager.getWebDriver().findElement(By.xpath("//div[contains(@class, 'row header__row')]/div[4]/div[2]"));
        download.click();
        Thread.sleep(3000);

    }

}
