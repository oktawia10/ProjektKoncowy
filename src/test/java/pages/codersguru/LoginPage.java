package pages.codersguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super (driver);
    }

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"_submit\"]")
    WebElement loginButton;

    public void loginWithCredentials(String name, String password) {
        //userName.sendKeys(name);
        //passwordInput.sendKeys(password);

        ClickClearSend(userName, name);
        ClickClearSend(passwordInput, password);
        loginButton.click();
    }


    // konstruktor i inicjalic=zacja pageFactory
    //znajdzie elenmenty za pomoca findby

    //napszcie metody które wpisuja uzytkownika i hasło i klikaja login

}
