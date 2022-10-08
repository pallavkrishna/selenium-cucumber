package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.logs.Log;

import java.util.HashMap;
import java.util.Map;

public class ExtentManager {


    private static final ExtentReports extentReports = new ExtentReports();
    ExtentHtmlReporter htmlReporter =  new

            ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/extentReport.html");

    public static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Automation Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Report", "Test Automation Report");
        extentReports.setSystemInfo("Author", System.getProperty("hostname"));
        return extentReports;
    }
    public static ExtentTest getTest(){
       return extentReports.createTest("");
    }

}