package StepDefinitions;

import Utility.BrowserDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import cucumber.api.java.en.*;
import Utility.ExtentManager;
public class addToCart {
    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;
    private ExtentReports extent;
    private ExtentTest test;

    @Before
    public void setUp() {
        extent = ExtentManager.getInstance();
        test = extent.createTest("addToCart Test", "Verify adding and removing product from cart");

        this.driver = BrowserDriver.getDriver();
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
    }

    @Then("user clicks on Sauce Labs Backpack product")
    public void click_on_product() {
        homePage.click_on_saucelabs();
        test.log(Status.INFO, "Clicked on Sauce Labs Backpack product");
    }

    @Then("user adds Sauce Labs Backpack product to cart")
    public void add_to_cart() {
        cartPage.product_to_cart();
        test.log(Status.INFO, "Added Sauce Labs Backpack product to cart");
    }

    @Then("user click on cart")
    public void click_on_cart() {
        cartPage.cart_click();
        test.log(Status.INFO, "Clicked on cart");
    }

    @Then("user verify that the product should be added to the cart")
    public void product_cart() {
        cartPage.verify_product();
        test.log(Status.INFO, "Verified product in cart");
    }

    @Then("user remove product from shopping cart")
    public void remove_product() {
        cartPage.click_on_remove();
        test.log(Status.INFO, "Removed product from cart");
    }

    @Then("user verify that product is removed from the cart")
    public void verify_item_removed() {
        test.log(Status.PASS, "Verified product removed from cart");
    }

    @After
    public void tearDown() {
        BrowserDriver.closeDriver();
        extent.flush();
    }
}
