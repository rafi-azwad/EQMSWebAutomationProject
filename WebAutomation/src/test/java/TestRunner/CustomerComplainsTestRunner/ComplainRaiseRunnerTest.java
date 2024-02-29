package TestRunner.CustomerComplainsTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/eQMSFeatureFiles/"},
        tags = "@login or @complainRaise",
        glue = {"EQMSStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/complainRaiseFeature.html"
        })

@Test
public class ComplainRaiseRunnerTest extends AbstractTestNGCucumberTests {


}