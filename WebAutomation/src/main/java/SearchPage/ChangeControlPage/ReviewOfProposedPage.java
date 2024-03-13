package SearchPage.ChangeControlPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.ChangeControlPage.RaiseChangeControlPage.CCRecordNo;


public class ReviewOfProposedPage {

    public WebDriver driver;
    RaiseChangeControlPage rp;
    public ReviewOfProposedPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickReviewOfProposed(){

        WebElement reviewOfProposed = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Review of Proposed Change']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",reviewOfProposed);

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
  public void reviewerComment() {

      WebElement comment = new WebDriverWait(driver, Duration.ofSeconds(20)).
              until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='REVIEW_COMMENT']")));
      JavascriptExecutor jse = (JavascriptExecutor) driver;
      jse.executeScript("arguments[0].click()", comment);
      comment.sendKeys("pass");
  }


    public void furtherInformationRequired() {

        WebElement furtherInformationRequired = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='REVIEW_STATUS']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", furtherInformationRequired);
        Select selectApproval = new Select(furtherInformationRequired);
        selectApproval.selectByValue("Further Information Required");
        save();
        submit();

        rp = new RaiseChangeControlPage(driver);
        rp.raiseChangeControl();
    }
    public void reviseFromDraft() throws InterruptedException {
        WebElement search = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", search);

        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='SUBMIT_STATUS']")));
        jse.executeScript("arguments[0].click()", status);
        Select selectStatus = new Select(status);
        selectStatus.selectByValue("N");

        WebElement filter = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Filter']")));
        jse.executeScript("arguments[0].click()", filter);

        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" +CCRecordNo+ "')]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(title).doubleClick().build().perform();

        Thread.sleep(2000);
        submit();
        Thread.sleep(2000);

    }

      public void approval() throws InterruptedException {

        clickReviewOfProposed();
        ccRecordNo();

        WebElement approval = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='REVIEW_STATUS']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", approval);
        Thread.sleep(2000);
        Select selectApproval = new Select(approval);
        selectApproval.selectByValue("Approved");
    }
    public void coordinator() {
        WebElement coordinator = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='USER_ID']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", coordinator);
        Select selectCoordinator = new Select(coordinator);
        selectCoordinator.selectByVisibleText(" Rafi ()");

    }


    public void selectImpactAssessor(){

        WebElement name = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='IMPACT_ASSESSOR_ID']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",name);
        Select selectName = new Select(name);
        selectName.selectByVisibleText("Rafi (null)");
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
