package runners;

import org.junit.runner.RunWith;
//import io.cucumber.c
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/MethodsTest.feature")
public class MethodRunner {

}
