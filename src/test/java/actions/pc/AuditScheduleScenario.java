package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.common.Driver;
import pages.pc.AuditSchedule_Ext;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class AuditScheduleScenario extends Driver {

    private WebDriver driver;
    private WebDriverWait wait;
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final AuditSchedule_Ext audit = new AuditSchedule_Ext();
    public Map<String, String> auditJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/auditSchedule.json"), StandardCharsets.UTF_8));

    String Actualkey;

    public AuditScheduleScenario() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create Copy Submission using required test data")
    public void auditCreationAndValidation() {
        for (String key : auditJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + audit.getLocator(key) + " || " + auditJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(audit.getLocator(key), auditJson.get(Actualkey), globalData.get(key));
        }
    }

    }







