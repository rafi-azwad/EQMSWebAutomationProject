package SearchPage.CustomerComplainPage;

import org.openqa.selenium.*;
import java.util.logging.Logger;


public class ComplainRaisePage {

    public WebDriver driver;
    public static String titleOfComplain = "complainCheckLast123";
    public ComplainRaisePage(WebDriver driver){
        this.driver = driver;
    }


    public void clickCustomerComplain()  {

        WebElement cc =driver.findElement(By.xpath("//*[text()= 'Customer Complaints']"));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", cc);

    }

    public void clickComplainRaise(){

        try {
            driver.findElement(By.xpath("//*[text()='Complaint Raise']")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[text()='Complaint Raise']")));
        }


    }
    public void addComplainRaiseInformation() throws InterruptedException {


        driver.findElement(By.xpath("//input[@id='TITLE_OF_COMPLAINT']")).click();
        driver.findElement(By.xpath("//input[@id='TITLE_OF_COMPLAINT']")).sendKeys(titleOfComplain); //sendKeys of complain

        //product
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",driver.findElement(By.name("PRODUCT_CODE")));

        driver.findElement(By.xpath("//*[text()='CHBAC090 -- Chaka Ball Soap - 100gm']")).click();

        //receiveFrom
        driver.findElement(By.xpath("//input[@id='COMPLAINT_RECEIVE_FROM']")).click();
        driver.findElement(By.xpath("//input[@id='COMPLAINT_RECEIVE_FROM']")).sendKeys("ABC");

        //natureOfComplainCode
        driver.findElement(By.xpath("//*[@id='NATURE_OF_COMPLAINT_CODE']")).click();
        driver.findElement(By.xpath("//*[text()='Product Quality Issue']")).click();

        jse.executeScript("window.scrollBy(0,250)");

        Thread.sleep(2000);
        jse.executeScript("arguments[0].click()", driver.findElement(By.id("SEND_TO")));
        // driver.findElement(By.xpath("//*[text()='Arman Hossain (Programmer)']")).click();
        driver.findElement(By.xpath("//*[text()='Rafi ()']")).click();


        driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\Users\\Rafi\\Desktop\\eQMS\\WebAutomation\\src\\test\\resources\\File\\logo.jpg");



        /*    catch (ElementNotInteractableException | NoSuchElementException |
                InvalidArgumentException | TimeoutException e) {
            logger.log(Level.SEVERE, e.toString());
        }
*/
    }


    public void saveAndSubmitComplainRaise() throws InterruptedException {

        /*JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,-350)");*/

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();


        //submit
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", submit);

        WebElement cc =driver.findElement(By.xpath("//*[text()= 'Customer Complaints']"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js1.executeScript("arguments[0].click()", cc);
        Thread.sleep(2000);



    }

}
