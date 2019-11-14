package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageNavBar {

    @FindBy(xpath="//button[contains(@class, 'btn btn-secondary')]")
    private WebElement logOut;


    public HomePageNavBar(WebDriver driver) {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

  //  public Page logOut() {
   //     this.logOut.click();
   //     return this.page;

  //  }
}
