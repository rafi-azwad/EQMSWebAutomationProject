package EQMSStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.ReviewInvestigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class ReviewInvestigationStepDefinition {
    ReviewInvestigationPage rp;
    @When("select review investigation")
    public void selectReviewInvestigation() {
        rp = new ReviewInvestigationPage(driver);
        rp.selectReviewInvestigation();
        
    }

    @And("fill in the required review investigation information")
    public void fillInTheRequiredReviewInvestigationInformation() throws InterruptedException {
        rp.selectComplainNoAndStatus();
        rp.selectFunctionalApproval();
        rp.selectQualityApproval();
        ScreenShotUtil.getScreenshot("reviewInvestigation");


    }
}
