package actions.pc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pc.PCSearch_Pages;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class PCSearch_Act extends Driver {
    private final PCSearch_Pages pcSrch = new PCSearch_Pages();
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    public Map<String, String> searchJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/SearchAccount.json"), StandardCharsets.UTF_8));
    public Map<String, String> searchConJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/SearchContact.json"), StandardCharsets.UTF_8));
    public Map<String, String> searchPolJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/SearchPolicy.json"), StandardCharsets.UTF_8));
    public Map<String, String> searchActJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/SearchActivity.json"), StandardCharsets.UTF_8));
    public Map<String, String> searchNoteJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/SearchNote.json"), StandardCharsets.UTF_8));
    String Actualkey;
    String Accnum;

    private WebDriver driver;
    private WebDriverWait wait;


    public PCSearch_Act() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Search Account using Account number")
    public void searchAccount_AccountNumber() {
        for (String key : searchJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("First name") || key.equals("Last name") || key.equals("Company Name")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Account using Name")
    public void searchAccount_FNLN() {
        for (String key : searchJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Account Number") || key.equals("Company Name")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Account using Company Name")
    public void searchAccount_Comp() {
        for (String key : searchJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("First name") || key.equals("Last name") || key.equals("Account Number")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Contact using Company Name")
    public void searchContact_Comp() {
        for (String key : searchConJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchConJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("First name") || key.equals("Last name") || key.equals("Account Number")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchConJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchConJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Contact using Name")
    public void searchContact_FNLN() {
        for (String key : searchConJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchConJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Company Name")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchConJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchConJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Policy using Name")
    public void searchPolicy_FNLN() {
        for (String key : searchPolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchPolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Policy Number")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchPolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchPolJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Policy using Policy Number")
    public void searchPolicy_Number() {
        for (String key : searchPolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchPolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("First name") || key.equals("Last name")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchPolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchPolJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Activity using details")
    public void searchAct() {
        for (String key : searchActJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchActJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchActJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchActJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Search Note using details")
    public void searchNotes() {
        for (String key : searchNoteJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + pcSrch.getLocator(key) + " || " + searchNoteJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + pcSrch.getLocator(key) + "Printing fnoljson key " + searchNoteJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(pcSrch.getLocator(key), searchNoteJson.get(Actualkey), globalData.get(key));
        }
    }
}
