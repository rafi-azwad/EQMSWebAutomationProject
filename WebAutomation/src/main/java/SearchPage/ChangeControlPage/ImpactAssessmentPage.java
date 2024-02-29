package SearchPage.ChangeControlPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.ChangeControlPage.RaiseChangeControlPage.CCRecordNo;
import static SearchPage.ChangeControlPage.RaiseChangeControlPage.CCRecordTitle;

public class ImpactAssessmentPage {
    public WebDriver driver;

    public ImpactAssessmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectImpactAssessment() {
        WebElement impactAssessment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Impact Assessment')]")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", impactAssessment);
    }

    public void ccRecordNo() {

        WebElement ccNo = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='CC_RAISE_NO']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", ccNo);

        WebElement ccNoClick = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'" +CCRecordTitle+ "')]")));
        ccNoClick.click();

    }

    public void riskAssessment() {

        WebElement riskAssessment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@ng-model='model.RISK_ASSESSMENT']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", riskAssessment);
        riskAssessment.sendKeys("Risk Assessment of Impact Assessment");

        WebElement reviewOfProposedChange = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[contains(text(),'Review of Proposed Change')]")));
        jse.executeScript("arguments[0].click()", reviewOfProposedChange);

        WebElement reviewOfProposedChangeRiskAssessment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@ng-model='model.RISK_ASSESSMENT']")));
        jse.executeScript("arguments[0].click()", reviewOfProposedChangeRiskAssessment);


    }
    public void saveAndSubmit() throws InterruptedException {

        /*JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,-350)");*/

        WebElement save = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]")));
        save.click();

        //submit
        WebElement submit = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", submit);

        WebElement cc =driver.findElement(By.xpath("//span[contains(text(),'Change Control')]"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js1.executeScript("arguments[0].click()", cc);
        Thread.sleep(2000);

    }
}
