package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.CommonLocators_Ext;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.util.Map;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SubmissionScenarioCommon extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final CommonLocators_Ext comLoc = new CommonLocators_Ext();
    public Map<String, String> submissionJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/createSubmission.json"), StandardCharsets.UTF_8));
    public Map<String, String> quickQuoteJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/QuickQuote.json"), StandardCharsets.UTF_8));
    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;


    private boolean hasUWIssue = false;

    public SubmissionScenarioCommon() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Quote and Issue submission")
    public void quoteAndIssueSubmisison() throws IOException, ParseException {
        System.out.println("printing global in nb" + globalData);

        for (String key : submissionJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + comLoc.getLocator(key) + " || " + submissionJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (key.equals("PolicyNumberFetch")) {

                String polNum = dataDrivenMethods.gettingText("//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']/div[2]");
                System.out.println("Policy Issued Successfully | Policy number : " + polNum);
                dataDrivenMethods.click("//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']/div[2]");
                continue;
            }

            if (Actualkey.startsWith("RiskAnalysis")) {
                if (key.equals("WarningMessage")) {
                    String warningXpath = "//div[contains(@id,'QuoteScreen-WarningsPanelSet') and contains(@id,'PanelSet-Warning')]/div";
                    if (!driver.findElements(By.xpath(warningXpath)).isEmpty()) {
                        if (dataDrivenMethods.gettingText(warningXpath).contains("underwriting approval")) {
                            hasUWIssue = true;
                        }
                    }
                    continue;
                }
                if (hasUWIssue) {
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(comLoc.getLocator(key),
                            submissionJson.get(Actualkey), globalData.get(key));
                    continue;
                }
                continue;
            }
            if (key.equals("Bind Options")) {
                if (!driver.findElements(By.xpath(comLoc.getLocator(key))).isEmpty()) {
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(comLoc.getLocator(key),
                            submissionJson.get(Actualkey), globalData.get(key));
                    continue;
                }
                continue;
            }

            if (key.equals("PAQuoteQuestion")) {
                String xpath = "//*[@id='gw-center-bottom-section']//div[text()='Do you want to select UBI for this policy']//following::select[1]";
                if (!driver.findElements(By.xpath(xpath)).isEmpty()) {
                    dataDrivenMethods.selectOptionsForFieldWithSelect("Do you want to select UBI for this policy",
                            "Non-UBI Policy");
                    continue;
                }
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + comLoc.getLocator(key)
                    + "Printing submission key " + submissionJson.get(Actualkey) + "printing global data "
                    + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(comLoc.getLocator(key),
                    submissionJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Quick Quote")
    public void quickQuote() {
        System.out.println("printing global in nb" + globalData);

        for (String key : quickQuoteJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || "
                    + comLoc.getLocator(key) + " || " + quickQuoteJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + comLoc.getLocator(key)
                    + "Printing submission key " + quickQuoteJson.get(Actualkey) + "printing global data "
                    + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(comLoc.getLocator(key),
                    quickQuoteJson.get(Actualkey), globalData.get(key));
        }

    }
}
