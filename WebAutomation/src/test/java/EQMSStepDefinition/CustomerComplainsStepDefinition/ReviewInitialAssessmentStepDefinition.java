package EQMSStepDefinition.CustomerComplainsStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.CustomerComplainPage.InitialAssessmentPage;
import SearchPage.CustomerComplainPage.ReviewInitialAssessmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ReviewInitialAssessmentStepDefinition {
    ReviewInitialAssessmentPage ri;
    InitialAssessmentPage ia;

    @When("select review initial assessment")
    public void selectReviewInitialAssessment() {
        ri = new ReviewInitialAssessmentPage(driver);
        ri.selectReviewOfInitialAssessment();

    }

    @And("fill in the required review of initial information")
    public void fillInTheRequiredReviewOfInitialInformation()  {

        ri.selectComplainNoAndStatus();
        ri.selectInvestigatorAndType();
        ScreenShotUtil.getScreenshot("ReviewOfInitialAssessment");

    }
}
