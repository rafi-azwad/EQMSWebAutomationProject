package EQMSStepDefinition.CustomerComplainsStepDefinition;

import SearchPage.CustomerComplainPage.ComplainRaisePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class ComplainRaiseStepDefinition {
    ComplainRaisePage cc;


    @Given("click on customer complain option")
    public void clickOnCustomerComplainOption() {

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
        //ScreenShotUtil.getScreenshot("complainRaise");

    }

    @Then("save and submit the information")
    public void saveAndSubmitTheInformation() throws Exception {
        cc.saveAndSubmitComplainRaise();


    }

}
