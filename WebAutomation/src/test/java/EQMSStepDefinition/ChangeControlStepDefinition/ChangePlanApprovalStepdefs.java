package EQMSStepDefinition.ChangeControlStepDefinition;

import SearchPage.ChangeControlPage.ChangePlanApprovalPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ChangePlanApprovalStepdefs {

    ChangePlanApprovalPage cpa;
    @When("select change plan approval")
    public void selectChangePlanApproval() {
        cpa = new ChangePlanApprovalPage(driver);
        cpa.selectChangePlanApproval();
    }

    @And("fill in the change plan approval information")
    public void fillInTheChangePlanApprovalInformation() {
        cpa.ccRecordNo();
        cpa.qualityApprovalComment();
        cpa.selectStatus();
    }

    @Then("save and submit change plan approval's the information")
    public void saveAndSubmitChangePlanApprovalSTheInformation() throws InterruptedException {
        cpa.saveAndSubmit();
    }
}
