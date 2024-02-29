package EQMSStepDefinition.CustomerComplainsStepDefinition;

import Core.BrowserHelper;
import Core.ScreenRecorderUtil;
import SearchPage.CustomerComplainPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


public class LoginStepDefinition {
    public static WebDriver driver;

    LoginPage lp;
    ITestResult result;

    @Given("user in the login page")
    public void userInTheLoginPage() {
        ScreenRecorderUtil.startRecord("Record of All Change Control Test");
        BrowserHelper bhp = new BrowserHelper();
        driver = bhp.chrome();
        //driver = bhp.headlessBrowser();

    }

    @When("user enter {string} and {string}")
    public void userEnterAnd(String userName, String password)  {

        lp = new LoginPage(driver);
        lp.userNameAndPassword(userName,password);
    }

    @And("click login button")
    public void clickLoginButton()  {
        //ScreenShotUtil.getScreenshot("login credential");
        lp.loginButton();

    }

    @Then("successfully navigate to the dashboard")
    public void successfullyNavigateToTheDashboard() {

        lp.successfullyLogin();
        //ScreenShotUtil.getScreenshot("login successfully");

    }


}
