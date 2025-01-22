package actions.pc;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExpectedExceptionsHolder;
import pages.pc.PCCommon;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import pages.pc.CopySubmission;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class PCCommonScenario extends Driver {

    private WebDriver driver;
    private WebDriverWait wait;
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final PCCommon pcCommon = new PCCommon();
    public Map<String, String> SearchJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/Search.json"), StandardCharsets.UTF_8));

    String Actualkey;

    public PCCommonScenario() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Search and open a policy based on test data")
    public void searchAndOpenPolicy() {
        for (String key : SearchJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcCommon.getLocator(key) + " || " + SearchJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            String actionType=null;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
                actionType=keysplitted[0];
            }
            if(actionType.equals("PolicySearch"))
            {
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcCommon.getLocator(key), SearchJson.get(Actualkey), globalData.get(key));
            }
        }
    }
}







