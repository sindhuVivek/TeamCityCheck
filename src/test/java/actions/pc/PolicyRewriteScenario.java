package actions.pc;

import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.PolicyRewrite_Ext;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class PolicyRewriteScenario extends Driver {

    DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    public Map<String, String> initiateRewriteJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/policyRewrite.json"), StandardCharsets.UTF_8));
    PolicyRewrite_Ext policyCancel_Ext = new PolicyRewrite_Ext();
    String Actualkey;

    public PolicyRewriteScenario() throws IOException, ParseException {
        this.driver = getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    public void policyRewriteAndVerify(String rewriteType) {

        for (String key : initiateRewriteJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + policyCancel_Ext.getLocator(key) + " || " + initiateRewriteJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (rewriteType.equals("New Term")) {
                if (Actualkey.startsWith("PolicyRewriteNewTerm")) {
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(policyCancel_Ext.getLocator(key), initiateRewriteJson.get(Actualkey), globalData.get(key));
                }
            }
            else if (rewriteType.equals("New Account")) {
                if (Actualkey.startsWith("PolicyRewriteNewAccount")){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(policyCancel_Ext.getLocator(key), initiateRewriteJson.get(Actualkey), globalData.get(key));
                    }
            } else {
                if (Actualkey.startsWith("PolicyRewrite") && !Actualkey.startsWith("PolicyRewriteNewAccount") && !Actualkey.startsWith("PolicyRewriteNewTerm")) {
                    if ((key.equals("Rewrite Full Term") && rewriteType.equals("Remainder Of Term")) || (key.equals("Rewrite Remainder of Term") && rewriteType.equals("Full Term")))
                        continue;
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(policyCancel_Ext.getLocator(key), initiateRewriteJson.get(Actualkey), globalData.get(key));
                }
            }
        }

        String rewriteMsg = dataDrivenMethods.gettingText(policyCancel_Ext.getLocator("Rewrite Message"));
        System.out.println(rewriteMsg);
        switch (rewriteType) {
            case "Full Term":
                dataDrivenMethods.assertExpectedAndActualText(rewriteMsg, "Rewrite Full Term Bound");
                break;
            case "New Term":
                dataDrivenMethods.assertExpectedAndActualText(rewriteMsg, "Rewrite New Term Bound");
                break;
            case "New Account":
                dataDrivenMethods.assertExpectedAndActualText(rewriteMsg, "Rewrite New Account Bound");
                break;
            default:
                dataDrivenMethods.assertExpectedAndActualText(rewriteMsg, "Rewrite Remainder of Term Bound");
                break;
        }
    }
}