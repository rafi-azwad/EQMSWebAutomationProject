package SearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.InitialAssessmentPage.complainNo;

public class ReviewInvestigationPage {
    WebDriver driver;

    public ReviewInvestigationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectReviewInvestigation() {
        try {
            driver.findElement(By.xpath("//*[text()='Review Investigation']")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='Review Investigation']")));


        }

    }

    public void selectComplainNoAndStatus() throws InterruptedException {
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

    public void selectFunctionalApproval() {


        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]")).click();

        WebElement plusIcon = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[10]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/button[1]/img[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver; //ElementClickInterceptedException
        js.executeScript("arguments[0].click()", plusIcon);


        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        WebElement iName = wait.until(ExpectedConditions.elementToBeClickable(By.name("USER_ID")));
        iName.click(); //functionalApprovalName
        driver.findElement(By.xpath("//*[text()='Rafi (null)']")).click();

        WebElement aType = wait.until(ExpectedConditions.elementToBeClickable(By.name("REVIEWER_TYPE")));
        aType.click();
        driver.findElement(By.xpath("//*[text()='Lead']")).click();

    }

    public void selectQualityApproval() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)");


        WebElement plusIcon = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/button[1]/img[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver; //ElementClickInterceptedException
        js.executeScript("arguments[0].click()", plusIcon);


        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement iName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/select[1]")));
        /*iName.click();  //qualityApprovalName
        WebElement text = driver.findElement(By.xpath("//option[contains(text(),'Rafi (null)')]"));
        text.click();
*/
        Select select = new Select(iName);
        select.selectByVisibleText("Rafi (null)");


        WebElement aType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/select[1]")));
        aType.click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/select[1]/option[2]")).click();

    }
}


