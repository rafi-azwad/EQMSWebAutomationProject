package EQMSStepDefinition.ChangeControlStepDefinition;

import SearchPage.ChangeControlPage.ChangePlanPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ChangePlanStepDefinition {
    ChangePlanPage cpp;
    @When("select change plan")
    public void selectChangePlan() {
        cpp = new ChangePlanPage(driver);
        cpp.selectChangePlan();
    }

    @And("fill in the change plan information")
    public void fillInTheChangePlanInformation() throws InterruptedException {
        cpp.ccRecordNo();
        cpp.riskAssessment();
        cpp.changePlanSummary();
        cpp.selectFunctionalApproval();
        cpp.selectQualityApproval();
        
    }

    @Then("save and submit Change Plan's the information")
    public void saveAndSubmitChangePlanSTheInformation() throws InterruptedException {
        cpp.save();
        cpp.submit();
        cpp.closeChangeControl();

    }
}
