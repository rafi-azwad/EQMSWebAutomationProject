package SearchPage.ChangeControlPage;

import org.bouncycastle.oer.Switch;
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
import static SearchPage.ChangeControlPage.RaiseChangeControlPage.CCRecordTitle;
import static SearchPage.CustomerComplainPage.ComplainRaisePage.titleOfComplain;

public class ReviewOfProposedPage {

    public WebDriver driver;
    public ReviewOfProposedPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickReviewOfProposed(){

        WebElement reviewOfProposed = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Review of Proposed Change']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",reviewOfProposed);
    }

  public void ccRecordNo(){
        System.out.println("ccRecordValue "+CCRecordNo);
        WebElement ccNo = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='CC_RAISE_NO']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",ccNo);

       WebElement ccNoClick = new WebDriverWait(driver, Duration.ofSeconds(10)).
              until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'" +CCRecordTitle+ "')]")));
       ccNoClick.click();

    }
  public void reviewerComment() {

      WebElement comment = new WebDriverWait(driver, Duration.ofSeconds(20)).
              until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='REVIEW_COMMENT']")));
      JavascriptExecutor jse = (JavascriptExecutor) driver;
      jse.executeScript("arguments[0].click()", comment);
      comment.sendKeys("pass");
  }


    public void furtherInformationRequired() throws InterruptedException {

        WebElement furtherInformationRequired = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='REVIEW_STATUS']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", furtherInformationRequired);
        Select selectApproval = new Select(furtherInformationRequired);
        selectApproval.selectByValue("Further Information Required");

        WebElement raiseChangeControl = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Raise Change Control')]")));
        jse.executeScript("arguments[0].click()",raiseChangeControl);

        WebElement search = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
        jse.executeScript("arguments[0].click()",search);

        WebElement filter = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Filter']")));
        jse.executeScript("arguments[0].click()",filter);

        WebElement draft = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+CCRecordTitle+"']")));
        //jse.executeScript("arguments[0].click()",draft);

        Actions actions = new Actions(driver);
        actions.doubleClick(draft).build().perform();

        saveAndSubmit();

    }
      public void approval() {

      /*  clickReviewOfProposed();
        ccRecordNo();
        reviewerComment();*/

        WebElement approval = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='REVIEW_STATUS']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", approval);
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

    public void saveAndSubmit() throws InterruptedException {

        WebElement save = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]")));
        save.click();

        //submit
        WebElement submit = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", submit);

        WebElement cc =driver.findElement(By.xpath("//span[contains(text(),'Change Control')]"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js1.executeScript("arguments[0].click()", cc);
        Thread.sleep(2000);

    }
}
