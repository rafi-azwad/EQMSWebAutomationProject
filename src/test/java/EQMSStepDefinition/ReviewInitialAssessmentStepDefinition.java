package EQMSStepDefinition;

import Core.ScreenRecorderUtil;
import Core.ScreenShotUtil;
import SearchPage.InitialAssessmentPage;
import SearchPage.ReviewInitialAssessmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

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
