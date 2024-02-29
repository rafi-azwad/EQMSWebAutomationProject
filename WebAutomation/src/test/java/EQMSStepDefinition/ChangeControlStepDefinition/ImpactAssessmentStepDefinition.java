package EQMSStepDefinition.ChangeControlStepDefinition;

import SearchPage.ChangeControlPage.ImpactAssessmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ImpactAssessmentStepDefinition {

    ImpactAssessmentPage iap;
    @When("select impact assessment")
    public void selectImpactAssessment() {
       iap = new ImpactAssessmentPage(driver);
       iap.selectImpactAssessment();
    }

    @And("fill in the impact assessment information")
    public void fillInTheImpactAssessmentInformation() {
        iap.ccRecordNo();
        iap.riskAssessment();
    }

    @Then("save and submit impact assessment's the information")
    public void saveAndSubmitImpactAssessmentSTheInformation() throws InterruptedException {
        iap.saveAndSubmit();
    }
}
