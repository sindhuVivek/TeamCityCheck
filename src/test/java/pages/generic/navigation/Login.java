package pages.generic.navigation;

// Selenium imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

// Framework imports
import utilities.common.ConfigReader;
import utilities.common.Driver;

public class Login  extends Driver{

    private WebDriver driver;

    public Login() {
        this.driver = Driver.getThreadDriver();
    }

    //Page objects
    By btnSubmit = By.id("Login-LoginScreen-LoginDV-submit");
    By usernameInput = By.xpath("//*[text()='Username']/" +
            "following::input | //*[text()='User name']/following::input");
    By passwordInput = By.xpath("//*[text()='Password']/" +
            "following::input");

    // Generic login method to pass the application and username and password
    public void genericLogin(String application) {

        // Initialise config reader
        ConfigReader configReader = new ConfigReader();

        // If statement to read application name
        if (application.equalsIgnoreCase("PolicyCenter")) {

            // Open desired URL
            Driver.getThreadDriver().get(configReader.
                    getConfigValue("pc_url"));

            // If statement to read application name
        } else if (application.equalsIgnoreCase("ClaimsCenter")) {

            // Open desired URL
            Driver.getThreadDriver().get(configReader.
                    getConfigValue("cc_url"));

            // If statement to read application name
        } else if (application.equalsIgnoreCase("BillingCenter")) {

            // Open desired URL
            Driver.getThreadDriver().get(configReader.
                    getConfigValue("bc_url"));

        } else {

            // Fail due to no application name
            Assert.fail("No valid application name was provided. Please look at" +
                    " the step definition line and make sure you've spelt the" +
                    " name of the application correctly. We expect: " +
                    "PolicyCenter, ClaimsCenter or" +
                    "BillingCenter");

        }
        // Code to enter the login details
        //Enter username
        driver.findElement(usernameInput).sendKeys(configReader.getConfigValue("username"));

        //Enter password
        driver.findElement(passwordInput).sendKeys(configReader.getConfigValue("password"));

        //Click the submit button to log in
        driver.findElement(btnSubmit).click();

    }
}