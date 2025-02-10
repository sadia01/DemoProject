package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseDriver {
    protected WebDriver driver; // Instance-level driver
    public String urlName;
    protected Properties prop;
    protected static String defaultUrl = "https://www.tutorialspoint.com/selenium/practice/login.php"; // Default URL

    @BeforeMethod
    public void setUp() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "\\src\\test\\java\\data\\GlobalData.properties");
        prop.load(fis);

        urlName = System.getProperty("url") != null ? System.getProperty("url") :
                (prop.getProperty("url") != null ? prop.getProperty("url") : defaultUrl);

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options); // Initialize instance-level driver
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(); // Initialize instance-level driver
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(); // Initialize instance-level driver
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        PageDriver.setDriver(driver); // Set in ThreadLocal
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("AfterSuite: Quitting all drivers");
        PageDriver.quitAllDrivers(); // Use PageDriver to quit and clear all drivers
    }
}