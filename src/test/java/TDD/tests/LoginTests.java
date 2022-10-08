package TDD.tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;




public class LoginTests extends BaseTest {
    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

        homePage
            .goToHomePage()
            .signInToInventoryPage("standard_user","secret_sauce")
                .verifyInventoryPage()
                ;
    }

    private void startTest(String name, String s) {
    }

    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    public void invalidLoginTest_EmptyUserEmptyPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");

        homePage
            .goToHomePage()
                .signInToInventoryPage("locked_out_user","secret_sauce");

    }
}