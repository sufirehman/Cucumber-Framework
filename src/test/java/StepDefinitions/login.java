//package StepDefinitions;
//
//import Utility.BrowserDriver;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.*;
//import pages.LoginPage;
//import org.openqa.selenium.WebDriver;
//
//public class login {
//    private WebDriver driver;
//    private LoginPage loginPage;
//
//    // Hook to initialize driver before the scenario
//    @Before
//    public void setUp() {
//        this.driver = BrowserDriver.getDriver();
//        this.loginPage = new LoginPage(driver);
//    }
//    @Then("user should able to access login screen")
//    public void verifyLoginScreen() {
//        if (loginPage.isLoginButtonVisible()) {
//            System.out.println("Login button is visible. Proceeding with login...");
//        }
//    }
//    @Given("user opens sauce labs website")
//    public void i_open_saucelabs_website() {
//        loginPage.initializesite();
//    }
//
//    @When("user successfully login to the website")
//    public void loginfunction() {
//        loginPage.loginwebsite("standard_user", "secret_sauce");
//    }
//
//    @Then("user enter incorrect details to the website")
//    public void incorrect_login()
//    {
//        loginPage.loginwebsite("locked_out_user", "secret_sauce");
//    }
//    @Then("user should observe an error Epic sadface: Sorry, this user has been locked out.")
//    public void error_msg()
//    {
//        loginPage.extractmsg();
//    }
//    @After
//    public void tearDown() {
//        BrowserDriver.closeDriver();
//    }
//}
package StepDefinitions;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import Utility.BrowserDriver;

public class login {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        this.driver = BrowserDriver.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("user opens sauce labs website")
    public void i_open_saucelabs_website() {
        loginPage.initializesite();
    }

    @Then("user should be able to access login screen")
    public void verifyLoginScreen() {
        if (loginPage.isLoginButtonVisible()) {
            System.out.println("Login button is visible. Proceeding with login...");
        }
    }

    @When("user successfully login to the website")
    public void loginfunction() {
        loginPage.loginwebsite("standard_user", "secret_sauce");
    }

    @Then("user enter incorrect details to the website")
    public void incorrect_login() {
        loginPage.loginwebsite("locked_out_user", "secret_sauce");
    }

    @Then("user should observe an error Epic sadface: Sorry, this user has been locked out.")
    public void error_msg() {
        loginPage.extractmsg();
    }

    @After
    public void tearDown() {
        BrowserDriver.closeDriver();
    }
}


