package actions.cc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cc.Subrogation;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SubrogationScenario extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final Subrogation subrog = new Subrogation();
    public Map<String, String> subrogJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/Subro.json"), StandardCharsets.UTF_8));


    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;



    public SubrogationScenario() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Open Subrogation using the required Test Data")
    public void openSubrogation() throws IOException, ParseException {
        for (String key : subrogJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + subrog.getLocator(key) + " || " + subrogJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + subrog.getLocator(key) + "Printing fnoljson key " + subrogJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(subrog.getLocator(key), subrogJson.get(Actualkey), globalData.get(key));

        }
    }
    @Step("Open Subrogation using the required Test Data")
    public void closeSubrogation() throws IOException, ParseException {
        for (String key : subrogJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + subrog.getLocator(key) + " || " + subrogJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + subrog.getLocator(key) + "Printing fnoljson key " + subrogJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(subrog.getLocator(key), subrogJson.get(Actualkey), globalData.get(key));
            if(key.equals("Update")){
                if(driver.findElements(By.xpath("//div[text()='Clear']")).size()>0){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(subrog.getLocator("Update"), subrogJson.get("Update"), globalData.get("Update"));
                }
            }
        }
    }

}

