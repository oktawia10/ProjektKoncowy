package zadanie5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class BuyerDataPage extends BasePage {
    WebDriver driver;

    public BuyerDataPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

    /*@FindBy(xpath = "/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a")
    WebElement GuestBooking;


    /*public void enterWithParameters(String Name, String Surname, String Email, String Phone, String Birthday, String Card_Number, String Expiration, String Nationality, String CreditCardNb, String CardCVV) {

        GuestBooking.click();



    }
}*/

