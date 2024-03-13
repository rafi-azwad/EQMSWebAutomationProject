package SearchPage.CustomerComplainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static SearchPage.CustomerComplainPage.InitialAssessmentPage.complainNo;

public class InvestigationPage {
    WebDriver driver;
    public InvestigationPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectInvestigation() {


        try {
            driver.findElement(By.xpath("//*[text()='Investigation']")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='Investigation']")));


        }


    }

    public void selectComplainNo(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.name("COMPLAINT_NO")).click();


        try {
            driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(), '"+complainNo+"')]")));

            //select complain sendKeys
        }
    }

    public void investigationDetailsAndResult(){
        driver.findElement(By.xpath("//textarea[@id='INVESTIGATION_DETAILS']")).click();
        driver.findElement(By.xpath("//textarea[@id='INVESTIGATION_DETAILS']")).sendKeys("no problem");

        driver.findElement(By.xpath("//input[@id='INVESTIGATION_RESULT']")).click();
        driver.findElement(By.xpath("//input[@id='INVESTIGATION_RESULT']")).sendKeys("no problem");
    }

    public void correctionAction() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,450)");
        //plusIcon
        driver.findElement(By.xpath("//button[@ng-click='grid.appScope.addNewCaRow()']")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("ACTION")).click();
        driver.findElement(By.name("ACTION")).sendKeys("problem");

        Select select = new Select(driver.findElement(By.name("CA_RESPONSIBILITY")));
        select.selectByVisibleText("Rafi (null)");

        driver.findElement(By.xpath("//input[@ng-model='row.entity.TARGET_DATE']")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).click();


    }
    public void preventionAction() {
        //plusIcon
        driver.findElement(By.xpath("//button[@ng-click='grid.appScope.addNewPaRow()']")).click();

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[16]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/textarea[1]")).click();
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[16]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/textarea[1]")).sendKeys("problem01");


        Select select = new Select(driver.findElement(By.name("PA_RESPONSIBILITY")));
        select.selectByVisibleText("Rafi (null)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[16]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//td[contains(text(),'13')]")).click();


    }

    public void selectInvestigationAndCAPA() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement plusIcon = driver.findElement(By.xpath("//button[@ng-click='grid.appScope.addNewRow1()']"));
        JavascriptExecutor js = (JavascriptExecutor) driver; //ElementClickInterceptedException
        js.executeScript("arguments[0].click()", plusIcon);


        Select select = new Select(driver.findElement(By.name("USER_ID")));
        select.selectByVisibleText("Rafi (null)");

        Select select1 = new Select(driver.findElement(By.name("REVIEWER_TYPE")));
        select1.selectByVisibleText("Lead");


        // JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-500)");

    }

    }


