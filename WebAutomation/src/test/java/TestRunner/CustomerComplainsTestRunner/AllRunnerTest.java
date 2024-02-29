package TestRunner.CustomerComplainsTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/eQMSFeatureFiles"},
        tags = "@login or @complainRaise or @initialAssessment or @reviewInitialAssessment or @investigation " +
                "or @reviewInvestigation or @functionalApproval or @qualityApproval or @CAPAStatusReview or @complainStatus",

        glue = {"EQMSStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/allFeature.html",
                //"json:build/reports/allFeature.json"
        })

@Test
public class AllRunnerTest extends AbstractTestNGCucumberTests {


}
