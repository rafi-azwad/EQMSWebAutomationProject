package TestRunner.ChangeControlTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/eQMSFeatureFiles/"},
        tags = "@login or @raiseChangeControl or @reviewOfProposedChange or @impactAssessment or @changePlan " +
                "or @changePlanFunctionalApproval or @changePlanApproval or  @implementation",
        glue = {"EQMSStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/implementationFeature.html"
        })

@Test
public class ImplementationRunnerTest extends AbstractTestNGCucumberTests {


}

