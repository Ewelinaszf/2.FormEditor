package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpliefiedViewMainSection {

    private SimpliefiedView simpliefiedView;

    @FindBy(xpath="//div[contains(@class, 'wcag-display-value')]")
    private WebElement windowWithEnteredValue;

    public SimpliefiedViewMainSection( ) {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String[] readData() {
        String splited = windowWithEnteredValue.getText().replaceAll(" ","");
        String[] splitedArray = null;
        splitedArray = splited.split(",");
        return splitedArray;
    }

    public SimpliefiedView goToSimpiefiedView() {
        return simpliefiedView;
    }

}
