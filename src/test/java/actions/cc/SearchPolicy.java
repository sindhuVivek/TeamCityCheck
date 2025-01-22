package actions.cc;
import io.qameta.allure.Step;
import pages.cc.SearchPolicyScenario;
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

public class SearchPolicy extends Driver {

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final SearchPolicyScenario searchPolicyScenario = new SearchPolicyScenario();
    public Map<String, String> searchPolicyJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/SearchPolicy.json"), StandardCharsets.UTF_8));
    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPolicy() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Search a Claim using Test Data")
    public void searchPolicy() throws IOException, ParseException {
        for (String key : searchPolicyJson.keySet()) {
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println(key);
            System.out.println("entered for key " + Actualkey + "printing get locator " + searchPolicyScenario.getLocator(key) + "Printing searchPolicyJson key " + searchPolicyJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(searchPolicyScenario.getLocator(key), searchPolicyJson.get(Actualkey), globalData.get(key));

        }
    }
}
