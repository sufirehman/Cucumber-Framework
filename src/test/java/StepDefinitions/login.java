
package StepDefinitions;

import Utility.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import Utility.BrowserDriver;
import cucumber.api.Scenario;
public class login {
    private WebDriver driver;
    private LoginPage loginPage;
    private ExtentReports extent;
    private ExtentTest test;
    @Before
    public void setUp(Scenario scenario) {
        extent = ExtentManager.getInstance();
        test = extent.createTest(scenario.getName());
        this.driver = BrowserDriver.getDriver();
        this.loginPage = new LoginPage(driver);

    }

    @Given("user opens sauce labs website")
    public void i_open_saucelabs_website() {
        test.info("user opens sauce labs website");
        loginPage.initializesite();
    }

    @Then("user should be able to access login screen")
    public void verifyLoginScreen() {
        if (loginPage.isLoginButtonVisible()) {
            test.info("login screen visible");
            System.out.println("Login button is visible. Proceeding with login...");
        }
    }

    @When("user successfully login to the website")
    public void loginfunction() {

        test.info("login successful");
        loginPage.loginwebsite("standard_user", "secret_sauce");
    }

    @Then("user enter incorrect details to the website")
    public void incorrect_login() {

        test.info("incorrect details entered");
        loginPage.loginwebsite("locked_out_user", "secret_sauce");
    }

    @Then("user should observe an error Epic sadface: Sorry, this user has been locked out.")
    public void error_msg() {

        test.info("error on incorrect credentials");
        loginPage.extractmsg();
    }

    @After
    public void tearDown() {
        BrowserDriver.closeDriver();
        extent.flush();
    }
}


