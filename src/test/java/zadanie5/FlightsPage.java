package zadanie5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;


public class FlightsPage extends BasePage {
    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"body-section\"]/section/div[2]/div/div/div[2]/ul/li[2]/a/i")
    WebElement flights;

    @FindBy(xpath = "//*[@id=\"thflights\"]/div[9]/div[2]/div/label")
    WebElement roundTrip;

    @FindBy(id = "s2id_origin")
    WebElement fromAirport;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    WebElement airportName;

    // @FindBy(xpath = "/html/body/div[18]/ul/li[1]/div")
    //WebElement airportCheck;

    @FindBy(id = "s2id_destination")
    WebElement toAirport;

    @FindBy(xpath = "/html/body/div[19]/div/input")
    WebElement airportTarget;

    @FindBy(id = "departure")
    WebElement dateFrom;

    @FindBy(id = "arrival")
    WebElement dateTo;

    @FindBy(xpath = "//*[@id=\"thflights\"]/div[5]/div/input")
    WebElement numbersOfPassengers;

    @FindBy(id = "sumManualPassenger")
    WebElement buttonGuest;

    @FindBy(xpath = "//*[@id=\"thflights\"]/div[6]/button")
    WebElement buttonSearch;

    public void searchWithParameters(String From, String To, String Departure, String Return) {

        flights.click();
        roundTrip.click();
        fromAirport.click();
        airportName.sendKeys(From);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        String xpathGuzika = "/html/body/div[18]/ul/li[1]/div";
        WebElement guzikOczekiwany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGuzika)));
        guzikOczekiwany.click();

        toAirport.click();
        airportTarget.sendKeys(To);

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        String xpathGuzika2 = "/html/body/div[19]/ul/li/div/span";
        WebElement guzikOczekiwany2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGuzika2)));
        guzikOczekiwany2.click();

        ClickClearSend(dateFrom, Departure);
        ClickClearSend(dateTo, Return);
        numbersOfPassengers.click();
        buttonGuest.click();
        buttonSearch.click();

        System.out.print("test 1 ");
        WebDriverWait wait3 = new WebDriverWait(driver, 15);
        String xpathGuzika3 = "//html/body/div[5]/div[4]/div[2]/div[3]/div[1]/div[3]/form/div/button/span";
        WebElement guzikOczekiwany3 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGuzika3)));
        guzikOczekiwany3.click();
        System.out.print("test 2");



    }

    @FindBy(xpath = "/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a")
    WebElement GuestBooking;

    @FindBy(xpath = "//*[@id=\"title\"]")
    WebElement titleInput;

    @FindBy(xpath = "//*[@id=\"title\"]/option[1]")
    WebElement titleCheck;

    @FindBy(id="name")
    WebElement nameInput;

    @FindBy(id="surname")
    WebElement surnameInput;

    @FindBy(id="email")
    WebElement emailInput;

    @FindBy(id="phone")
    WebElement phoneInput;

    @FindBy(id="birthday")
    WebElement birthdayInput;

    @FindBy(id="cardno")
    WebElement cardInput;

    @FindBy(id="expiration")
    WebElement expirationInput;

    @FindBy(xpath="//*[@id=\"select2-drop\"]/div/input")
    WebElement nationSerch;

    @FindBy(className = "select2-match")
    WebElement nationCheck;

    @FindBy(id= "cardtype")
    WebElement cardSerch;

    @FindBy(xpath ="//*[@id=\"cardtype\"]/option[5]")
    WebElement cardCheck;

    @FindBy(id= "card-number")
    WebElement cardNumberInput;

    @FindBy(id= "expiry-month")
    WebElement expiryMonth;

    @FindBy(xpath= "//*[@id=\"expiry-month\"]/option[3]")
    WebElement expMonthCheck;

    @FindBy(id="expiry-year")
    WebElement expiryYear;

    @FindBy(xpath ="//*[@id=\"expiry-year\"]/option[5]" )
    WebElement expYearCheck;

    @FindBy(name="security_code")
    WebElement cvvCheck;

    @FindBy(id="confirmBooking")
    WebElement CompleteBookingButton;


    public void enterWithParameters1(String Name, String Surname, String Email, String Phone, String Birthday, String Card_Number, String Expiration, String Nationality, String CreditCardNb, String CardCVV) {

        GuestBooking.click();
        titleInput.click();
        titleCheck.click();



    }
}