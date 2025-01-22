package actions.pc;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.Homeowners_Ext;
import pages.pc.PersonalAuto_Ext;
import pages.pc.PolicyChange;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class PolicyChangeScenario extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final Homeowners_Ext homeOwners = new Homeowners_Ext();
    private final PersonalAuto_Ext personalAuto = new PersonalAuto_Ext();
    public Map<String, String> submissionHOJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/Homeowners.json"), StandardCharsets.UTF_8));
    public Map<String, String> submissionPAJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/PersonalAuto.json"), StandardCharsets.UTF_8));
    public Map<String, String> workersCompensationJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/workersCompensation.json"), StandardCharsets.UTF_8));
    public Map<String, String> initiatePolicyChangeJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/initiatePolicyChange.json"), StandardCharsets.UTF_8));
    public Map<String, String> commercialAutoJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/commercialAuto.json"), StandardCharsets.UTF_8));
    public Map<String, String> inlandMarineJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/InlandMarine.json"), StandardCharsets.UTF_8));

    private final PolicyChange policyChange = new PolicyChange();
    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;


    public PolicyChangeScenario() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Initiate Policy Change")
    public void initiatePolicyChange() throws IOException, ParseException {
        dataDrivenMethods.clickAnyButton("Actions");
        dataDrivenMethods.clickAnyButton("Change Policy");
        dataDrivenMethods.setValueForFieldWithInput("Description","Test");
        dataDrivenMethods.clickAnyButton("Next >");
    }

    @Step("Execute HO Policy Change")
    public void policyChangeHO() throws IOException, ParseException {
        String locator = "";
        System.out.println("printing global in polchg" + globalData);
        for (String key : submissionHOJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + homeOwners.getLocator(key) + " || " + submissionHOJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (Actualkey.startsWith("PolicyChange")) {
                if (key.equals("Next") || key.equals("Next2") || key.equals("Next3")) {
                    dataDrivenMethods.clickAnyButton("Next");
                    continue;
                }
                if (key.contains("_"))
                    locator = key.split("_")[1];
                System.out.println("entered for key " + Actualkey + "printing get locator " + homeOwners.getLocator(key) + "Printing fnoljson key " + submissionHOJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(homeOwners.getLocator(locator), submissionHOJson.get(Actualkey), globalData.get(key));
            }
        }
    }

    @Step("Execute PA Policy Change")
    public void policyChangePA() throws IOException, ParseException {
        for (String key : submissionPAJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + personalAuto.getLocator(key) + " || " + submissionPAJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (Actualkey.startsWith("PolicyChange")) {
                if (key.equals("Next") || key.equals("Next2") || key.equals("Next3") || key.equals("Next4")) {
                    dataDrivenMethods.clickAnyButton("Next");
                    continue;
                }

                System.out.println("entered for key " + Actualkey + "printing get locator " + personalAuto.getLocator(key) + "Printing fnoljson key " + submissionPAJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(personalAuto.getLocator(key), submissionPAJson.get(Actualkey), globalData.get(key));
            }
        }
    }
    @Step("Initiate Change Policy transaction")
    public void initiateChangePolicyTransaction() throws InterruptedException {
        for (String key : initiatePolicyChangeJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + policyChange.getLocator(key) + " || " + initiatePolicyChangeJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(policyChange.getLocator(key), initiatePolicyChangeJson.get(Actualkey), globalData.get(key));
        }
    }
    @Step("Update values during CA Policy Change transaction")
    public void updateValuesCAPolicyChangeTransaction() throws InterruptedException {
        for (String key : commercialAutoJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + policyChange.getLocator(key) + " || " + commercialAutoJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(policyChange.getLocator(key), commercialAutoJson.get(Actualkey), globalData.get(key));
        }
    }
    @Step("Verify policy change bound message")
    public void verifyPolicyChangeBoundMessage() {
        String actualValue= dataDrivenMethods.gettingText(policyChange.getLocator("Submission Message"));
        String expectedValue="Your Policy Change has been bound.";
        actualValue=actualValue.replaceAll("[^A-Za-z]","");
        expectedValue=expectedValue.replaceAll("[^A-Za-z]","");
        dataDrivenMethods.assertExpectedAndActualText(actualValue, expectedValue);
    }
    @Step("Update values during WC Policy Change transaction")
    public void updateValuesWCPolicyChangeTransaction() {
        for (String key : workersCompensationJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + policyChange.getLocator(key) + " || " + workersCompensationJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(policyChange.getLocator(key), workersCompensationJson.get(Actualkey), globalData.get(key));
        }
    }
    @Step("Update values during IM Policy Change transaction")
    public void updateValuesIMPolicyChangeTransaction() throws InterruptedException {
        for (String key : inlandMarineJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + policyChange.getLocator(key) + " || " + inlandMarineJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            String actionType=null;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
                actionType=keysplitted[0];
            }
            if(actionType.equals("PolicyChange"))
            {
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(policyChange.getLocator(key), inlandMarineJson.get(Actualkey), globalData.get(key));
            }
            }
        }
    }

