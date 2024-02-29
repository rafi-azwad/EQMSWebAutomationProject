package SearchPage.CustomerComplainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.CustomerComplainPage.InitialAssessmentPage.complainNo;

public class CAPAStatusReviewPage {
    WebDriver driver;

    public CAPAStatusReviewPage (WebDriver driver){
        this.driver = driver;
    }
    public void selectCAPAStatusReview(){
        try {
            driver.findElement(By.xpath("//*[text()='CAPA Status Review']")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='CAPA Status Review']")));
        }

    }
    public void selectComplainNo (){
        driver.findElement(By.name("COMPLAINT_NO")).click();


        try {
            driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")));

            //select complain sendKeys

        }

    }
    public void correctionAction() {

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/textarea[1]")).click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/textarea[1]")).sendKeys("problem not found");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.name("STATUS")).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()= 'Closed-Complete']"))));
        element.click();

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[4]")).click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/textarea[1]")).click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/textarea[1]")).sendKeys("problem");

    }
    public void preventionAction() {

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/textarea[1]")).click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/textarea[1]")).sendKeys("problem solved");

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/select[1]")).click();
        //driver.findElement(By.name("STATUS")).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/select[1]/option[2]"))));
        element.click();

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//td[contains(text(),'23')]")).click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/textarea[1]")).click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/textarea[1]")).sendKeys("problem01");


    }


    }

