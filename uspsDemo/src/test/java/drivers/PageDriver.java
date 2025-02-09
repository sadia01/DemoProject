package drivers;
import org.openqa.selenium.WebDriver;

public class PageDriver {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // No instance variable needed
    // No private constructor needed (can use default)

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static synchronized void setDriver(WebDriver webDriver) { // Added synchronized keyword
        driver.set(webDriver);
    }

    public static void quitDriver() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove(); // Important: Remove from ThreadLocal
        }
    }
}

