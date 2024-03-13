package EQMSStepDefinition.ChangeControlStepDefinition;

import Core.ScreenRecorderUtil;
import SearchPage.ChangeControlPage.QualityFinalReviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class QualityFinalReviewStepdefs {

    QualityFinalReviewPage qfr;
    @When("select quality final review")
    public void selectQualityFinalReview() {
        qfr = new QualityFinalReviewPage(driver);
        qfr.selectQualityFinalReviewPage();
    }

    @And("fill in the quality final review information")
    public void fillInTheQualityFinalReviewInformation() throws InterruptedException {
       qfr.ccRecordNo();
       qfr.reviewSummary();
       qfr.selectStatus();
    }

    @Then("save and submit quality final review's the information")
    public void saveAndSubmitQualityFinalReviewSTheInformation() throws InterruptedException {
        qfr.save();
        qfr.submit();
        qfr.closeChangeControl();
        ScreenRecorderUtil.stopRecord();

    }
}
