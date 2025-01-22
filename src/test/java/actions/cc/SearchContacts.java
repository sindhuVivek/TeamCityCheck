package actions.cc;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cc.SearchContactsScenario;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SearchContacts extends Driver {

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final SearchContactsScenario searchContactsScenario = new SearchContactsScenario();
    public Map<String, String> searchContactsJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/SearchContacts.json"), StandardCharsets.UTF_8));
    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchContacts() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Search a Contacts using Test Data")
    public void searchContacts() throws IOException, ParseException {
        for (String key : searchContactsJson.keySet()) {
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println(key);

            System.out.println("entered for key " + Actualkey + "printing get locator " + searchContactsScenario.getLocator(key) + "Printing searchContactsJson key " + searchContactsJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(searchContactsScenario.getLocator(key), searchContactsJson.get(Actualkey), globalData.get(key));
        }
    }
}
