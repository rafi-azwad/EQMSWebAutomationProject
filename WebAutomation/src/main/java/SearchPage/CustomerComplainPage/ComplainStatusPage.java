package SearchPage.CustomerComplainPage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static SearchPage.CustomerComplainPage.ComplainRaisePage.titleOfComplain;

public class ComplainStatusPage {
    WebDriver driver;

    public ComplainStatusPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectComplainStatus(){
        WebElement cc =driver.findElement(By.xpath("//*[text()= 'Complaint Status']"));
        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        js.executeScript("arguments[0].click()", cc);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }
    public void selectStatus(){
      //  driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[1]/div[1]/div[1]/div[6]/div[1]/div[2]/select[1]")).click();
        Select select = new Select(driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[1]/div[1]/div[1]/div[6]/div[1]/div[2]/select[1]")));
        select.selectByVisibleText("All");
        driver.findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
    }

    public void selectTitle() throws InterruptedException {

        WebElement link = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]"));

        JavascriptExecutor js = (JavascriptExecutor)driver; //org.openqa.selenium.ElementClickInterceptedException
        Thread.sleep(2000);
       // js.executeScript("arguments[0].scrollIntoView();", link);
        js.executeScript("arguments[0].scrollBy(0,3500);", link);


        //WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'complainCheck1290')]"));
        WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+titleOfComplain+"')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).doubleClick().build().perform();
       //actions.doubleClick(ele).perform();

    }
    public void seeDetailsComplainList() throws InterruptedException {

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[2]/label[1]")).click();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[3]/label[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[4]/label[1]/span[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,600)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[5]/label[1]/span[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,450)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[6]/label[1]/span[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,600)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[7]/label[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,450)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[8]/label[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[9]/label[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/fieldset[2]/div[10]/label[1]")).click();
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)");

    }
}
