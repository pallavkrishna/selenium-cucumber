package TDD.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

public class HomePage extends BasePage {
    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "https://www.saucedemo.com/";

    /**
     * Web Elements
     */
    By userNameTextField = By.id("user-name");
    By passWordTextField = By.id("password");
    By submitButton =By.id("login-button");

    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage goToHomePage() {
        Log.info("Opening spectrum business page");
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public InventoryPage signInToInventoryPage(String userName,String password) {
        Log.info("Going to Inventory Page..");
        writeText(userNameTextField,userName);
        writeText(passWordTextField,password);
        click(submitButton);
        return new InventoryPage(driver);
    }
}