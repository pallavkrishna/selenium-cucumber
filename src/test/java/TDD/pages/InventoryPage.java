package TDD.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.extentreports.ExtentManager;
import utils.logs.Log;

public class InventoryPage extends BasePage {
    /**
     * Constructor
     */
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    By burgerMenu=By.cssSelector(".bm-burger-button");
    By logoutBtn=By.xpath("//a[text()='Logout']");

    public LogoutPage verifyInventoryPage(){
        Log.info("Clicking on logout button");
        waitVisibility(burgerMenu).click();
        waitVisibility(logoutBtn).click();
        ExtentManager.getTest().log(Status.PASS,"clicking on logout button");

        Log.info("Going to logout Page..");
        //click(shopOfferBtn);
        return new LogoutPage(driver);
    }

}
