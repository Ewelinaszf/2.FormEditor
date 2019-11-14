package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillingFieldButtonActions {

    @FindBy(xpath = "//button[contains(text(), ' Podgląd uproszczony ')]")
    private WebElement simplifiedPreview;

    private SimpliefiedView simpliefiedView;

    public FillingFieldButtonActions() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }

    public SimpliefiedView openSimplifiedPreview() throws InterruptedException {
        simplifiedPreview.click();
        return new SimpliefiedView();
    }

}
