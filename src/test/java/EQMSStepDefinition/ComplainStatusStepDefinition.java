package EQMSStepDefinition;

import Core.ScreenRecorderUtil;
import Core.ScreenShotUtil;
import SearchPage.ComplainStatusPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class ComplainStatusStepDefinition {
    ComplainStatusPage cs;
    @When("select complain status")
    public void selectComplainStatus() {
        cs = new ComplainStatusPage(driver);
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
