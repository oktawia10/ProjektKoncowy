package zadanie1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.codersguru.LoginPage;

public class LoginTest {
    WebDriver driver;

    // metoda before do napisania
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tester.codersguru.pl/login");
    }

    @Test
    public void TestLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("test@wp.pl", "hgjgjgjgjgjg");

    }

    @After
    public void tearDown() {
        //driver.quit();

    }
}

//@Testpublic testProperLogin(){
// LoginPage loginPage = new LoginPage();
//} // do napisania metoda która loguje sie poprawnym uzytkownikiem i poprawnym hasłem


//metoda after do napisania