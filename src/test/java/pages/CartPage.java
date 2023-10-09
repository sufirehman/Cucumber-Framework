package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;  // Accept WebDriver instance as a parameter
    private final WebDriverWait wait;
    public static List<String> GLOBAL_ATC_PRODUCT = new ArrayList<>();

    public CartPage(WebDriver driver) {
        this.driver = driver;  // Initialize WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void product_to_cart() {
        WebElement productButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button")));
        productButton.click();
        //GLOBAL_ATC_PRODUCT.add(productName.getText());
    }

    public void cart_click() {
        System.out.println("Clicking on cart");
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_container")));
        cartButton.click();
        System.out.println("Cart clicked");
    }

    public void verify_product() {
        WebElement firstItem = driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        Assert.assertTrue("Product not found in the cart!", firstItem.getText().equals("Sauce Labs Backpack"));
    }

    public void click_on_remove() {
        WebElement button_remove = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button"));
        button_remove.click();
    }


}
