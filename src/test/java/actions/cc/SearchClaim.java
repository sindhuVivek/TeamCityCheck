package actions.cc;
import io.qameta.allure.Step;
import pages.cc.SearchScenario;
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

public class SearchClaim extends Driver {

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final SearchScenario searchScenario = new SearchScenario();
    public Map<String, String> searchClaimJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/SearchClaim.json"), StandardCharsets.UTF_8));

    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchClaim() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Search a Claim using Test Data")
    public void searchClaim() throws IOException, ParseException {
        for (String key : searchClaimJson.keySet()) {
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println(key);

            System.out.println("entered for key " + Actualkey + "printing get locator " + searchScenario.getLocator(key) + "Printing searchClaimJson key " + searchClaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(searchScenario.getLocator(key), searchClaimJson.get(Actualkey), globalData.get(key));
        }
    }
}
