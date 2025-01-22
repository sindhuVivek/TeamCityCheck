package actions.cc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

import pages.cc.Service;


public class ServiceScenario extends Driver {

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final Service service = new Service();
    public Map<String, String> serviceJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/CreateService.json"), StandardCharsets.UTF_8));
    public Map<String, String> assignRemoveJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/AssignAndRemoveService.json"), StandardCharsets.UTF_8));
    public Map<String, String> searchServiceJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/SearchService.json"), StandardCharsets.UTF_8));

    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;


    public ServiceScenario() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create Service using the required Test Data")
    public void createService() throws IOException, ParseException {
        for (String key : serviceJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + service.getLocator(key) + " || " + serviceJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Search") || key.equals("Choice") || key.equals("Claim #")) {
                continue;
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + service.getLocator(key) + "Printing fnoljson key " + serviceJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(service.getLocator(key), serviceJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Assign Service using the required Test Data")
    public void assignService() throws IOException, ParseException {
        for (String key : assignRemoveJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + service.getLocator(key) + " || " + assignRemoveJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.equals("CancelServiceBtn") || key.equals("Reason for canceling") || key.equals("Cancel Service")) {
                continue;
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + service.getLocator(key) + "Printing fnoljson key " + assignRemoveJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(service.getLocator(key), assignRemoveJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Remove Service using the required Test Data")
    public void removeService() throws IOException, ParseException {
        for (String key : assignRemoveJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + service.getLocator(key) + " || " + assignRemoveJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.equals("Assign") || key.equals("Return to Services") || key.equals("Select from list:") || key.equals("AssignFromList")) {
                continue;
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + service.getLocator(key) + "Printing fnoljson key " + assignRemoveJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(service.getLocator(key), assignRemoveJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Service using the required Test Data")
    public void searchService() throws IOException, ParseException {
        for (String key : searchServiceJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + service.getLocator(key) + " || " + searchServiceJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.equals("SearchServices")) {
                String serviceTable = "//*[@id='ClaimServiceRequests-ServiceRequestList-ServiceRequestLV']/div/div[2]/table/tbody/tr";

                int rowCount = driver.findElements(By.xpath(serviceTable)).size();
                if (rowCount > 1) {
                    System.out.println("Service is available");
                } else {
                    System.out.println("Service is not available");
                }
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + service.getLocator(key) + "Printing fnoljson key " + assignRemoveJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(service.getLocator(key), assignRemoveJson.get(Actualkey), globalData.get(key));
        }
    }

}






