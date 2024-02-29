package EQMSStepDefinition.CustomerComplainsStepDefinition;

import Core.ScreenRecorderUtil;
import Core.ScreenShotUtil;
import SearchPage.CustomerComplainPage.ComplainStatusPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComplainStatusStepDefinition {
    ComplainStatusPage cs;
    @When("select complain status")
    public void selectComplainStatus() {
        cs = new ComplainStatusPage(LoginStepDefinition.driver);
        cs.selectComplainStatus();
        
    }

    @And("fill in the required complain status information")
    public void fillInTheRequiredComplainStatusInformation() throws InterruptedException {
        cs.selectStatus();
        cs.selectTitle();
    }


    @Then("see the full complain list")
    public void seeTheFullComplainList() throws InterruptedException {
        cs.seeDetailsComplainList();
        ScreenShotUtil.getScreenshot("seeCAPAComplainList");
        ScreenRecorderUtil.stopRecord();
    }
}
