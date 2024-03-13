package SearchPage.ChangeControlPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.ChangeControlPage.RaiseChangeControlPage.CCRecordNo;
import static SearchPage.ChangeControlPage.RaiseChangeControlPage.CCRecordTitle;

public class ChangePlanPage {
    public WebDriver driver;

    public ChangePlanPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectChangePlan() {
        WebElement changePlan = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() ='Change Plan']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", changePlan);
    }

    public void ccRecordNo() throws InterruptedException {

        WebElement ccNo = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='CC_RAISE_NO']")));
        Thread.sleep(2000);
        Select selectCCNo = new Select(ccNo);
        selectCCNo.selectByValue(CCRecordNo);

        WebElement ccNoClick = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'" +CCRecordNo+ "')]")));
        ccNoClick.click();

    }

    public void riskAssessment() {

        WebElement riskAssessment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='RISK_ASSESSMENT_COMMENT']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", riskAssessment);
        riskAssessment.sendKeys("Risk Assessment of Change Plan");

        WebElement attachment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='RISK_ASSESSMENT_ATTACHMENT']")));
        attachment.sendKeys("C:\\Users\\Rafi\\Desktop\\eQMS\\WebAutomation\\src\\test\\resources\\File\\cat.jpg");

    }

    public void changePlanSummary() {

        WebElement plusIcon = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='grid.appScope.addNewSummaryRow()']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", plusIcon);

        WebElement action = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='ACTION']")));
        action.sendKeys("Problem 01");

        Select responsibility = new Select(driver.findElement(By.name("RESPONSIBILITY")));
        responsibility.selectByVisibleText("Rafi (null)");

        driver.findElement(By.xpath("//input[@ng-model='row.entity.TARGET_DATE']")).click();
        WebElement targetDateClick = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='22']")));
        jse.executeScript("arguments[0].click()", targetDateClick);

    }

       public void selectFunctionalApproval() {

        WebElement plusIcon = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@ng-click='grid.appScope.addNewRow2()']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", plusIcon);

        Select name = new Select(driver.findElement(By.name("USER_ID")));
        name.selectByVisibleText("Rafi");

    }
    public void selectQualityApproval() {
        WebElement qualityApproval = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Select Quality Approver']//following::span[3]")));
        qualityApproval.click();
        WebElement qualityApprovalList = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Rafi (null)']")));
        qualityApprovalList.click();


    }
    public void save(){

        WebElement save = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]")));
        save.click();
    }

    public void submit() {

        //submit
        WebElement submit = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", submit);

    }
    public void closeChangeControl() throws InterruptedException {

        WebElement cc =driver.findElement(By.xpath("//span[contains(text(),'Change Control')]"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js1.executeScript("arguments[0].click()", cc);
        Thread.sleep(2000);

    }
}
