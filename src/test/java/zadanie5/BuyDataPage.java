package zadanie5;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
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

public class BuyDataPage extends BasePage {
    WebDriver driver;

    public BuyDataPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a")
    WebElement GuestBooking;

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

    @FindBy(xpath = "/html/body/div[5]/form/div/div[1]/div[2]/section/div/div[9]/div/div/a/span[1]")
    WebElement nationSerch;

    @FindBy(className = "select2-input")
    WebElement nationCheck;

    @FindBy(name = "card_no")
    WebElement cardNumberInput;

    @FindBy(name = "security_code")
    WebElement cvvCheck;

    @FindBy(id = "confirmBooking")
    WebElement CompleteBookingButton;


    public void enterWithParameters(String Title, String Name, String Surname, String Email, String Phone, String Birthday, String Card_Number, String Expiration, String Nationality, String cardVisa, String CreditCardNb, String ExpiryYear, String ExpiryMonth, String CardCVV) throws IOException {

        GuestBooking.click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        ClickClearSend(nameInput, Name);
        Assert.assertEquals("field is empty", nameInput.getText(), "");

        ClickClearSend(surnameInput, Surname);
        Assert.assertEquals("field is empty", surnameInput.getText(), "");

        Select titleInput = new Select(driver.findElement(By.id("title")));
        titleInput.selectByVisibleText(Title);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ClickClearSend(emailInput, Email);
        Assert.assertEquals("field is empty", emailInput.getText(), "");

        ClickClearSend(phoneInput, Phone);
        Assert.assertEquals("field is empty", phoneInput.getText(), "");

        ClickClearSend(birthdayInput, Birthday);
        Assert.assertEquals("field is empty", birthdayInput.getText(), "");

        Select expiryYear = new Select(driver.findElement(By.id("expiry-year")));
        expiryYear.selectByVisibleText(ExpiryYear);

        Select expiryMonth = new Select(driver.findElement(By.id("expiry-month")));
        expiryMonth.selectByVisibleText(ExpiryMonth);

        ClickClearSend(cardInput, Card_Number);
        Assert.assertEquals("field is empty", cardInput.getText(), "");

        ClickClearSend(expirationInput, Expiration);
        Assert.assertEquals("field is empty", expirationInput.getText(), "");

        nationSerch.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        nationCheck.sendKeys(Nationality.toUpperCase());
        nationCheck.sendKeys((Keys.ENTER));

        Select cardSerch = new Select(driver.findElement(By.id("cardtype")));
        cardSerch.selectByVisibleText(cardVisa);

        ClickClearSend(cardNumberInput, CreditCardNb);
        Assert.assertEquals("field is empty", cardNumberInput.getText(), "");

        ClickClearSend(cvvCheck, CardCVV);
        Assert.assertEquals("field is empty", cvvCheck.getText(), "");

        File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("/tmp/dol.png"));

        CompleteBookingButton.click();

        WebDriverWait waitpop = new WebDriverWait(driver, 10);
        Alert alert = waitpop.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        driver.manage().window().maximize();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/gora.png"));

    }
}
