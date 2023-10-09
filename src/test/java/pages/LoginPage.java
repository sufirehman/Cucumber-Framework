package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver; // Initialize WebDriver instance
    }

    public void initializesite() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    public boolean isLoginButtonVisible() {
        try {
            WebElement loginButton = driver.findElement(By.id("login-button"));
            return loginButton.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void extractmsg() {
//        System.out.println("Now error msg");
        String actual_text = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        System.out.println(actual_text);
        String expected_text = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals("Error Message not same", expected_text, actual_text);
    }

    public void loginwebsite(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}
