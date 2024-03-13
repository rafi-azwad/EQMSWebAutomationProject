package SearchPage.CustomerComplainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.CustomerComplainPage.ComplainRaisePage.titleOfComplain;

public class InitialAssessmentPage {
    WebDriver driver;
    public static String complainNo ="-- "+titleOfComplain;

    public InitialAssessmentPage(WebDriver driver){

        this.driver = driver;
    }

    public void clickInitialAssessment() throws InterruptedException {
        try {
            driver.findElement(By.linkText("Initial Assesment")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            Thread.sleep(2000);
            executor.executeScript("arguments[0].click()", driver.findElement(By.linkText("Initial Assesment")));
        }
    }

        public void selectComplainNoAndStatus() throws InterruptedException {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.name("COMPLAINT_NO")).click();


            try {
                driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")).click();


            } catch (Exception e) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")));

               //select complain sendKeys
            }

            driver.findElement(By.xpath("//textarea[@id='ASSESMENT_COMMENT']")).click();
            driver.findElement(By.xpath("//textarea[@id='ASSESMENT_COMMENT']")).sendKeys("problem");


            WebElement status = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.name("STATUS")))));
            Select selectStatus = new Select(status);
            selectStatus.selectByValue("Proceeding for Investigation");

            driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\Users\\Rafi\\Desktop\\eQMS\\WebAutomation\\src\\test\\resources\\File\\lion.jpg");


            WebElement review = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.name("REVIEWED_BY")))));
            Select selectReview = new Select(review);
            selectReview.selectByValue("200");

    }

}
