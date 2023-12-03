package EQMSStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.InitialAssessmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class InitialAssessmentStepDefinition {
    InitialAssessmentPage ia;


    @When("select initial assessment")
    public void selectInitialAssessment() throws InterruptedException {
        ia =new InitialAssessmentPage(driver);
        ia.clickInitialAssessment();

    }

    @And("fill in the required initial information")
    public void fillInTheRequiredInitialInformation() throws InterruptedException {
        ia.selectComplainNoAndStatus();
        ScreenShotUtil.getScreenshot("InitialAssessment");

    }
}
