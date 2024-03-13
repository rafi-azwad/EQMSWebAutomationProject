package EQMSStepDefinition.ChangeControlStepDefinition;

import SearchPage.ChangeControlPage.ImplementationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ImplementationStepdefs {

    ImplementationPage ip;
    @When("select implementation")
    public void selectImplementation() {
        ip = new ImplementationPage(driver);
        ip.selectImplementation();

    }

    @And("fill in the implementation information")
    public void fillInTheImplementationInformation() throws InterruptedException {
        ip.ccRecordNo();
        ip.selectStatus();
        ip.selectAttachment();
        ip.selectQualityFinalReviewer();
    }

    @Then("save and submit implementation's the information")
    public void saveAndSubmitImplementationSTheInformation() throws InterruptedException {
        ip.save();
        ip.submit();
        ip.closeChangeControl();
    }
}
