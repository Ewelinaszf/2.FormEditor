package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FillingField  {
    private HomePage homePage;
    private FillingFieldMainSection fillingFieldMainSection;
    private FillingFieldButtonActions fillingFieldButtonActions;
    private FormEditorNavBar formEditorNavBar;

    public FillingField() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
        this.fillingFieldButtonActions = new FillingFieldButtonActions();
        this.fillingFieldMainSection = new FillingFieldMainSection();
        this.formEditorNavBar = new FormEditorNavBar();

    }


    public FillingFieldMainSection getFillingFieldMainSection() {
        return new FillingFieldMainSection();
    }

    public FillingFieldButtonActions getFillingFieldButtonActions() {
        return this.fillingFieldButtonActions;
    }

    public FormEditorNavBar getFormEditorNavBar() { return this.formEditorNavBar; }
}
