package debug;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

public class TestLogger {


    public void logg() {
        Log.info("log info ");

        Log.debug("debug info ");


        WebDriver driver = WebDriverManager.chromedriver().driverVersion("105.0.5195.19").create();
        driver.get("https://www.saucedemo.com");
        Log.info("Title of the page is " + driver.getTitle());
    }
}
