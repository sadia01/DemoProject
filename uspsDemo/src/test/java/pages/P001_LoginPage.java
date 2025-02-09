package pages;

import org.openqa.selenium.WebDriver; // Import WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class P001_LoginPage extends CommonMethods {

    private WebDriver driver; // Add a driver instance variable

    public P001_LoginPage(WebDriver driver) { // Constructor now takes a WebDriver
        this.driver = driver; // Initialize the driver
        PageFactory.initElements(driver, this); // Initialize PageFactory with the correct driver
    }

    // ... (rest of your element locators and methods remain the same)

    @FindAll({
            @FindBy(id = "login_email"),
            @FindBy(xpath = "//input[@id='login_email']")
    })
    WebElement userEmailInput;

    @FindAll({
            @FindBy(id = "login_password"),
            @FindBy(xpath = "//input[@id='login_password']")
    })
    WebElement userPasswordInput;

    @FindAll({
            @FindBy(id = "sign_in_btn"),
            @FindBy(css = "button#sign_in_btn")
    })
    WebElement loginButton;

    public void fillLoginDetails(String loginEmail, String loginPassword) {
        sendText(userEmailInput, loginEmail);
        sendText(userPasswordInput, loginPassword);
        hoverClickElement(loginButton);
        timeOut();
    }
}