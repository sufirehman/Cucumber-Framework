//package StepDefinitions;
//
//import Utility.BrowserDriver;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class logout {
//    private WebDriver driver;
//
//    // Hook to initialize driver before the scenario
//    @Before
//    public void setUp() {
//        this.driver = BrowserDriver.getDriver();
//    }
//
//    @Then("user clicks on menu button")
//    public void click_on_menu() {
//        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
//    }
//
//    @Then("user perform logout")
//    public void logout() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logout_sidebar_link\"]")));
//        logoutLink.click();
//    }
//
//    // Hook to close the driver after the scenario
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import cucumber.api.java.en.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class logout {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;
    @Before
    public void setUp(Scenario scenario) {

        extent = ExtentManager.getInstance();
        test = extent.createTest(scenario.getName());
        this.driver = BrowserDriver.getDriver();
    }


    @Then("user clicks on menu button")
    public void click_on_menu() {
        test.info("user clicks on menu button");
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
    }

    @Then("user perform logout")
    public void logout() {
        test.info("user click on logout");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"bm-item-list\"]/descendant::*[3]")));
        logoutLink.click();
    }
    @After
    public void tearDown() {
        BrowserDriver.closeDriver();
    }
}

