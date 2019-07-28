package pages.katalon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(name = "gender")
    List<WebElement> genders;

    @FindBy(id = "dob")
    WebElement dateOfBirth;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "role")
    WebElement role;

    @FindBy(id = "expectation")
    WebElement expectation;

    @FindBy(xpath= "/html/body/div/div/form/div[11]/div")
    WebElement WaysOfDevelopment;

    @FindBy(id = "comment")
    WebElement comment;

    @FindBy (id="submit")
    WebElement submit;

    public void enterUserData(String first, String last, String mygender, String date, String adress, String myemail, String mypassword, String mycompany, String myrole, String myexpectation, String ways, String mycomment) {
        // tą metodę trzeba rozszerzyć o pozostałe pola
        // data urodzenia, etc...
        firstName.sendKeys(first);
        lastName.sendKeys(last);

        // przerobiony kod z przykładów i dodane znalezione porównanie stringów
        for (WebElement w : genders) {
            WebElement genderLabel = w.findElement(By.xpath("./.."));

            if (mygender.toUpperCase().equals(genderLabel.getText().toUpperCase())) {
                w.click();
            }
        }
        dateOfBirth.sendKeys(date);
        address.sendKeys(adress);
        email.sendKeys(myemail);
        password.sendKeys(mypassword);
        company.sendKeys(mycompany);
        role.sendKeys(myrole);
        expectation.sendKeys(myexpectation);

        List<WebElement> checkbox2Elements = WaysOfDevelopment.findElements(By.xpath(".//input"));
        for (WebElement a: checkbox2Elements) {
            WebElement checkboxLabel = a.findElement(By.xpath("./.."));
            if (ways.toUpperCase().equals(checkboxLabel.getText().toUpperCase())) {
                a.click();
            }
        }
        comment.sendKeys(mycomment);


        submit.click();
    }

}