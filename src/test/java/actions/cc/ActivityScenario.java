package actions.cc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cc.Activity;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class ActivityScenario extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final Activity act = new Activity();
    public Map<String, String> activityJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/Activity.json"), StandardCharsets.UTF_8));


    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;



    public ActivityScenario() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

       @Step("Create Activity using the required Test Data")
        public void createActivity() throws IOException, ParseException {
        for (String key : activityJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + act.getLocator(key) + " || " + activityJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Search") || key.equals("Activities") || key.equals("Choice") ||key.equals("Claim #")) {
                continue;
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + act.getLocator(key) + "Printing fnoljson key " + activityJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(act.getLocator(key), activityJson.get(Actualkey), globalData.get(key));

        }
    }
    @Step("Search Activity using the required Test Data")
    public void searchActivity() throws IOException, ParseException {
        for (String key : activityJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + act.getLocator(key) + " || " + activityJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Actions") || key.equals("Interview") || key.equals("Activity Type") ||key.equals("Description")||key.equals("Update")) {
                continue;
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + act.getLocator(key) + "Printing fnoljson key " + activityJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(act.getLocator(key), activityJson.get(Actualkey), globalData.get(key));

        }
    }

}






