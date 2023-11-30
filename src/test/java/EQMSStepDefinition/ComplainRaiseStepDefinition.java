package EQMSStepDefinition;

import Core.ScreenRecorderUtil;
import SearchPage.ComplainRaisePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class ComplainRaiseStepDefinition {
    ComplainRaisePage cc;


    @Given("click on customer complain option")
    public void clickOnCustomerComplainOption() throws Exception {
        ScreenRecorderUtil.startRecord("LoginPage");
        cc = new ComplainRaisePage(driver);
        cc.clickCustomerComplain();

    }

    @When("select complain raise")
    public void selectComplainRaise() {
        cc.clickComplainRaise();

    }

    @And("fill in the required information")
    public void fillInTheRequiredInformation() throws InterruptedException {
        cc.addComplainRaiseInformation();

    }

    @Then("save and submit the information")
    public void saveAndSubmitTheInformation() throws Exception {
        cc.saveAndSubmitComplainRaise();
        ScreenRecorderUtil.stopRecord();
    }

}
