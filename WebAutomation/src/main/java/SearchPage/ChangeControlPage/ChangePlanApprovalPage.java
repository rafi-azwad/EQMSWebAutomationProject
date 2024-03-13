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

public class ChangePlanApprovalPage {

    WebDriver driver;
    ReviewOfProposedPage rpp;
    ChangePlanPage cpp;
    ImpactAssessmentPage iap;
    ChangePlanFunctionalApprovalPage cpfap;

    public ChangePlanApprovalPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectChangePlanApproval() {
        WebElement changePlanApproval = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() ='Change Plan Approval']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", changePlanApproval);
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

    public void qualityApprovalComment() {
        WebElement qualityApprovalComment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@ng-model='model.QUALITY_APPROVAL_COMMENT']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", qualityApprovalComment);
        qualityApprovalComment.sendKeys("quality approval comment");
    }
    public void selectRevisedCCPlanStatus() throws InterruptedException {
        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.name("QUALITY_APPROVAL_STATUS")));
        Select select = new Select(status);
        select.selectByValue("Revise CC Plan");
        save();
        submit();

        //click change plan
        cpp = new ChangePlanPage(driver);
        cpp.selectChangePlan();

        //submit data from draft
        rpp = new ReviewOfProposedPage(driver);
        rpp.reviseFromDraft();

        //click change plan functional approval
        cpfap = new ChangePlanFunctionalApprovalPage(driver);
        cpfap.selectChangePlanFunctionalApproval();

        //submit data from draft
        rpp = new ReviewOfProposedPage(driver);
        rpp.reviseFromDraft();

    }

    public void selectImpactAssessmentStatus() throws InterruptedException {
        selectChangePlanApproval();
        ccRecordNo();

        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.name("QUALITY_APPROVAL_STATUS")));
        Thread.sleep(2000);
        Select select = new Select(status);
        select.selectByValue("Revise Impact Assessment");
        save();
        submit();

        //click impact assessment
        iap = new ImpactAssessmentPage(driver);
        iap.selectImpactAssessment();

        //submit data from draft
        rpp = new ReviewOfProposedPage(driver);
        rpp.reviseFromDraft();

        //click change plan
        cpp = new ChangePlanPage(driver);
        cpp.selectChangePlan();

        //submit data from draft
        rpp = new ReviewOfProposedPage(driver);
        rpp.reviseFromDraft();

        //click change plan functional approval
        cpfap = new ChangePlanFunctionalApprovalPage(driver);
        cpfap.selectChangePlanFunctionalApproval();

        //submit data from draft
        rpp = new ReviewOfProposedPage(driver);
        rpp.reviseFromDraft();

    }
    public void selectApprovedStatus() throws InterruptedException {
        selectChangePlanApproval();
        ccRecordNo();

        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.name("QUALITY_APPROVAL_STATUS")));
        Thread.sleep(2000);
        Select select = new Select(status);
        select.selectByValue("Approved");
    }
    public void save(){

        WebElement save = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]")));
        save.click();
    }

    public void submit()  {

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
