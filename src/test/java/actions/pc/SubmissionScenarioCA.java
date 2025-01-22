package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.BusinessOwner_Ext;
import pages.pc.ComercialAuto_Ext;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SubmissionScenarioCA extends Driver{

    private final ComercialAuto_Ext commercialAuto = new ComercialAuto_Ext();

    String Actualkey;

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();

    public Map<String, String> commercialAutoJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/commercialAuto.json"), StandardCharsets.UTF_8));

    public Map<String, String> locationJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/locations.json"), StandardCharsets.UTF_8));

    public SubmissionScenarioCA() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create a Commercial Auto new Submission using the required Test Data")
    public void newSubmissionCA() throws IOException, ParseException {
        System.out.println("printing global in nb" + globalData);
        for (String key : commercialAutoJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + commercialAuto.getLocator(key) + " || " + commercialAutoJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + commercialAuto.getLocator(key) + "Printing fnoljson key " + commercialAutoJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(commercialAuto.getLocator(key), commercialAutoJson.get(Actualkey), globalData.get(key));

            if (key.contains("Location")){

                dataDrivenMethods.getAllMethodsToPerformRequiredActions(commercialAuto.getLocator(key), locationJson.get(Actualkey), globalData.get(key));
            }

        }
    }
}
