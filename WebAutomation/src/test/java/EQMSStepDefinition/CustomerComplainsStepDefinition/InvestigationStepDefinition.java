package EQMSStepDefinition.CustomerComplainsStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.CustomerComplainPage.InvestigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.CustomerComplainsStepDefinition.LoginStepDefinition.driver;

public class InvestigationStepDefinition {
    InvestigationPage ip;
    @When("select investigation")
    public void selectInvestigation()  {
        ip = new InvestigationPage(driver);
        ip.selectInvestigation();
        
    }

    @And("fill in the required investigation information")
    public void fillInTheRequiredInvestigationInformation() throws InterruptedException {
        ip.selectComplainNo();
        ScreenShotUtil.getScreenshot("investigation");
        ip.investigationDetailsAndResult();
        ip.correctionAction();
        ScreenShotUtil.getScreenshot("correction Action");
        ip.preventionAction();
        ScreenShotUtil.getScreenshot("prevention Action");
        ip.selectInvestigationAndCAPA();


    }
}
