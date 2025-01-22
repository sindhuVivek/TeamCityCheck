package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class SubmissionScenarioHO extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final Homeowners_Ext homeOwners = new Homeowners_Ext();
    public Map<String, String> submissionHOJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/Homeowners.json"), StandardCharsets.UTF_8));

    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;


    public SubmissionScenarioHO() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create a New Submission HO with json data")
    public void newSubmissionHO() throws IOException, ParseException {
        System.out.println("printing global in nb" + globalData);
        for (String key : submissionHOJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + homeOwners.getLocator(key) + " || " + submissionHOJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("PolicyNumberFetch")) {
                String polNum = dataDrivenMethods.gettingText("//div[@id=\"JobComplete-JobWizardInfoBar-PolicyNumber\"]/div[2]");
                System.out.println("Submission Issued Successfully | Policy number : " + polNum);
                continue;
            }
            if(Actualkey.startsWith("PolicyChange"))
                continue;

            System.out.println("entered for key " + Actualkey + "printing get locator " + homeOwners.getLocator(key) + "Printing fnoljson key " + submissionHOJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(homeOwners.getLocator(key), submissionHOJson.get(Actualkey), globalData.get(key));
        }
    }


}






