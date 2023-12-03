package SearchPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ComplainRaisePage {

    public WebDriver driver;
    Logger logger = Logger.getLogger(ComplainRaisePage.class.getName());
    public ComplainRaisePage(WebDriver driver){
        this.driver = driver;
    }


    public void clickCustomerComplain()  {

       // Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));


      /*  WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(15))).

                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()= 'Customer Complaints']")));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", element);
*/

        WebElement cc =driver.findElement(By.xpath("//*[text()= 'Customer Complaints']"));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", cc);

    }

    public void clickComplainRaise(){

        try {
            driver.findElement(By.xpath("//*[text()='Complaint Raise']")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='Complaint Raise']")));
        }


    }
    public void addComplainRaiseInformation() throws InterruptedException {


        driver.findElement(By.xpath("//input[@id='TITLE_OF_COMPLAINT']")).click();
        driver.findElement(By.xpath("//input[@id='TITLE_OF_COMPLAINT']")).sendKeys("complainCheck");
        //sendKeys of complain

        //Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[1]/div[4]/div[1]/div[2]/span[1]/span[1]/span[1]")).click();
        driver.findElement(By.xpath("//*[text()='CHBAC090 -- Chaka Ball Soap - 100gm']")).click();


            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)");

            Thread.sleep(2000);
            driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[1]/div[13]/div[1]/div[2]/span[1]/span[1]/span[1]")).click();

            // driver.findElement(By.xpath("//*[text()='Arman Hossain (Programmer)']")).click();
            driver.findElement(By.xpath("//*[text()='Rafi ()']")).click();


            driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\Users\\Rafi\\Desktop\\eQMS\\WebAutomation\\src\\test\\resources\\File\\logo.png");



        /*    catch (ElementNotInteractableException | NoSuchElementException |
                InvalidArgumentException | TimeoutException e) {
            logger.log(Level.SEVERE, e.toString());
        }
*/
    }


    public void saveAndSubmitComplainRaise() throws InterruptedException {

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,-350)");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

        WebElement cc =driver.findElement(By.xpath("//*[text()= 'Customer Complaints']"));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", cc);
        Thread.sleep(2000);



    }

}
