package pages.katalon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KatalonFormPage {
    WebDriver driver;

    public KatalonFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "dob")
    WebElement dateOfBirth;

    @FindBy(id = "adress")
    WebElement address;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "comment")
    WebElement comment;

    public void enterUserData(String first, String last, String date, String adress, String myemail, String mypassword, String mycompany, String mycomment) {
        // tą metodę trzeba rozszerzyć o pozostałe pola
        // data urodzenia, etc...
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        dateOfBirth.sendKeys(date);
        address.sendKeys(adress);
        email.sendKeys(myemail);
        password.sendKeys(mypassword);
        company.sendKeys(mycompany);
        comment.sendKeys(mycomment);
    }

}