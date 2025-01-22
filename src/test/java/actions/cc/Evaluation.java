package actions.cc;
import io.qameta.allure.Step;
import pages.cc.EvaluationScenario;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class Evaluation extends Driver {
    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final EvaluationScenario evaluationScenario = new EvaluationScenario();
    public Map<String, String> evaluationJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/Evaluation.json"), StandardCharsets.UTF_8));

    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;

    public Evaluation() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Add a New Evaluation for the Claim")
    public void evaluation() throws IOException, ParseException {
        for (String key : evaluationJson.keySet()) {
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("PlanOfActionBtn") || key.equals("EvaluationsTab") || key.equals("EvaluationEdit") || key.equals("UpdateInsuredLiability") ||  key.equals("UpdateOtherLiability") || key.equals("EditEvaluationsUpdate") || key.equals("UpdateOtherLiabilityClick") || key.equals("SelectEvaluation") || key.equals("DeleteBtn")) {
                continue;
            }
            System.out.println(key);

            System.out.println("entered for key " + Actualkey + "printing get locator " + evaluationScenario.getLocator(key) + "Printing searchClaimJson key " + evaluationJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(evaluationScenario.getLocator(key), evaluationJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Edit a existing Evaluation for the Claim")
    public void editEvaluation() throws IOException, ParseException {
        for (String key : evaluationJson.keySet()) {
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("ActionMenu") || key.equals("EvaluationBtn") || key.equals("evaluationName") || key.equals("evaluationAmount") || key.equals("UpdateBtn") || key.equals("SelectEvaluation") || key.equals("DeleteBtn")) {
                continue;
            }
            System.out.println(key);

            System.out.println("entered for key " + Actualkey + "printing get locator " + evaluationScenario.getLocator(key) + "Printing searchClaimJson key " + evaluationJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(evaluationScenario.getLocator(key), evaluationJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Delete a Evaluation for the Claim")
    public void deleteEvaluation() throws IOException, ParseException {
        for (String key : evaluationJson.keySet()) {
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("ActionMenu") || key.equals("EvaluationBtn") || key.equals("evaluationName") || key.equals("evaluationAmount") || key.equals("UpdateBtn") || key.equals("EvaluationEdit") || key.equals("UpdateInsuredLiability") || key.equals("UpdateOtherLiability") || key.equals("EditEvaluationsUpdate") || key.equals("UpdateOtherLiabilityClick")) {
                continue;
            }
            System.out.println(key);

            System.out.println("entered for key " + Actualkey + "printing get locator " + evaluationScenario.getLocator(key) + "Printing searchClaimJson key " + evaluationJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(evaluationScenario.getLocator(key), evaluationJson.get(Actualkey), globalData.get(key));
        }
    }
}
