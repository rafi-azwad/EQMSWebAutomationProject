package EQMSStepDefinition;

import Core.BrowserHelper;
import Core.ScreenRecorderUtil;
import SearchPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import static Core.BrowserHelper.takeScreenshot;

public class LoginStepDefinition {
    public static WebDriver driver;


    LoginPage lp;


    @Given("user in the login page")
    public void userInTheLoginPage() throws Exception {
        ScreenRecorderUtil.startRecord("LoginPage");
        BrowserHelper bhp = new BrowserHelper();
        driver = bhp.chrome();


    }

    @When("user enter {string} and {string}")
    public void userEnterAnd(String userName, String password) throws Exception {

        lp = new LoginPage(driver);
        lp.userNameAndPassword(userName,password);
    }

    @And("click login button")
    public void clickLoginButton() {
        lp.loginButton();

    }

    @Then("successfully navigate to the dashboard")
    public void successfullyNavigateToTheDashboard() throws Exception {

        lp.successfullyLogin();
        ScreenRecorderUtil.stopRecord();



    }

}
