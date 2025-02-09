package tests;

import data.CredentialsDataProvider;
import drivers.BaseDriver;
import drivers.PageDriver;
import org.openqa.selenium.WebDriver; // Import WebDriver
import org.testng.annotations.Test;
import pages.P001_LoginPage;

public class LoginTest extends BaseDriver {

    @Test(dataProvider = "loginData", dataProviderClass = CredentialsDataProvider.class)
    public void testLogin(String loginEmail, String loginPassword) {
        WebDriver driver = PageDriver.getDriver(); // Get the driver from PageDriver (ThreadLocal)
        driver.get(urlName); // Use the retrieved driver

        P001_LoginPage loginPage = new P001_LoginPage(driver); // Pass the driver to the page object's constructor
        loginPage.fillLoginDetails(loginEmail, loginPassword);


    }
}