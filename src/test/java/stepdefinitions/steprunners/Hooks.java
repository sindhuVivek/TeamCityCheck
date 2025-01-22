package stepdefinitions.steprunners;

// Selenium imports
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

// Framework imports
import utilities.common.ConfigReader;
import utilities.common.Driver;

public class Hooks extends ConfigReader {

    //Create an instance of driver to be assigned and built later.
    private Driver driverCreation;
    private ConfigReader configReader;

    //Before each scenario is run set the following up and navigate to the URL
    // in the config
    @Before
    public void getProperties() {

        configReader = new ConfigReader();
        driverCreation = new Driver();
        driverCreation.setThreadDriver();

    }


    //After each step take a screenshot if the config value is set to yes.
    // Only works when running via MVN command/full suite runs.
    @AfterStep
    public void takeScreenshot() {

        if (configReader.getConfigValue("screenshot").
                equalsIgnoreCase("yes")) {

            Allure.addAttachment("Step screenshot", new ByteArrayInputStream(
                    ((TakesScreenshot) Driver.getThreadDriver()).
                            getScreenshotAs(OutputType.BYTES)));

        }

    }


    //After the test has finished quit the driver session and take the screenshot
    @After
    public void tearDown() {

        Allure.addAttachment("End of test screenshot", new ByteArrayInputStream(
                ((TakesScreenshot) Driver.getThreadDriver()).
                        getScreenshotAs(OutputType.BYTES)));

        Driver.getThreadDriver().quit();

    }

}