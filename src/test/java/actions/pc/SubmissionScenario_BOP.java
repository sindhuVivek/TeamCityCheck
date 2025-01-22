package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.BusinessOwner_Ext;
import pages.pc.Homeowners_Ext;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SubmissionScenario_BOP extends Driver {

    private final BusinessOwner_Ext businessOwners = new BusinessOwner_Ext();
    private WebDriverWait wait;

    String Actualkey;

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();

    public Map<String, String> submissionBOPJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/BusinessOwners.json"), StandardCharsets.UTF_8));

    public SubmissionScenario_BOP() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create a Business Owner new Submission using the required Test Data")
    public void newSubmissionBOP() throws IOException, ParseException {
        System.out.println("printing global in nb" + globalData);
        for (String key : submissionBOPJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + businessOwners.getLocator(key) + " || " + submissionBOPJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + businessOwners.getLocator(key) + "Printing fnoljson key " + submissionBOPJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(businessOwners.getLocator(key), submissionBOPJson.get(Actualkey), globalData.get(key));


        }
    }

}
