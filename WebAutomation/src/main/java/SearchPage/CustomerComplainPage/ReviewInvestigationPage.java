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

public class ReviewInvestigationPage {
    WebDriver driver;
    InvestigationPage ip;
    FunctionalApprovalPage fp;
    ComplainRaisePage cp ;

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
            driver.findElement(By.xpath("//*[contains(text(), '" + complainNo + "')]")).click();


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(), '" + complainNo + "')]")));

            //select complain sendKeys
        }
    }
    public void furtherStatus() throws InterruptedException {

        WebElement furtherInv = driver.findElement(By.name("STATUS"));
        Select select1 = new Select(furtherInv);
        String further = "Further Investigation";
        select1.selectByValue(further);

        // Get the currently selected option
        WebElement selectedOption = select1.getFirstSelectedOption();
        String currentSelection = selectedOption.getText();

        if (further.equals(currentSelection)) {
            System.out.println("yes -------------");
            cp = new ComplainRaisePage(driver);
            cp.saveAndSubmitComplainRaise();
            ip = new InvestigationPage(driver);
            ip.selectInvestigation();
            ip.selectComplainNo();
            cp = new ComplainRaisePage(driver);
            cp.saveAndSubmitComplainRaise();
        }
    }
    public void approvedStatus() throws InterruptedException {

        selectReviewInvestigation();
        selectComplainNoAndStatus();

        WebElement approved = driver.findElement(By.name("STATUS"));
        Select select = new Select(approved);
        select.selectByVisibleText("  Approved ");


   /*     if(furtherInv.isSelected()){

            ip = new InvestigationPage(driver);

        }
        else if(approved.isSelected()){
            fp = new FunctionalApprovalPage(driver);
        }*/

    }

            public void selectFunctionalApproval () {


                driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]")).click();

                WebElement plusIcon = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[10]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/button[1]/img[1]"));
                JavascriptExecutor js = (JavascriptExecutor) driver; //ElementClickInterceptedException
                js.executeScript("arguments[0].click()", plusIcon);


                Select select = new Select(driver.findElement(By.name("USER_ID")));
                select.selectByVisibleText("Rafi (null)");
                js.executeScript("arguments[0].click()", select);

                Select select3 = new Select(driver.findElement(By.name("REVIEWER_TYPE")));
                select3.selectByVisibleText("Lead");
                js.executeScript("arguments[0].click()", select3);


            }

            public void selectQualityApproval () {

                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("window.scrollBy(0,300)");


                WebElement plusIcon = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/button[1]/img[1]"));
                JavascriptExecutor js = (JavascriptExecutor) driver; //ElementClickInterceptedException
                js.executeScript("arguments[0].click()", plusIcon);


                Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                WebElement iName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/select[1]")));

        /* iName.click();  //qualityApprovalName
        WebElement text = driver.findElement(By.xpath("//option[contains(text(),'Rafi (null)')]"));
        text.click();
        */
                Select select = new Select(iName);
                select.selectByVisibleText("Rafi (null)");


                WebElement aType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/select[1]")));
                Select select2 = new Select(aType);
                select2.selectByVisibleText("Lead");

                //driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content-wrapper']/div[@id='content']/div[@id='container-wrapper']/div[1]/fieldset[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[5]/select[1]/option[2]")).click();

            }
        }





