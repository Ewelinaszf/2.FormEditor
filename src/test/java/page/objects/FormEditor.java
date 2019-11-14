package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FormEditor {
    private HomePage homePage;
    private FormEditorNavBar formEditorNavBar;
    private FormEditorMainSection formEditorMainSection;
    private FormEditorRightSectionBar formEditorRightSectionBar;

    public FormEditor() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
        this.formEditorMainSection = new FormEditorMainSection();
        this.formEditorRightSectionBar = new FormEditorRightSectionBar();
        this.formEditorNavBar = new FormEditorNavBar();
    }

    public FormEditorMainSection getFormEditorMainSection() {
        return this.formEditorMainSection;
    }

    public FormEditorNavBar getFormEditorNavBar() {
        return formEditorNavBar;
    }

    public FormEditorRightSectionBar getFormEditorRightSectionBar() {
        return formEditorRightSectionBar;
    }
}
