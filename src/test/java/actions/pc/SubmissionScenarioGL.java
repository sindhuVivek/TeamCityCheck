package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.GeneralLiability_Ext;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SubmissionScenarioGL extends Driver {

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final GeneralLiability_Ext generalliability = new GeneralLiability_Ext();
    public Map<String, String> submissionGLJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/GeneralLiability.json"), StandardCharsets.UTF_8));
    public Map<String, String> submissionGLQQJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/GeneralLiabilityQQ.json"), StandardCharsets.UTF_8));
    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public SubmissionScenarioGL() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create a New Submission GL with json data")
    public void newSubmissionGL() throws IOException, ParseException {
        System.out.println("printing global in nb" + globalData);
        for (String key : submissionGLJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + generalliability.getLocator(key) + " || " + submissionGLJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + generalliability.getLocator(key) + "Printing fnoljson key " + submissionGLJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(generalliability.getLocator(key), submissionGLJson.get(Actualkey), globalData.get(key));
            if (key.equals("Class Code")) {
                String classcode=globalData.get(key);
                Actions act = new Actions(driver);
                act.sendKeys(Keys.TAB).build().perform();
                act.sendKeys(Keys.RETURN).build().perform();
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(45));

            }
        }


    }
    @Step("Create a Quick Quote GL with json data")
    public void newSubmissionQQGL() {
        System.out.println("printing global in nb" + globalData);
        for (String key : submissionGLQQJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + generalliability.getLocator(key) + " || " + submissionGLQQJson.get(key) + " || " + globalData.get(key));
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

            System.out.println("Entered for key " + Actualkey + " ==> Printing get locator " + generalliability.getLocator(key) + " ==> Printing json key " + submissionGLQQJson.get(Actualkey) + " ==> Printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(generalliability.getLocator(key), submissionGLQQJson.get(Actualkey), globalData.get(key));
        }
    }
}






