package EQMSStepDefinition;

import Core.ScreenRecorderUtil;
import Core.ScreenShotUtil;
import SearchPage.QualityApprovalPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class QualityApprovalStepDefinition {
    QualityApprovalPage qp;
    @When("select quality approval")
    public void selectQualityApproval() {
        qp = new QualityApprovalPage(driver);
        qp.clickQualityApproval();

    }

    @And("fill in the required quality approval information")
    public void fillInTheRequiredQualityApprovalInformation() {
        qp.selectComplainNoAndStatus();
        ScreenShotUtil.getScreenshot("qualityApproval");

    }
}
