package utilities;

import drivers.PageDriver; // Import PageDriver
import org.openqa.selenium.WebDriver; // Import WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonMethods {

    /************************
     * Get Current Page URL *
     ************************/

    public String currentPageUrl() {
        WebDriver driver = PageDriver.getDriver(); // Get driver from PageDriver
        return driver.getCurrentUrl();
    }

    /**************************
     * Get Current Page Title *
     **************************
     */

    public String getTitle() {
        WebDriver driver = PageDriver.getDriver(); // Get driver from PageDriver
        return driver.getTitle();
    }

    /************************************************************
     * Write in a input field                           *
     * @param element This is the target element where to write *
     * @param value   what to write                       *
     ************************************************************/

    public void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    /****************************************************************************
     * Perform Hover on an element                                   *
     * @param element This is the target element where to perform hover action  *
     ****************************************************************************/
    public void hoverClickElement(WebElement element) {
        WebDriver driver = PageDriver.getDriver(); // Get driver from PageDriver
        Actions actions = new Actions(driver); // Use the retrieved driver
        actions.moveToElement(element).click().perform();
    }

    // wait for default set seconds
    public void timeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}