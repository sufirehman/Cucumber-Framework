package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;  // Accept WebDriver instance as a parameter
    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;  // Initialize WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkout_click() {
        try {
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'CHECKOUT')]")));
            checkoutButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking the checkout button: " + e.getMessage());
        }
    }

    public void fill_shipping_info()
    {
        WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("first-name"))));
        first_name.sendKeys("Automation First Name");
        WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("last-name"))));
        last_name.sendKeys("Automation Last Name");
        WebElement postal_code = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("postal-code"))));
        postal_code.sendKeys("LAP98X");
    }
    public void continue_click()
    {
        WebElement Continue = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[type='submit']"))));
        Continue.click();
    }
    public void finish_click()
    {
        WebElement Finish = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("FINISH"))));
        Finish.click();
    }
    public void order_placed() {
        WebElement verifyOrder = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("complete-header")));
        String actualText = verifyOrder.getText();
        String expectedText = "THANK YOU FOR YOUR ORDER";
        Assert.assertTrue("Order confirmation message does not contain expected text!", actualText.contains(expectedText));
    }


}
