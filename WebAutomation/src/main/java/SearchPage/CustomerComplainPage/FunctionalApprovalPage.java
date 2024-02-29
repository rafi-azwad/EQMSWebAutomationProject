package SearchPage.CustomerComplainPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.CustomerComplainPage.InitialAssessmentPage.complainNo;

public class FunctionalApprovalPage {
    WebDriver driver;

    public  FunctionalApprovalPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickFunctionalApproval(){

        WebElement cc =driver.findElement(By.xpath("//*[text()= 'Functional Approval']"));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", cc);
    }

    public void selectComplainNoAndStatus() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.name("COMPLAINT_NO")).click();


        try {
            driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")));

            //select complain sendKeys
        }


        driver.findElement(By.name("STATUS")).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()= '  Approved ']"))));
        element.click();

    }



}
