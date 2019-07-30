package pages.codersguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class RegisterPage extends BasePage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id= "fos_user_registration_form_email")
    WebElement email;

    @FindBy(id = "fos_user_registration_form_name")
    WebElement name;

    @FindBy(id = "fos_user_registration_form_lastname")
    WebElement surname;

    @FindBy(id = "fos_user_registration_form_plainPassword_first")
    WebElement password;

    @FindBy(id = "fos_user_registration_form_plainPassword_second")
    WebElement repeatpass;

    @FindBy(id = "form_city")
    WebElement city;

    @FindBy(id = "form_postal_code")
    WebElement zipCode;

    @FindBy(id = "form_street")
    WebElement street;

    @FindBy(id = "form_number")
    WebElement locNumber;

    @FindBy( xpath= "//*[@id=\"registration-main-form\"]/div[12]/input")
    WebElement checkx;


    @FindBy(id = "register-submit-btn")
    WebElement register;

    public void enterUserData(String userEmail, String userName, String userSurname, String userPassword, String userRepeatpass, String userCity, String userZipCode, String userStreet, String userLocNumber, boolean checkb, String button) {
        // tą metodę trzeba rozszerzyć o pozostałe pola
        // data urodzenia, etc...
        email.sendKeys(userEmail);
        name.sendKeys(userName);
        surname.sendKeys(userSurname);
        password.sendKeys(userPassword);
        repeatpass.sendKeys(userRepeatpass);
        city.sendKeys(userCity);
        zipCode.sendKeys(userZipCode);
        street.sendKeys(userStreet);
        locNumber.sendKeys(userLocNumber);
        System.out.println(checkb);
        if (checkb==true){
            checkx.click();
        }
        register.click();

    }



    // konstruktor i inicjalic=zacja pageFactory
    //znajdzie elenmenty za pomoca findby

    //napszcie metody które wpisuja uzytkownika i hasło i klikaja login {

    // analogicznie jk login page
}
