package zadanie5;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class FlightsTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
    }

    @Test
    public void FlihgtsSearch() throws IOException {
        FlightsPage flightsPage = new FlightsPage(driver);
        BuyDataPage buyPage = new BuyDataPage(driver);
        flightsPage.searchWithParameters("Warsaw", "New York", "2019-08-10", "2019-08-15");
        buyPage.enterWithParameters("Ms.", "Jan", "Kot", "jankot@wp.pl", "666555111", "1980-01-01", "13456789", "2020-01-01", "Poland", "Visa", "38257074062409", "2020", "Oct (10)", "258");
    }

    @After
    public void tearDown() throws Exception {
        //  driver.quit(); zakomentowane zeby łatwiej sprawdzic w ktorym momencie test sie nie powiódł ;)
    }

}


