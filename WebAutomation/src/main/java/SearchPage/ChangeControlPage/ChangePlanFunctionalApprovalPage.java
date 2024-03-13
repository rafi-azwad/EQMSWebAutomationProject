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


public class ChangePlanFunctionalApprovalPage {

    WebDriver driver;
    ReviewOfProposedPage rpp;
    ChangePlanPage cpp;
    ImpactAssessmentPage iap;
    public ChangePlanFunctionalApprovalPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectChangePlanFunctionalApproval() {
        WebElement changePlanFunctionalApproval = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() ='Change Plan Functional Approval']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", changePlanFunctionalApproval);
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

    public void functionalApprovalComment() {
        WebElement functionalApprovalComment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@ng-model='model.FUNCTIONAL_APPROVAL_COMMENT']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", functionalApprovalComment);
        functionalApprovalComment.sendKeys("functional approval comment");
    }
    public void selectReviseCCPlanStatus() throws InterruptedException {
        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.name("FUNCTIONAL_APPROVAL_STATUS")));
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

    }
    public void selectReviseImpactAssessmentStatus() throws InterruptedException {
        selectChangePlanFunctionalApproval();
        ccRecordNo();

        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.name("FUNCTIONAL_APPROVAL_STATUS")));
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

    }
    public void selectApprovedStatus() throws InterruptedException {
        selectChangePlanFunctionalApproval();
        ccRecordNo();
        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.name("FUNCTIONAL_APPROVAL_STATUS")));
        Thread.sleep(2000);
        Select select = new Select(status);
        select.selectByVisibleText(" Approved ");
    }

    public void save(){

        WebElement save = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]")));
        save.click();
    }

    public void submit()  {

        //submit
        WebElement submit = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Submit')]")));
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
