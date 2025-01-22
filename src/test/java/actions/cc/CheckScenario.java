package actions.cc;

import io.cucumber.java.en_old.Ac;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.cc.CheckWizard;
import utilities.common.Driver;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class CheckScenario extends Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final CheckWizard check = new CheckWizard();
    public Map<String, String> createCheckJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/Check.json"), StandardCharsets.UTF_8));
    public int beforeCheckCount=0;

    String Actualkey;
    private WebDriver driver;

    public CheckScenario() throws Exception {
    }

    @Step("user create check")
    public void createCheck() throws Exception {
        for (String key : createCheckJson.keySet()) {
            Actualkey = key;
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + check.getLocator(key) + " || " + createCheckJson.get(key) + " || " + globalData.get(key));
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if(key.equals("No data to display")){
                beforeCheckCount= getThreadDriver().findElements(By.xpath("//div[@id=\"ClaimFinancialsChecks-ClaimFinancialsChecksScreen-ChecksLV\"]//table//tr")).size();
            }
            if(Actualkey.startsWith("Checkdetails"))
                continue;
            if(key.equals("Next2")) {
                dataDrivenMethods.clickAnyButton("Next");
                continue;
            }

            System.out.println("entered for key " + Actualkey + " printing get locator " + check.getLocator(key) + " Printing check key " + createCheckJson.get(Actualkey) + " printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(check.getLocator(key), createCheckJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("validate check created")
    public void validateCheckDetails(){
        int afterCheckCount=0;
        for (String key : createCheckJson.keySet()) {
            Actualkey = key;
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + check.getLocator(key) + " || " + createCheckJson.get(key) + " || " + globalData.get(key));
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if(Actualkey.startsWith("Checkdetails")){
                System.out.println("entered for key " + Actualkey + " printing get locator " + check.getLocator(key) + " Printing check key " + createCheckJson.get(Actualkey) + " printing global data " + globalData.get(key));
                if(key.equals("CheckCount")) {
                    afterCheckCount = getThreadDriver().findElements(By.xpath("//div[@id=\"ClaimFinancialsChecks-ClaimFinancialsChecksScreen-ChecksLV\"]//table//tr")).size();
                    continue;
                }
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(check.getLocator(key), createCheckJson.get(Actualkey), globalData.get(key));
                continue;
            }


        }
        if(afterCheckCount>beforeCheckCount)
            System.out.println("Check created Successfully");
        else
            dataDrivenMethods.assertExpectedAndActualText("check not created", "check should be created");
    }
}
