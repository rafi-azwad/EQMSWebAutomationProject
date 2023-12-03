package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features/01_login.feature"},
        tags = "@login",
        glue = {"EQMSStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/loginFeature.html",
               // "json:build/reports/allFeature.json"

        })

@Test
public class LoginRunnerTest extends AbstractTestNGCucumberTests {


}