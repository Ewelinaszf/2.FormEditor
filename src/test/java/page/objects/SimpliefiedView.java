package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SimpliefiedView {

    private SimpliefiedViewMainSection simpliefiedViewMainSection;
    private SimplifiedViewButtonActions simplifiedViewButtonActions;

    public SimpliefiedView() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
        this.simpliefiedViewMainSection = new SimpliefiedViewMainSection();
        this.simplifiedViewButtonActions = new SimplifiedViewButtonActions();
    }

    public SimpliefiedViewMainSection getSimpliefiedViewMainSection() throws InterruptedException {
        return this.simpliefiedViewMainSection;
    }

    public SimplifiedViewButtonActions getSimplifiedViewButtonActions() {
        return this.simplifiedViewButtonActions;
    }

}
