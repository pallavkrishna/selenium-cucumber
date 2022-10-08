package TDD.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.extentreports.ExtentManager;

import utils.logs.Log;

import java.time.Duration;

public class BasePage {
    public WebDriver     driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
    }

    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void verifyTitleOfThePage(String expectedTitle){
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Log.info("Expected title :"+expectedTitle );
        Log.info("Actual title :"+driver.getTitle() );
        Assert.assertEquals(expectedTitle,driver.getTitle(),"verifying the title of the page");
        ExtentManager.getTest().log(Status.PASS,"\""+driver.getTitle()+"\" verified successfully");
    }
    public void LogoutPage(){

    }
}