package zadanie2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.codersguru.RegisterPage;


public class RegisterUserFormSteps {
    WebDriver driver;
    String name2;

    @Given("^I am on webside \"([^\"]*)\" and click button \"([^\"]*)\"$")
    public void iAmOnWebsideAndClickButton(String arg0, String arg1) throws Throwable {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(arg0);
        WebElement registerButton = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        registerButton.click();
    }

    @And("^registration form opens \"([^\"]*)\"$")
    public void registrationFormOpens(String arg0) throws Throwable {
    }


    @When("^I register user with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and click button \"([^\"]*)\"$")
    public void iRegisterUserWithAndClick(String email, String name, String surname, String password, String repeatpass, String city, String zipCode, String street, String locNumber, boolean checkb, String button) throws Throwable {
        RegisterPage register = new RegisterPage(driver);
        name2 = name;
        register.enterUserData(email, name, surname, password, repeatpass, city, zipCode, street, locNumber, checkb, button);
    }

    @Then("^User is successfully registered$")
    public void userIsSuccessfullyRegistered() {
        Assert.assertTrue("BŁĄD! Nie udało się dostać na stronę potwierdzającą rejestrację!", driver.getCurrentUrl().contains("confirmed"));
        WebElement namelog = driver.findElement(By.id("user-name")); /* jesteśmy na stronie - pole istnieje */
        Assert.assertEquals("BŁĄD! Nazwa użytkownika nie zgadza się z tą podaną przy rejestracji!", name2, namelog.getText());
    }


}

