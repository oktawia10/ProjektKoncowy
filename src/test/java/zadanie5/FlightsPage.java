package zadanie5;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class FlightsPage extends BasePage {
    WebDriver driver;


    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cookyGotItBtn")
    WebElement cookies;
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
        cookies.click();
        flights.click();
        roundTrip.click();
        fromAirport.click();
        airportName.sendKeys(From);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        String xpathGuzika = "/html/body/div[18]/ul/li[1]/div";
        WebElement guzikOczekiwany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGuzika)));
        guzikOczekiwany.click();





        toAirport.click();
        airportTarget.sendKeys(To);
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        String xpathGuzika2 = "/html/body/div[19]/ul/li/div/span";
        WebElement guzikOczekiwany2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGuzika2)));
        guzikOczekiwany2.click();



        ClickClearSend(dateFrom, Departure);
        ClickClearSend(dateTo, Return);
        numbersOfPassengers.click();

        WebDriverWait wait4 = new WebDriverWait(driver, 40);
        String xpathGuzika4 = "sumManualPassenger";
        WebElement guzikOczekiwany4 = wait4.until(ExpectedConditions.elementToBeClickable(By.id(xpathGuzika4)));
        guzikOczekiwany4.click();

        System.out.print("test 2");
        //buttonGuest.click();
        buttonSearch.click();

        System.out.print("test 1 ");
        WebDriverWait wait3 = new WebDriverWait(driver, 40);
        String xpathGuzika3 = "//html/body/div[5]/div[4]/div[2]/div[3]/div[1]/div[3]/form/div/button/span";
        WebElement guzikOczekiwany3 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGuzika3)));
        guzikOczekiwany3.click();
        System.out.print("test 2");


    }


    @FindBy(xpath = "/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a")
    WebElement GuestBooking;

    @FindBy(id = "title")
    Select titleInput;

    @FindBy(xpath = "//*[@id=\"title\"]/option[1]")
    WebElement titleCheck;

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "surname")
    WebElement surnameInput;

    @FindBy(name = "email[]")
    WebElement emailInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "birthday")
    WebElement birthdayInput;

    @FindBy(name = "cardno[]")
    WebElement cardInput;

    @FindBy(id = "expiration")
    WebElement expirationInput;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    WebElement nationSerch;

    @FindBy(className = "select2-match")
    WebElement nationCheck;

    @FindBy(id = "cardtype")
    Select cardSerch;

    @FindBy(xpath = "//*[@id=\"cardtype\"]/option[5]")
    WebElement cardCheck;

    @FindBy(name = "card_no")
    WebElement cardNumberInput;

    @FindBy(id = "expiry-month")
    WebElement expiryMonth;

    @FindBy(xpath = "//*[@id=\"expiry-month\"]/option[3]")
    WebElement expMonthCheck;

    @FindBy(id = "expiry-year")
    WebElement expiryYear;

    @FindBy(xpath = "//*[@id=\"expiry-year\"]/option[5]")
    WebElement expYearCheck;

    @FindBy(name = "security_code")
    WebElement cvvCheck;

    @FindBy(id = "confirmBooking")
    WebElement CompleteBookingButton;


    public void enterWithParameters1(String Title, String Name, String Surname, String Email, String Phone, String Birthday, String Card_Number, String Expiration, String Nationality, String cardVisa, String CreditCardNb, String ExpiryYear, String ExpiryMonth, String CardCVV) throws IOException {

        GuestBooking.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        ClickClearSend(nameInput, Name);

        ClickClearSend(surnameInput, Surname);

        Select titleInput2= new Select(driver.findElement(By.id("title")));
        //List<WebElement> wel=titleInput2.getOptions();
        titleInput2.selectByVisibleText(Title);

        //((JavascriptExecutor)driver).executeScript("scroll(0,600)");
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", emailInput);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //titleInput.selectByVisibleText(Title);
        // emailInput.click();
        //  emailInput.sendKeys(Email);

        ClickClearSend(emailInput, Email);
        ClickClearSend(phoneInput, Phone);
        ClickClearSend(birthdayInput, Birthday);

        //ClickClearSend(nationCheck, Nationality);

        Select expiryYear2= new Select(driver.findElement(By.id("expiry-year")));
        //List<WebElement> wel=titleInput2.getOptions();
        expiryYear2.selectByVisibleText(ExpiryYear);

        Select ExpiryMonth2= new Select(driver.findElement(By.id("expiry-month")));
        //List<WebElement> wel=titleInput2.getOptions();
        ExpiryMonth2.selectByVisibleText(ExpiryMonth);


        ClickClearSend(cardInput, Card_Number);
        ClickClearSend(expirationInput, Expiration);
        Select cardSerch2= new Select(driver.findElement(By.id("cardtype")));
       // List<WebElement> wel2=cardSerch2.getOptions();
        cardSerch2.selectByVisibleText(cardVisa);/*
        for (WebElement w: wel){
            if (w.getText()==cardVisa) {w.click();}
            System.out.println (": "+ w.getText());
        }*/
        //cardSerch.selectByVisibleText(cardVisa);
        ClickClearSend(cardNumberInput, CreditCardNb);
        ClickClearSend(cvvCheck, CardCVV);

        File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("/tmp/dol.png"));

        CompleteBookingButton.click();


        /*WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).
                getScreenshotAs(OutputType.FILE);*/



// Now you can do whatever you need to do with it, for example somewhere

        driver.manage().window().maximize();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/gora.png"));


        System.out.print("!!!");



    }


}