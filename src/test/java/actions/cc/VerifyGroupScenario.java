package actions.cc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cc.VerifyGroup;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class VerifyGroupScenario extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final VerifyGroup group = new VerifyGroup();
    public Map<String, String> groupJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/VerifyGroup.json"), StandardCharsets.UTF_8));


    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;



    public VerifyGroupScenario() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

       @Step("Verify User using the required Test Data")
    public void verifyGroup() throws IOException, ParseException {
        for (String key : groupJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + group.getLocator(key) + " || " + groupJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + group.getLocator(key) + "Printing fnoljson key " + groupJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(group.getLocator(key), groupJson.get(Actualkey), globalData.get(key));

        }
    }

}






