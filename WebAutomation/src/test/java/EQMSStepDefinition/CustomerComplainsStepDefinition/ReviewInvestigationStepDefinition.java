package EQMSStepDefinition.CustomerComplainsStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.CustomerComplainPage.ReviewInvestigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ReviewInvestigationStepDefinition {
    ReviewInvestigationPage rp;
    @When("select review investigation")
    public void selectReviewInvestigation() {
        rp = new ReviewInvestigationPage(LoginStepDefinition.driver);
        rp.selectReviewInvestigation();
        
    }

    @And("fill in the required review investigation information")
    public void fillInTheRequiredReviewInvestigationInformation() throws InterruptedException {
        rp.selectComplainNoAndStatus();
        rp.furtherStatus();
        rp.approvedStatus();
        rp.selectFunctionalApproval();
        rp.selectQualityApproval();
        ScreenShotUtil.getScreenshot("reviewInvestigation");


    }
}
