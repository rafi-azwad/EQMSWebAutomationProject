package SearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvestigationPage {
    WebDriver driver;
    public InvestigationPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectInvestigation() {

        /*  Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
          WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Investigation']")));
          ele.click();    //ElementClickInterceptedException*/


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
            driver.findElement(By.xpath("//*[contains(text(), '-- complainCheck')]")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(), '-- complainCheck')]")));

            //select complain sendKeys
        }
    }

    public void selectInvestigationAndCAPA() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement plusIcon = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[18]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/button[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver; //ElementClickInterceptedException
        js.executeScript("arguments[0].click()", plusIcon);


        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        WebElement iName = wait.until(ExpectedConditions.elementToBeClickable(By.name("USER_ID")));
        iName.click(); //investigatorName
        driver.findElement(By.xpath("//*[text()='Rafi (null)']")).click();

        WebElement iType = wait.until(ExpectedConditions.elementToBeClickable(By.name("REVIEWER_TYPE")));
        iType.click();
        driver.findElement(By.xpath("//*[text()='Lead']")).click();

       // JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-500)");

    }

    }


