package TestRunner.ChangeControlTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/eQMSFeatureFiles/"},
        tags = "@login or @raiseChangeControl or @reviewOfProposedChange",
        glue = {"EQMSStepDefinition"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty", "html:build/reports/reviewOfProposedFeature.html"
        })

@Test
public class ReviewOfProposedChangeRunnerTest extends AbstractTestNGCucumberTests {


}

