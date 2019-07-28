package Zadanie6;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "/home/oktawia/Pulpit/ProjektKoncowy/src/test/java/Zadanie6",
        plugin = {"pretty","html:out"})
public class KatalonFormStepsTest {
}