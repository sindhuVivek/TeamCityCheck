package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.commercial_Ext;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;
import utilities.common.ExcelData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;


public class SubmissionScenarioCP extends Driver {
    public ExcelData excelData = new ExcelData();
    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    public Map<String, String> submissionCPJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/CommercialProperty.json"), StandardCharsets.UTF_8));
    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public SubmissionScenarioCP() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }


    @Step("Create a New Submission HO with json data")
    public void newSubmissionCP() throws IOException, ParseException {
        System.out.println("printing global in nb" + globalData);
        for (String key : submissionCPJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + commercial_Ext.getLocator(key) + " || " + submissionCPJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (key.equals("Building Location")) {
                System.out.print("building  entering..");
                String buildingLocationvalue = globalData.get(key);
                String buildingLocationLocator = "(//div[contains(text(),'" + buildingLocationvalue + "')]/ancestor::td/preceding-sibling::td//div[contains(@id,'ActionsMenuIcon')])";

                driver.findElement(By.xpath(buildingLocationLocator)).click();
                dataDrivenMethods.clickAnyButton("New Building");

            }
            if (key.equals("CoverageAction")) {
                System.out.print("building  entering..");
                String CoverageAction = globalData.get(key);
                if (CoverageAction.equalsIgnoreCase("Add")) {
                    dataDrivenMethods.clickAnyButton("Add Blanket");
                }
            }
            if (key.equals("Show Coverages")) {
                System.out.println("clicking Show Coverages..");
            }

            if (key.equals("LocationCoverage")) {
                String covcheck = "//*[@id='CPBlanketPopup-CPBlanketCovLV-_Checkbox_checkboxDiv']/div";
                driver.findElement(By.xpath(covcheck)).click();

                dataDrivenMethods.clickAnyButton("Include Selected in Blanket");
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                driver.findElement(By.xpath("//div[@aria-label='Clear']")).click();

            }
            if (key.equals("Building features") || key.equals("Employees") || key.equals("Premises and equipment") || key.equals("Protection")
                    || key.equals("Risk elements not addressed in the classification plan")) {
                continue;
            }
            if (key.equals("Management")) {

                String justificationLocator = "//div[text()='Management']//following::input[2]";

                dataDrivenMethods.getAllMethodsToPerformRequiredActions(justificationLocator, "xpathSetValue", "test");
                String Management = globalData.get(key);
                driver.findElement(By.xpath("//*[contains(@id,\"-ModifiersScreen-ScheduleRateDV-0-ScheduleRateLV-2-CreditDebit\")]/div/input")).sendKeys(Management);
            }

            if (key.equals("PolicyNumberFetch")) {
                String polNum = dataDrivenMethods.gettingText("//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']/div[2]");
                System.out.println("Policy Issued Successfully | Policy number : " + polNum);
                dataDrivenMethods.click("//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']/div[2]");
                continue;
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(commercial_Ext.getLocator(key), submissionCPJson.get(Actualkey), globalData.get(key));

        }

    }
}





