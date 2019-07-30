package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void ClickClearSend(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void enterUserData(String email, String imie, String nazwisko, String haslo, String powtorzHaslo, String miasto, String kodPocztowy, String ulica, String numerDomuLokalu) {
    }
}