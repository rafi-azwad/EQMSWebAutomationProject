package EQMSStepDefinition;

import Core.ScreenShotUtil;
import SearchPage.InvestigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static EQMSStepDefinition.LoginStepDefinition.driver;

public class InvestigationStepDefinition {
    InvestigationPage ip;
    @When("select investigation")
    public void selectInvestigation()  {
        ip = new InvestigationPage(driver);
        ip.selectInvestigation();
        
    }

    @And("fill in the required investigation information")
    public void fillInTheRequiredInvestigationInformation() {
        ip.selectComplainNo();
        ScreenShotUtil.getScreenshot("investigation");
        ip.selectInvestigationAndCAPA();


    }
}
