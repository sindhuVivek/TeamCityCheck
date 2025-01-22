package actions.cc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.cc.FNOL;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class CreateClaim extends Driver {


    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final FNOL fnol = new FNOL();
    public Map<String, String> fnolJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/claimjson.json"), StandardCharsets.UTF_8));
    public Map<String, String> unverifiedclaimJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/UnverifiedClaim.json"), StandardCharsets.UTF_8));
    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;



    public CreateClaim() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createClaim() throws IOException, ParseException {
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createUnverifiedIMClaim() throws IOException, ParseException {
        for (String key : unverifiedclaimJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + unverifiedclaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), unverifiedclaimJson.get(Actualkey), globalData.get(key));


            if(key.equals("Update")) {

                System.out.println("printing value"+fnol.fNOLWizardUnverifiedClaimInsuredName);
                System.out.println("printing value"+new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText());
            }

        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createQuickIMClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("fNOLWizardNext3") || key.equals("fNOLWizardNext4") || key.equals("MetroReportAdd") || key.equals("AddMetroReportOK")
                    || key.equals("Close")  || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle") || key.equals("fNOLWizardNext5") || key.equals("MetroReportOkButton") || key.equals("Ok") || key.equals("addPropertyDamage")) {

                continue;
            }

            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

            if (key.equals("PolicySearch")) {
                Name=dataDrivenMethods.gettingText(fnol.fNOLWizardFindPolicyPanelSetPolicyResultLV);
                globalData.put("Name",Name);
                globalData.put("Claimant Name",Name);
                System.out.println("printing name before key"+globalData.get("Name"));

            }
            if(key.equals("Finish")){
                if(driver.findElement(By.xpath("//div[text()='Clos']")).isDisplayed()){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator("Finish"), fnolJson.get("Finish"), globalData.get("Finish"));
                }
            }
        }
    }
    @Step("Create a FNOL Claim using the required Test Data")
    public void createVerifiedExcessClaim() throws IOException, ParseException {
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")|| key.equals("fNOLWizardNext5")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createCPClaim() throws IOException, ParseException {
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createUnverifiedCPClaim() throws IOException, ParseException {
        for (String key : unverifiedclaimJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + unverifiedclaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), unverifiedclaimJson.get(Actualkey), globalData.get(key));

            if (key.equals("Update")) {

                System.out.println("printing value" + fnol.fNOLWizardUnverifiedClaimInsuredName);
                System.out.println("printing value" + new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText());
            }

        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createQuickCPClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("fNOLWizardNext3") || key.equals("fNOLWizardNext4") || key.equals("addPropertyDamage") || key.equals("MetroReportAdd")
                    || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle") || key.equals("fNOLWizardNext5") || key.equals("AddMetroReportOK") || key.equals("Ok") || key.equals("addPropertyDamage") || key.equals("Close")) {
                continue;
            }

            if (key.equals("fNOLWizardNext1")) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

            if (key.equals("PolicySearch")) {
                Name = dataDrivenMethods.gettingText(fnol.fNOLWizardFindPolicyPanelSetPolicyResultLV);
                globalData.put("Name", Name);
                globalData.put("Claimant Name", Name);
                System.out.println("printing name before key" + globalData.get("Name"));

            }
            if (key.equals("Finish")) {
                if (driver.findElement(By.xpath("//div[text()='Clos']")).isDisplayed()) {
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator("Finish"), fnolJson.get("Finish"), globalData.get("Finish"));
                }
            }
        }
    }
    @Step("Create a FNOL Claim using the required Test Data")
    public void createVerifiedPAClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));
            if (key.equals("PolicySearch")) {
                Name=dataDrivenMethods.gettingText(fnol.fNOLWizardFindPolicyPanelSetPolicyResultLV);
                globalData.put("Name",Name);
               // globalData.put("Claimant Name",Name);
                System.out.println("printing name before key"+globalData.get("Name"));

            }
            if(key.equals("Finish")){
                if(driver.findElements(By.xpath("//div[text()='Clos']")).size()>0){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator("Finish"), fnolJson.get("Finish"), globalData.get("Finish"));
                }
            }
        }

    }
    @Step("Create a FNOL Claim using the required Test Data")
    public void createUnVerifiedPAClaim() throws IOException, ParseException {
        String Name;
        for (String key : unverifiedclaimJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + unverifiedclaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), unverifiedclaimJson.get(Actualkey), globalData.get(key));


            if(key.equals("Update")) {

                System.out.println("printing value"+fnol.fNOLWizardUnverifiedClaimInsuredName);
                System.out.println("printing value"+new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText());
                Name=new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText();
                globalData.put("Name",Name);
            }

        }
    }
    @Step("Create a FNOL Claim using the required Test Data")
    public void createQuickPAClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("fNOLWizardNext3") || key.equals("fNOLWizardNext4") || key.equals("MetroReportAdd") || key.equals("AddMetroReportOK")
                    || key.equals("Close")  || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle") || key.equals("fNOLWizardNext5") || key.equals("MetroReportOkButton") || key.equals("Ok") || key.equals("addPropertyDamage")) {

                continue;
            }

            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

            if (key.equals("PolicySearch")) {
                Name=dataDrivenMethods.gettingText(fnol.fNOLWizardFindPolicyPanelSetPolicyResultLV);
                globalData.put("Name",Name);
               // globalData.put("Claimant Name",Name);
                System.out.println("printing name before key"+globalData.get("Name"));

            }
            if(key.equals("Finish")){
                if(driver.findElement(By.xpath("//div[text()='Clos']")).isDisplayed()){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator("Finish"), fnolJson.get("Finish"), globalData.get("Finish"));
                }
            }
        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createVerifiedBOPClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));
            }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createUnVerifiedBOPClaim() throws IOException, ParseException {
        String Name;
        for (String key : unverifiedclaimJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("Ok") || key.equals("fNOLWizardNext2") || key.equals("fNOLWizardNext3") || key.equals("addPropertyDamage") || key.equals("Insured Vehicle") || key.equals("Close")
                    || key.equals("Third Party Vehicle") || key.equals( "Location") || key.equals("fNOLWizardNext5") || key.equals("fNOLWizardNext4") || key.equals("MetroReportAdd") || key.equals("AddMetroReportOK"))  {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + unverifiedclaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), unverifiedclaimJson.get(Actualkey), globalData.get(key));

            if(key.equals("PropertyRadioClick") || key.equals("fNOLWizardNext1")){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if(key.equals("Update")) {

                System.out.println("printing value"+fnol.fNOLWizardUnverifiedClaimInsuredName);
                System.out.println("printing value"+new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText());
                Name=new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText();
                globalData.put("Name",Name);
            }
            if(key.equals("Finish")){
                if(driver.findElement(By.xpath("//div[text()='Clos']")).isDisplayed()){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator("Finish"), fnolJson.get("Finish"), globalData.get("Finish"));
                }
            }

        }
    }
    @Step("Create a FNOL Claim using the required Test Data")
    public void createQuickBOPClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("Close") || key.equals("fNOLWizardNext2") || key.equals("fNOLWizardNext3") || key.equals("fNOLWizardNext4") || key.equals("MetroReportAdd") || key.equals("AddMetroReportOK") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle") || key.equals("fNOLWizardNext5") || key.equals("MetroReportOkButton") || key.equals("Ok") || key.equals("addPropertyDamage")) {

                continue;
            }

            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

            if (key.equals("PolicySearch")) {
                Name=dataDrivenMethods.gettingText(fnol.fNOLWizardFindPolicyPanelSetPolicyResultLV);
                //globalData.put("Name",Name);
                globalData.put("Claimant Name",Name);
                System.out.println("printing name before key"+globalData.get("Name"));

            }

            if(key.equals("Finish")){
                if(driver.findElement(By.xpath("//div[text()='Clos']")).isDisplayed()){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator("Finish"), fnolJson.get("Finish"), globalData.get("Finish"));
                }
            }
        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createVerifiedCAClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createUnVerifiedCAClaim() throws IOException, ParseException {
        String Name;
        for (String key : unverifiedclaimJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Injured Worker Name") || key.equals("Insured Vehicle")
                    || key.equals("Third Party Vehicle") || key.equals("Coverage in Question?"))  {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + unverifiedclaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), unverifiedclaimJson.get(Actualkey), globalData.get(key));
            if(key.equals("Update")) {

                System.out.println("printing value"+fnol.fNOLWizardUnverifiedClaimInsuredName);
                System.out.println("printing value"+new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText());
                Name=new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText();
                globalData.put("Name",Name);
            }
        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createQuickCAClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("fNOLWizardNext3") || key.equals("fNOLWizardNext4") || key.equals("MetroReportAdd") || key.equals("AddMetroReportOK")
                    || key.equals("Close")  || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle") || key.equals("fNOLWizardNext5") || key.equals("MetroReportOkButton") || key.equals("Ok") || key.equals("addPropertyDamage") || key.equals("Effective Date") || key.equals("Expiration Date") || key.equals("Person") || key.equals("Property Name") || key.equals("Injured Worker Name") || key.equals("Injured Worker Name") || key.equals("Injured Worker Name") || key.equals("Injured Worker Name") || key.equals("Injured Worker Name") ) {

                continue;
            }
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));

            if(key.equals("Finish")){
                if(driver.findElement(By.xpath("//div[text()='Clos']")).isDisplayed()){
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator("Finish"), fnolJson.get("Finish"), globalData.get("Finish"));
                }
            }
        }
    }

    @Step("Create a FNOL Claim using the required Test Data")
    public void createVerifiedWCClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Insured Vehicle") || key.equals("Third Party Vehicle") ||key.equals("Ok") ||key.equals("Already Repaired?") ||key.equals("MetroReportAdd")||key.equals("AddMetroReportOK")||key.equals("MetroReportAdd")||key.equals("AddMetroReportOK")||key.equals("selectVehicleOption")||key.equals("fNOLWizardNext2")||key.equals("addPropertyDamage")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));
        }
    }
    @Step("Create a FNOL Claim using the required Test Data")
    public void createUnverifiedWCClaim() throws IOException, ParseException {
        for (String key : unverifiedclaimJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext5") || key.equals("fNOLWizardNext2") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")||key.equals("Ok") ||key.equals("Already Repaired?") ||key.equals("MetroReportAdd")||key.equals("AddMetroReportOK")||key.equals("addPropertyDamage")||Actualkey.equals("Address 1")||Actualkey.equals("Address 2")||Actualkey.equals("State")||Actualkey.equals("Country")||Actualkey.equals("City")||Actualkey.equals("County")||Actualkey.equals("ZIP Code")||Actualkey.equals("Location Description")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + unverifiedclaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), unverifiedclaimJson.get(Actualkey), globalData.get(key));

            if (key.equals("Update")) {

                System.out.println("printing value" + fnol.fNOLWizardUnverifiedClaimInsuredName);
                System.out.println("printing value" + new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText());
                String Name = new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText();
                globalData.put("Name",Name);
                globalData.put("Injured Worker Name",Name);
            }

        }
    }


    @Step("Create a FNOL HO Claim using the required Test Data")
    public void createVerifiedHOClaim() throws IOException, ParseException {
        String Name;
        for (String key : fnolJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + fnolJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Location") || key.equals("fNOLWizardNext2") || key.equals("Claimant Name") || key.equals("selectVehicleOption") || key.equals("Insured Vehicle") || key.equals("Third Party Vehicle")) {
                continue;
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + fnolJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), fnolJson.get(Actualkey), globalData.get(key));
        }
    }

    @Step("Create a unverified FNOL HO Claim using the required Test Data")
    public void createUnVerifiedHOClaim() throws IOException, ParseException {
        String Name;
        for (String key : unverifiedclaimJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + fnol.getLocator(key) + " || " + unverifiedclaimJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("selectVehicleOption") || key.equals("fNOLWizardNext2") || key.equals("Injured Worker Name") || key.equals("Insured Vehicle")
                    || key.equals("Third Party Vehicle") || key.equals("Coverage in Question?"))  {
                continue;
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + fnol.getLocator(key) + "Printing fnoljson key " + unverifiedclaimJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(fnol.getLocator(key), unverifiedclaimJson.get(Actualkey), globalData.get(key));
            if(key.equals("Update")) {

                System.out.println("printing value"+fnol.fNOLWizardUnverifiedClaimInsuredName);
                System.out.println("printing value"+new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText());
                Name=new Select(driver.findElement(By.cssSelector(fnol.fNOLWizardUnverifiedClaimInsuredName))).getFirstSelectedOption().getText();
                globalData.put("Name",Name);
            }
        }
    }

}






