package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimplifiedViewButtonActions{
    private FillingField fillingField;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-primary')]")
    private WebElement fillingViewButton;

    @FindBy(xpath="//*[@id='app']/div[4]/div[2]/div/div/div[1]/div[1]/a/button")
    private WebElement returnToFillingField;

    public SimplifiedViewButtonActions() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public FillingField openFillingField() {
        fillingViewButton.click();
        return new FillingField();
    }

    public FillingField returnToFillingField(){
        returnToFillingField.click();
        return new FillingField();
    }
}