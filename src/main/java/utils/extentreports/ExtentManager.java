package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.logs.Log;

import java.io.IOException;

public class ExtentManager {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReports;

    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    public static ExtentReports intiExtentConfig(String reportName) {
        try {
            String reportPath="./extent-report/" + reportName;
            Log.info("Extent report path is "+reportPath);
            sparkReporter = new ExtentSparkReporter( reportPath + ".html");
            JsonFormatter jsonFormatter = new JsonFormatter( reportPath + ".json");
            extentReports = new ExtentReports();
            extentReports.createDomainFromJsonArchive(reportPath + ".json");
            extentReports.attachReporter(jsonFormatter, sparkReporter);
            sparkReporter.config().setReportName("Test Automation Report");
            sparkReporter.config().setTheme(Theme.STANDARD);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extentReports;
    }

    public static void createNode() {
        ExtentTest test = extentReports.createTest("MyFirstTest");
        ExtentTest node1 = test.createNode("Node");
        node1.pass("Pass");

// fluent
        ExtentTest node = extentReports.createTest("MyFirstTest")
                .createNode("Node")
                .pass("Pass");

    }

    public static void createExtentBBDTest() {
        ExtentTest feature = null;
        try {
            feature = extentReports.createTest(new GherkinKeyword("Feature"), "Refund item");

            ExtentTest scenario = feature.createNode(new GherkinKeyword("Scenario"), "Jeff returns a faulty microwave");
            scenario.createNode(new GherkinKeyword("Given"), "Jeff has bought a microwave for $100").pass("pass");
            scenario.createNode(new GherkinKeyword("And"), "he has a receipt").pass("pass");
            scenario.createNode(new GherkinKeyword("When"), "he returns the microwave").pass("pass");
            scenario.createNode(new GherkinKeyword("Then"), "Jeff should be refunded $100").fail("fail");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void createExtentTest(String reportName, String testName) {
        extentTestThreadLocal.set(intiExtentConfig(reportName).createTest(testName));
    }

    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    public static void logStep(Status status,String desc){
        getExtentTest().log(status,desc);
    }
    public static void closeExtentReport() {
        extentReports.flush();
    }


}
