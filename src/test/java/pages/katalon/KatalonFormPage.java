package pages.katalon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KatalonFormPage {
    WebDriver driver;

    public KatalonFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="first-name")
    WebElement firstName;

    @FindBy(id="last-name")
    WebElement lastName;

    public void enterUserData(String first, String last){
        // tą metodę trzeba rozszerzyć o pozostałe pola
        // data urodzenia, etc...
        firstName.sendKeys(first);
        lastName.sendKeys(last);
    }

}