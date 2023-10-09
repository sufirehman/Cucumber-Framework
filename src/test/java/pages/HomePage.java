package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;  // Initialize WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click_on_saucelabs() {
        WebElement saucelabsBackpack = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        saucelabsBackpack.click();
    }
}
