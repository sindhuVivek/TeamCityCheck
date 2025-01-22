package actions.cc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cc.VerifyRole;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class VerifyRoleScenario extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final VerifyRole role = new VerifyRole();
    public Map<String, String> roleJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/VerifyRoles.json"), StandardCharsets.UTF_8));


    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;



    public VerifyRoleScenario() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

       @Step("Verify User using the required Test Data")
    public void verifyRole() throws IOException, ParseException {
        System.out.println("printing array length"+testDataIdArray.length);
           for (int i = 0; i < testDataIdArray.length; i++) {
               for (String key : roleJson.keySet()) {
                   Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + role.getLocator(key) + " || " + roleJson.get(key) + " || " + globalData.get(key));
                   Actualkey = key;
                   if (key.contains(".")) {

                       String keysplitted[] = key.split("\\.");
                       key = keysplitted[1];
                   }
                   System.out.println("entered for key " + Actualkey + "printing get locator " + role.getLocator(key) + "Printing fnoljson key " + roleJson.get(Actualkey) + "printing global data"+testDataIdArray[i]+"_"+key  + globalData.get(testDataIdArray[i]+"_"+key));
                   dataDrivenMethods.getAllMethodsToPerformRequiredActions(role.getLocator(key), roleJson.get(Actualkey), globalData.get(testDataIdArray[i]+"_"+key));

               }
           }
       }
}






