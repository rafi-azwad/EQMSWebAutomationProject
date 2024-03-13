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

public class QualityFinalReviewPage {

    WebDriver driver;

    public QualityFinalReviewPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectQualityFinalReviewPage() {
        WebElement qualityFinalReview = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() ='Quality Final Review']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", qualityFinalReview);
    }

    public void ccRecordNo() throws InterruptedException {

        WebElement ccNo = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='CC_RAISE_NO']")));
        Select selectCCNo = new Select(ccNo);
        Thread.sleep(2000);
        selectCCNo.selectByValue(CCRecordNo);

        WebElement ccNoClick = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'" +CCRecordNo+ "')]")));
        ccNoClick.click();


    }

    public void reviewSummary() {
        WebElement reviewSummary = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@ng-model='model.REVIEW_SUMMARY']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", reviewSummary);
        reviewSummary.sendKeys("Review Summary");
    }
    public void selectStatus() {
        WebElement status = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='model.REVIEW_STATUS']")));
        Select select = new Select(status);
        select.selectByValue("Closed-Completed");
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
