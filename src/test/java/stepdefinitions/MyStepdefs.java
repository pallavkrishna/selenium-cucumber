package stepdefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utils.extentreports.ExtentManager;
import utils.logs.Log;


public class MyStepdefs {

    WebDriver driver;

    @Given("Opening the {string} browser launching the {string}")
    public void openingTheBrowserLaunchingThe(String arg0, String url) {
        ExtentManager.createExtentTest(arg0,"saucedemo");
        Log.info(arg0);
        driver=WebDriverManager.chromedriver().driverVersion("105.0.5195.19").create();
        ExtentManager.logStep(Status.PASS,"Opening "+arg0+" browser");
        driver.get(url);
        ExtentManager.logStep(Status.PASS,"launching the "+url);
        Log.info("Title of the page is "+driver.getTitle());
        Log.info("Title of the page is "+driver.getTitle());
        ExtentManager.logStep(Status.INFO,"page Title is "+driver.getTitle());

    }

    @Then("close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }
}
