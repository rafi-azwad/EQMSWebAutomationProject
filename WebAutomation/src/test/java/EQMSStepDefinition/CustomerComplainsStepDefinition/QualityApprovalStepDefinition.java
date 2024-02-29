package EQMSStepDefinition.CustomerComplainsStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.CustomerComplainPage.QualityApprovalPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class QualityApprovalStepDefinition {
    QualityApprovalPage qp;
    @When("select quality approval")
    public void selectQualityApproval() {
        qp = new QualityApprovalPage(LoginStepDefinition.driver);
        qp.clickQualityApproval();

    }

    @And("fill in the required quality approval information")
    public void fillInTheRequiredQualityApprovalInformation() {
        qp.selectComplainNoAndStatus();
        ScreenShotUtil.getScreenshot("qualityApproval");

    }
}
