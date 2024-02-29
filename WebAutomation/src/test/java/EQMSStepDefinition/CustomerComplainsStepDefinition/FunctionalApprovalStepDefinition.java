package EQMSStepDefinition.CustomerComplainsStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.CustomerComplainPage.FunctionalApprovalPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class FunctionalApprovalStepDefinition {

    FunctionalApprovalPage fp;
    @When("select functional approval")
    public void selectFunctionalApproval() {
        fp = new FunctionalApprovalPage(driver);
        fp.clickFunctionalApproval();

    }

    @And("fill in the required functional approval information")
    public void fillInTheRequiredFunctionalApprovalInformation() {
        fp.selectComplainNoAndStatus();
        ScreenShotUtil.getScreenshot("functionalApproval");

    }
}
