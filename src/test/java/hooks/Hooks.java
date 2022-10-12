package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.extentreports.ExtentManager;


public class Hooks {
    @Before
    public void setUp(){
        System.out.println("Before Hooks");
    }

    @After
    public void tearDown(Scenario scenario){
       // System.out.println("After Hooks");
      //RUNS AFTER EACH SCENARIO
        //
        ExtentManager.closeExtentReport();

    }

}
