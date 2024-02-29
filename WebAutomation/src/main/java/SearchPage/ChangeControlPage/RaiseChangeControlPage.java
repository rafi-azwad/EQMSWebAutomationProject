package SearchPage.ChangeControlPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RaiseChangeControlPage {

    public WebDriver driver;

    public static String CCRecordTitle = "rafi7";
    public static String CCRecordNo = "";

    public RaiseChangeControlPage(WebDriver driver){
        this.driver = driver;

    }

    public void changeControl() {
        WebElement changeControl = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Change Control')]")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",changeControl);

    }
    public void raiseChangeControl(){

        WebElement raiseChangeControl = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Raise Change Control')]")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",raiseChangeControl);
    }

    public void fillRequiredInformation(){

        WebElement titleOfChange = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='CC_TITLE']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",titleOfChange);
        titleOfChange.sendKeys(CCRecordTitle);

        Select product = new Select(driver.findElement(By.xpath("//select[@ng-change='OnProductChange()']")));
        product.selectByVisibleText(" MESOI771 -- Meril S. B. Soap (W I/C) 25gm (Club Amasan)");

        Select natureOfChange = new Select(driver.findElement(By.xpath("//select[@id='NATURE_OF_CHANGE']")));
        natureOfChange.selectByVisibleText("Packaging Defect");

        Select reviewer = new Select(driver.findElement(By.xpath("//select[@id='REVIEWER_ID']")));
        reviewer.selectByVisibleText("Rafi ()");

        WebElement attachment = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='FILES']")));
        attachment.sendKeys("C:\\Users\\Rafi\\Desktop\\eQMS\\WebAutomation\\src\\test\\resources\\File\\logo.jpg");
    }

    public void saveAndSubmit() throws InterruptedException {

        /*JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,-350)");*/

        WebElement save = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]")));
        save.click();

        WebElement getCCRecordNo = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='CC_RAISE_NO']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",getCCRecordNo);
        CCRecordNo = getCCRecordNo.getAttribute("value");
        System.out.println("CC Record Number: "+CCRecordNo);


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
