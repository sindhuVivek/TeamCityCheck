package actions.pc;


import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

public class CreateNewAccount_Act extends Driver {

    private final pages.pc.CreateAccount_Ext crAct = new pages.pc.CreateAccount_Ext();
    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    public Map<String, String> accountJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/pc/createAccount.json"), StandardCharsets.UTF_8));
    String Actualkey;
    String Accnum;

    private WebDriver driver;
    private WebDriverWait wait;



    public CreateNewAccount_Act() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create a New Account_Company")
    public void CreateNewAccount_Company() throws IOException, ParseException, InterruptedException {
        for (String key : accountJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + crAct.getLocator(key) + " || " + accountJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Person")) {
                continue;
            }
            if (key.equals("ZIP Code")) {
                System.out.print("Zip code entering..");
            }
            if (key.equals("AccountFetch")) {
                Accnum = dataDrivenMethods.gettingText("//*[@id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-AccountNumber']//div[@class='gw-value-readonly-wrapper']");
                System.out.println("Account Created Successfully | Account number : " + Accnum);
                continue;
            }
            if(key.equals("Company Name")){
                String currentDateTime = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String companyName= currentDateTime+"_"+globalData.get(key);
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(crAct.getLocator(key), accountJson.get(Actualkey), companyName);
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + crAct.getLocator(key) + "Printing fnoljson key " + accountJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(crAct.getLocator(key), accountJson.get(Actualkey), globalData.get(key));
            if (key.equals("Organization")) {
                Actions act = new Actions(driver);

                act.sendKeys(Keys.TAB).build().perform();
                act.sendKeys(Keys.RETURN).build().perform();


            }
        }
    }

    @Step("Create a New Account_Person")
    public void CreateNewAccount_Person() throws IOException, ParseException, InterruptedException {
        for (String key : accountJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + crAct.getLocator(key) + " || " + accountJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Company")) {
                continue;
            }
            if (key.equals("ZIP Code")) {
                System.out.print("Zip code entering..");
            }
            if (key.equals("AccountFetch")) {
                Accnum = dataDrivenMethods.gettingText("//*[@id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-AccountNumber']//div[@class='gw-value-readonly-wrapper']");
                System.out.println("Account Created Successfully | Account number : " + Accnum);
                continue;
            }

            if (key.equals("State")) {
                System.out.println("Entering State Person..");
            }

            if(key.equals("First name")){
                String currentDateTime = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String firstName= currentDateTime+"_"+globalData.get(key);
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(crAct.getLocator(key), accountJson.get(Actualkey), firstName);
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + crAct.getLocator(key) + "Printing fnoljson key " + accountJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(crAct.getLocator(key), accountJson.get(Actualkey), globalData.get(key));
            if (key.equals("Organization")) {
                Actions act = new Actions(driver);

                act.sendKeys(Keys.TAB).build().perform();
                act.sendKeys(Keys.RETURN).build().perform();


            }
        }
    }

}
