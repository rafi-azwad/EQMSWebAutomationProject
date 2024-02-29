package TestRunner.CustomerComplainsTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/eQMSFeatureFiles/"},
        tags = "@login or @reviewInitialAssessment",
        glue = {"EQMSStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/reviewInitialAssessmentFeature.html"
        })

@Test
public class ReviewInitialAssessmentRunnerTest extends AbstractTestNGCucumberTests {


}
