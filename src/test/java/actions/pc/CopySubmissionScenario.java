package actions.pc;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExpectedExceptionsHolder;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import pages.pc.CopySubmission;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class CopySubmissionScenario extends Driver {

    private WebDriver driver;
    private WebDriverWait wait;
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final CopySubmission copySubmission = new CopySubmission();
    public Map<String, String> copySubmissionJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/copySubmission.json"), StandardCharsets.UTF_8));

    String Actualkey;

    public CopySubmissionScenario() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create Copy Submission using required test data")
    public void createCopySubmission() {
        for (String key : copySubmissionJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + copySubmission.getLocator(key) + " || " + copySubmissionJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(copySubmission.getLocator(key), copySubmissionJson.get(Actualkey), globalData.get(key));
        }
    }
    @Step("Verify submission bound message for copy submission")
    public void verifySubmissionBoundMessage() {
            String actualValue= dataDrivenMethods.gettingText(copySubmission.getLocator("Submission Message"));
            String expectedValue="Your Submission has been bound.";
            actualValue=actualValue.replaceAll("[^A-Za-z]","");
            expectedValue=expectedValue.replaceAll("[^A-Za-z]","");
            dataDrivenMethods.assertExpectedAndActualText(actualValue, expectedValue);
    }
    }







