//package StepDefinitions;
//
//import Utility.BrowserDriver;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Then;
//import org.openqa.selenium.WebDriver;
//import pages.CheckoutPage;
//
//public class checkout {
//    private WebDriver driver;
//    private CheckoutPage checkoutPage;
//
//    @Before
//    public void setUp() {
//        this.driver = BrowserDriver.getDriver();
//        this.checkoutPage = new CheckoutPage(driver);
//    }
//    @Then("user click on checkout button")
//    public void click_on_checkout()
//    {
//        checkoutPage.checkout_click();
//    }
//    @Then("user fill shipping information")
//    public void fill_shipping_details()
//    {
//        checkoutPage.fill_shipping_info();
//    }
//    @Then("user click on continue button")
//    public void click_on_continue()
//    {
//        checkoutPage.continue_click();
//    }
//    @Then("user click on finish button")
//    public void click_on_finish()
//    {
//        checkoutPage.finish_click();
//    }
//    @Then("user should able to successfully place an order")
//    public void place_order()
//    {
//        checkoutPage.order_placed();
//    }
//    @After
//    public void tearDown() {
//        BrowserDriver.closeDriver();
//    }
//}

package StepDefinitions;

import Utility.BrowserDriver;
import Utility.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class checkout {
    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private ExtentReports extent;
    private ExtentTest Test;
    @Before
    public void setUp(Scenario scenario) {
        this.driver = BrowserDriver.getDriver();
        this.checkoutPage = new CheckoutPage(driver);
        extent = ExtentManager.getInstance();
        Test = extent.createTest(scenario.getName());
    }

    @Then("user click on checkout button")
    public void click_on_checkout() {
        Test.info("Clicking on Checkout");
        checkoutPage.checkout_click();
    }

    @Then("user fill shipping information")
    public void fill_shipping_details() {

        Test.info("Fill in shipping details");
        checkoutPage.fill_shipping_info();
    }

    @Then("user click on continue button")
    public void click_on_continue() {

        Test.info("Click on continue button");
        checkoutPage.continue_click();
    }

    @Then("user click on finish button")
    public void click_on_finish() {

        Test.info("Click on Finish Button");
        checkoutPage.finish_click();
    }

    @Then("user should able to successfully place an order")
    public void place_order() {

        Test.info("Order Placed Successfully");
        checkoutPage.order_placed();
    }

    @After
    public void tearDown() {
        BrowserDriver.closeDriver();
        extent.flush();
    }
}

