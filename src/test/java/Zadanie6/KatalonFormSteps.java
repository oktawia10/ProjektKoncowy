package Zadanie6;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.katalon.KatalonFormPage;

public class KatalonFormSteps {
    WebDriver driver;

    @Given("^I am on website \"([^\"]*)\"$")
    public void iAmOnWebiste(String arg0) throws Throwable {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(arg0);

    }

    @When("^I register user with \"([^\"]*)\" \"([^\"]*)\"$")
    public void iRegisterUserWith(String name, String lastName) throws Throwable {
//        WebElement firstName = driver.findElement(By.id("first-name"));
//        firstName.sendKeys(name);
//        WebElement lastNameElement = driver.findElement(By.id("last-name"));
//        lastNameElement.sendKeys(lastName);
        // to samo można napisać z użyciem PageObjectPattern
        KatalonFormPage katalon = new KatalonFormPage(driver);
        katalon.enterUserData(name, lastName);
    }

    @Then("^User is successfully registered$")
    public void userIsSuccessfullyRegistered() {
        //
    }
}