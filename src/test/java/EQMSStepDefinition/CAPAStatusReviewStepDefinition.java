package EQMSStepDefinition;

import Core.ScreenRecorderUtil;
import Core.ScreenShotUtil;
import SearchPage.CAPAStatusReviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class CAPAStatusReviewStepDefinition {

    CAPAStatusReviewPage cp;
    @When("select capa status review")
    public void selectCapaStatusReview() {
        cp = new CAPAStatusReviewPage(driver);
        cp.selectCAPAStatusReview();
    }

    @And("fill in the required capa status review information")
    public void fillInTheRequiredCapaStatusReviewInformation() {
        cp.selectComplainNo();
        cp.correctionAction();
        cp.preventionAction();
        ScreenShotUtil.getScreenshot("capaStatusReview");


    }
}
