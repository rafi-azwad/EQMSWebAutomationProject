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

import static SearchPage.CustomerComplainPage.InitialAssessmentPage.complainNo;

public class ReviewInitialAssessmentPage {

    WebDriver driver;

    public ReviewInitialAssessmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectReviewOfInitialAssessment()  {

        WebElement cc = driver.findElement(By.xpath("//*[text()='Review of Initial Assessment']"));
        JavascriptExecutor js = (JavascriptExecutor) driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", cc);
    }

    public void selectComplainNoAndStatus()  {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.name("COMPLAINT_NO")).click();


        try {
            driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")));

            //select complain sendKeys

        }

        WebElement status = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By.name("STATUS")))));
        Select selectStatus = new Select(status);
        selectStatus.selectByValue("Proceeding for Investigation");

        driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\Users\\Rafi\\Desktop\\eQMS\\WebAutomation\\src\\test\\resources\\File\\cat.jpg");


    }
    public void selectInvestigatorAndType()  {

        //driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]")).click();
        driver.findElement(By.xpath("//div[@ng-click='toggleMenu()']")).click();

        WebElement plusIcon = driver.findElement(By.xpath("//*[@src='/img/plus-icon.png']"));
        JavascriptExecutor js = (JavascriptExecutor) driver; //ElementClickInterceptedException
        js.executeScript("arguments[0].click()", plusIcon);


        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement iName = wait.until(ExpectedConditions.elementToBeClickable(By.name("USER_ID")));
        Select selectInvName = new Select(iName);
        selectInvName.selectByVisibleText("Rafi (null)");

        WebElement iType = wait.until(ExpectedConditions.elementToBeClickable(By.name("INVESTIGATOR_TYPE")));
        Select selectInvType = new Select(iType);
        selectInvType.selectByValue("Lead");

    }

}
