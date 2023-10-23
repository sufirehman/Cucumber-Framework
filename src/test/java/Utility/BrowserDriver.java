//package Utility;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//public class BrowserDriver {
//    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
//
//    private BrowserDriver() {
//    }
//
//    public static WebDriver getDriver() {
//        if (driverThreadLocal.get() == null) {
//            initializeDriver();
//        }
//        return driverThreadLocal.get();
//    }
//
//    private static void initializeDriver() {
//        String browserType = System.getProperty("browser", "chrome");
//        WebDriver driver;
//        switch (browserType.toLowerCase()) {
//            case "chrome":
//                // Set the system property to use ChromeDriver from resources folder
//                System.setProperty("webdriver.chrome.driver", BrowserDriver.class.getClassLoader().getResource("resources/drivers/chromedriver.exe").getPath());
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                // Set the system property to use GeckoDriver from resources folder
//                System.setProperty("webdriver.gecko.driver",
//                        BrowserDriver.class.getClassLoader().getResource("resources/drivers/geckodriver.exe").getPath());
//                FirefoxOptions options = new FirefoxOptions();
//                driver = new FirefoxDriver(options);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid browser type: " + browserType);
//        }
//        driverThreadLocal.set(driver);
//    }
//
//    public static void closeDriver() {
//        WebDriver driver = driverThreadLocal.get();
//        if (driver != null) {
//            driver.quit();
//            driverThreadLocal.remove();
//        }
//    }
//}

package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriver {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private BrowserDriver() {

    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            initializeDriver();
        }
        return driverThreadLocal.get();
    }

    private static void initializeDriver() {
        String browserType = System.getProperty("browser", "chrome");
        WebDriver driver;
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
        driverThreadLocal.set(driver);
    }


    public static void closeDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
