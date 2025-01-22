package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.PersonalAuto_Ext;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SubmissionScenarioPA extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final PersonalAuto_Ext personalAuto = new PersonalAuto_Ext();
    public Map<String, String> submissionPAJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/PersonalAuto.json"), StandardCharsets.UTF_8));

    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;


    public SubmissionScenarioPA() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create a New Submission PA with json data")
    public void newSubmissionPA() throws IOException, ParseException {
        System.out.println("printing global in nb" + globalData);
        for (String key : submissionPAJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + personalAuto.getLocator(key) + " || " + submissionPAJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if(key.contains("_")){
                String key1= key.split("_")[1];
                if(key1.equals("First name")){
                    String currentDateTime = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                    String firstName= currentDateTime+"_"+globalData.get(key);
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(personalAuto.getLocator(key1), submissionPAJson.get(Actualkey), firstName);
                    continue;
                }
                System.out.println("entered for key " + Actualkey + "printing get locator " + personalAuto.getLocator(key1) + "Printing fnoljson key " + submissionPAJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(personalAuto.getLocator(key1), submissionPAJson.get(Actualkey), globalData.get(key));
                continue;

            }
            if(Actualkey.startsWith("PolicyChange"))
                continue;

            System.out.println("entered for key " + Actualkey + "printing get locator " + personalAuto.getLocator(key) + "Printing fnoljson key " + submissionPAJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(personalAuto.getLocator(key), submissionPAJson.get(Actualkey), globalData.get(key));
        }
    }
}






