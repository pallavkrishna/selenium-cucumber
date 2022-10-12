package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        monochrome = true,
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
/*
Runner class is user to run teh test cases
Runner connects feature files and step definitions
feature : path of the features folder
glue    : path of the step definitions
 */