package zadanie5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

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

    @FindBy(xpath = "//*[@id=\"thflights\"]/div[6]/button")
    WebElement buttonSearch;

    public void searchWithParameters(String From, String To, String Departure, String Return) {
        cookies.click();
        flights.click();
        roundTrip.click();
        fromAirport.click();
        airportName.sendKeys(From);

        WebDriverWait waitFrom = new WebDriverWait(driver, 20);
        String xpathAirportFrom = "/html/body/div[18]/ul/li[1]/div";
        WebElement airportFrom = waitFrom.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathAirportFrom)));
        airportFrom.click();

        toAirport.click();

        airportTarget.sendKeys(To);

        WebDriverWait waitTo = new WebDriverWait(driver, 20);
        String xpathAirportTo = "/html/body/div[19]/ul/li/div/span";
        WebElement toAirport = waitTo.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathAirportTo)));
        toAirport.click();

        ClickClearSend(dateFrom, Departure);
        ClickClearSend(dateTo, Return);
        numbersOfPassengers.click();

        WebDriverWait waitSum = new WebDriverWait(driver, 40);
        String sumPassenger = "sumManualPassenger";
        WebElement numberPass = waitSum.until(ExpectedConditions.elementToBeClickable(By.id(sumPassenger)));
        numberPass.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        buttonSearch.click();

        WebDriverWait book = new WebDriverWait(driver, 40);
        String xpathBookNow = "//html/body/div[5]/div[4]/div[2]/div[3]/div[1]/div[3]/form/div/button/span";
        WebElement bookNow = book.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBookNow)));
        bookNow.click();

    }

}