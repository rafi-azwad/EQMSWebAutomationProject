package SearchPage.CustomerComplainPage;

import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;



public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void userNameAndPassword(String userName, String password) {
        driver.findElement(By.name("UserName")).click();
        driver.findElement(By.name("UserName")).sendKeys(userName);
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).sendKeys(password);

    }

    public void loginButton() {

       driver.findElement(By.xpath("//*[text()='Login']")).click();
    }

    public void successfullyLogin()  {

        String expect = "Electronic Quality Management System";
        WebElement we = driver.findElement(By.className("display-4"));
        String actual = we.getText();
        //Assert.assertEquals(actual,expect);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expect,"Login failed");

        System.out.println("Successfully login -->>>>");

        softAssert.assertAll();
    }

    }




