package EQMSStepDefinition.ChangeControlStepDefinition;

import SearchPage.ChangeControlPage.ReviewOfProposedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ReviewOfProposedChangeStepDefinition {

    ReviewOfProposedPage rpp;
    @When("select review of proposed change")
    public void selectReviewOfProposedChange() {
        rpp = new ReviewOfProposedPage(driver);
        rpp.clickReviewOfProposed();
    }

    @And("fill in the review of proposed change information")
    public void fillInTheReviewOfProposedChangeInformation() throws InterruptedException {
        rpp.ccRecordNo();
        rpp.reviewerComment();
        rpp.furtherInformationRequired();
        rpp.reviseFromDraft();
        rpp.approval();
        rpp.coordinator();
        rpp.selectImpactAssessor();
    }

    @Then("save and submit review of proposed change's the information")
    public void saveAndSubmitReviewOfProposedChangeSTheInformation() throws InterruptedException {
        rpp.save();
        rpp.submit();
        rpp.closeChangeControl();
    }
}
