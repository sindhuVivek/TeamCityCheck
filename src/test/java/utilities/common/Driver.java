package utilities.common;

// Selenium imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class Driver {

    //Driver to be used whilst running the test
    public WebDriver driver;
    protected WebDriverWait wait;

    private ConfigReader configReader;

    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static String[] testDataIdArray;
    public static Map<String, String> globalData = new HashMap<>();
    public static Map<String, String> globalData_single =new HashMap<>();
    public static Map<String, String> globalData_multiple =new HashMap<>() ;
    //public static Map<String, String> globalData_single = null;
    //public static Map<String, String> globalData_multiple ;
    public static int testdataIdCount;

    //Return the driver when called
    public static synchronized WebDriver getThreadDriver(){

        return threadDriver.get();

    }

    //Set the driver variable when called.
    public WebDriver setThreadDriver() {

        configReader = new ConfigReader();
        if (configReader.getConfigValue("browser").
                equalsIgnoreCase("Chrome")) {

            if (configReader.getConfigValue("pipeline").
                    equalsIgnoreCase("yes")) {

                // Define WebDriverManager settings
                WebDriverManager.chromedriver().setup();

                // Add variables
                ChromeOptions options = new ChromeOptions();
                options.addArguments(
                        "--remote-debugging-port=9222",
                        "--no-sandbox",
                        "--enable-devtools",
                        "--remote-allow-origins=*",

                        //DevOps Parameter for headless mode
                        "--disable-web-security",
                        "--no-sandbox",
                        "--ignore-certificate-errors",
                        "--allow-running-insecure-content",
                        "--allow-insecure-localhost",
                        "--disable-gpu",
                        "--start-maximized",
                        "--disable-extensions",
                        "--remote-debugging-port=9222",
                        "--window-size=1792,1120");

                // Webdriver setup
                options.setExperimentalOption(
                        "useAutomationExtension", false);

                //Apply the options to the chrome driver instance before
                // running each test.
                threadDriver.set(new ChromeDriver(options));

            } else {

                //Setup chrome driver
                System.setProperty("webdriver.chrome.driver",
                        "drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();

                if (configReader.getConfigValue("headless").
                        equalsIgnoreCase("yes")) {

                    //Arguments if headless.
                    options.addArguments(
                            "--remote-debugging-port=9222",
                            "--no-sandbox",
                            "--enable-devtools",

                            // DevOps Parameter for headless mode
                            "--headless",
                            "--disable-web-security",
                            "--no-sandbox",
                            "--ignore-certificate-errors",
                            "--allow-running-insecure-content",
                            "--allow-insecure-localhost",
                            "--disable-gpu",
                            "--start-maximized",
                            "--disable-extensions",
                            "--remote-debugging-port=9222",
                            "--window-size=1792,1120");

                } else {

                    //Arguments if not headless
                    options.addArguments(
                            "--remote-debugging-port=9222",
                            "--no-sandbox",
                            "--enable-devtools",
                            "--disable-web-security",
                            "--no-sandbox",
                            "--ignore-certificate-errors",
                            "--allow-running-insecure-content",
                            "--allow-insecure-localhost",
                            "--disable-gpu",
                            "--start-maximized",
                            "--disable-extensions",
                            "--remote-debugging-port=9222",
                            "--remote-allow-origins=*");

                }

                options.setExperimentalOption(
                        "useAutomationExtension", false);

                //Apply the options to the chrome driver instance before
                // running each test.
                threadDriver.set(new ChromeDriver(options));

            }

            getThreadDriver().manage().timeouts().implicitlyWait(Duration.
                    ofSeconds(Long.parseLong(configReader.
                            getConfigValue("timeout"))));

        }

        return getThreadDriver();

    }

}