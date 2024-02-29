package EQMSStepDefinition.ChangeControlStepDefinition;

import SearchPage.ChangeControlPage.ChangePlanFunctionalApprovalPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ChangePlanFunctionalApprovalStepdefs {

    ChangePlanFunctionalApprovalPage cpf;
    @When("select change plan functional approval")
    public void selectChangePlanFunctionalApproval() {
        cpf = new ChangePlanFunctionalApprovalPage(driver);
        cpf.selectChangePlanFunctionalApproval();
    }

    @And("fill in the change plan functional approval information")
    public void fillInTheChangePlanFunctionalApprovalInformation() {
        cpf.ccRecordNo();
        cpf.functionalApprovalComment();
        cpf.selectStatus();
    }

    @Then("save and submit change plan functional approval's the information")
    public void saveAndSubmitChangePlanFunctionalApprovalSTheInformation() throws InterruptedException {
        cpf.saveAndSubmit();
    }
}
