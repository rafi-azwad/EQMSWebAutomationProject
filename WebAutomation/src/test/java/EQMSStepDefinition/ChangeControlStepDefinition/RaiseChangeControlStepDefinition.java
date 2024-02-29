package EQMSStepDefinition.ChangeControlStepDefinition;

import SearchPage.ChangeControlPage.RaiseChangeControlPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class RaiseChangeControlStepDefinition {

    RaiseChangeControlPage rccp;
    @Given("click on change control option")
    public void clickOnChangeControlOption() {
        rccp = new RaiseChangeControlPage(driver);
        rccp.changeControl();
    }
    @When("select raise change control")
    public void selectRaiseChangeControl() {
        rccp.raiseChangeControl();
    }

    @And("fill in the raise Change Control information")
    public void fillInTheRaiseChangeControlInformation() {
        rccp.fillRequiredInformation();
    }

    @Then("save and submit raise change control's the information")
    public void saveAndSubmitRaiseChangeControlSTheInformation() throws InterruptedException {
        rccp.saveAndSubmit();
    }
}
