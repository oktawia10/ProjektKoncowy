package zadanie2;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;
import pages.codersguru.RegisterPage;


public class RegisterUserFormSteps {
    WebDriver driver;


    @Given("^I am on webside \"([^\"]*)\" and click button \"([^\"]*)\"$")
    public void iAmOnWebsideAndClickButton(String arg0, String arg1) throws Throwable {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(arg0);
        WebElement registerButton= driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        registerButton.click();

    }

    @And("^registration form opens \"([^\"]*)\"$")
    public void registrationFormOpens(String arg0) throws Throwable {
 System.out.println("tekst");

    }


    @When("^I register user with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and click button \"([^\"]*)\"$")
    public void iRegisterUserWithAndClick(String email, String name, String surname, String password, String repeatpass, String city, String zipCode, String street, String locNumber, boolean checkb, String button) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RegisterPage register = new RegisterPage(driver);
        register.enterUserData(email, name, surname, password, repeatpass, city, zipCode, street, locNumber, checkb, button);
    }

    @Then("^User is successfully registeed$")
    public void userIsSuccessfullyRegisteed() {
        System.out.println("test proc");
        WebElement namelog = driver.findElement(By.id("user-name"));
        System.out.println(namelog.getText() + "!");
    }



}

