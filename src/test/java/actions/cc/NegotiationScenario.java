package actions.cc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.cc.Negotiation;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class NegotiationScenario extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final Negotiation negotiation = new Negotiation();
    public Map<String, String> negotiationJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/Negotiation.json"), StandardCharsets.UTF_8));


    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;



    public NegotiationScenario() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

       @Step("Create Negotiation using the required Test Data")
        public void addNegotiation() throws IOException, ParseException {
        for (String key : negotiationJson.keySet()) {

                Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + negotiation.getLocator(key) + " || " + negotiationJson.get(key) + " || " + globalData.get(key));
                Actualkey = key;

            if (Actualkey.contains("CreateNegotiation")){
                if (key.contains(".")) {
                    String keysplitted[] = key.split("\\.");
                    key = keysplitted[1];
                }
                System.out.println("entered for key " + Actualkey + "printing get locator " + negotiation.getLocator(key) + "Printing fnoljson key " + negotiationJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(negotiation.getLocator(key), negotiationJson.get(Actualkey), globalData.get(key));
            }
        }
    }
    @Step("Edit Negotiation using the required Test Data")
    public void editNegotiation() throws IOException, ParseException {
        for (String key : negotiationJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + negotiation.getLocator(key) + " || " + negotiationJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (Actualkey.contains("EditNegotiation")) {
                if (key.contains(".")) {
                    String keysplitted[] = key.split("\\.");
                    key = keysplitted[1];
                }
                System.out.println("entered for key " + Actualkey + "printing get locator " + negotiation.getLocator(key) + "Printing fnoljson key " + negotiationJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(negotiation.getLocator(key), negotiationJson.get(Actualkey), globalData.get(key));
            }
        }
    }
    @Step("Delete Negotiation using the required Test Data")
    public void deleteNegotiation() throws IOException, ParseException {
        for (String key : negotiationJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + negotiation.getLocator(key) + " || " + negotiationJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (Actualkey.contains("DeleteNegotiation")) {
                if (key.contains(".")) {
                    String keysplitted[] = key.split("\\.");
                    key = keysplitted[1];
                }
                System.out.println("entered for key " + Actualkey + "printing get locator " + negotiation.getLocator(key) + "Printing fnoljson key " + negotiationJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(negotiation.getLocator(key), negotiationJson.get(Actualkey), globalData.get(key));
            }
        }
    }

}






