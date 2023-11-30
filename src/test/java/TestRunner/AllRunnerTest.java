package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/Features"},
        tags = "@login or @complainRaise or @initialAssessment or @reviewInitialAssessment",
        glue = {"EQMSStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/allFeature.html"
        })

@Test
public class AllRunnerTest extends AbstractTestNGCucumberTests {


}
