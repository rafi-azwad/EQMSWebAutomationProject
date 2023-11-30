package EQMSStepDefinition;

import SearchPage.InitialAssessmentPage;
import SearchPage.ReviewInitialAssessmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class ReviewInitialAssessmentStepDefinition {
    ReviewInitialAssessmentPage ri;
    InitialAssessmentPage ia;

    @When("select review initial assessment")
    public void selectReviewInitialAssessment() throws InterruptedException {
        ri = new ReviewInitialAssessmentPage(driver);
        ri.selectReviewOfInitialAssessment();

    }

    @And("fill in the required review of initial information")
    public void fillInTheRequiredReviewOfInitialInformation() throws InterruptedException {

        ri.selectComplainNoAndStatus();
        ri.selectInvestigatorAndType();
        ri.selectInvestigatorAndType1();
    }
}
