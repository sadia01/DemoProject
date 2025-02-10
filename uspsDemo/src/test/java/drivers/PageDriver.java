package drivers;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class PageDriver {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final List<WebDriver> driverPool = new ArrayList<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static synchronized void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
        driverPool.add(webDriver);
    }

    public static void quitAllDrivers() {
        for (WebDriver driver : driverPool) {
            if (driver != null) {
                driver.quit();
            }
        }
        driverPool.clear();
    }
}

