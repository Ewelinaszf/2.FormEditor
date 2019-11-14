package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class HomePage {

    @FindBy(xpath = "//*[text()='Utwórz nowy formularz']")
    public WebElement createNewForm;

    @FindBy(xpath="//input[@type='text']")
    private WebElement PIT_37;

    @FindBy(xpath="//button[contains(@class,'button')]")
    private WebElement confirm;
    private WebDriver driver;

    public HomePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }



    public FormEditor createNewForm(String name) {
        createNewForm.click();
        PIT_37.sendKeys(name);
        confirm.click();
        return new FormEditor();
    }

    public void loadAnExistingForm(){

    }

    public void openExternalDictionaries(){

    }


    public String generateName() {
        Random r = new Random();
        int number = r.nextInt(99);
        String name = "PIT-"+String.valueOf(number);
        return name;
    }
}
