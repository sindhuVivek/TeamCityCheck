package pages.cc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FNOL {
    private WebDriver driver;

    public FNOL() {
        this.driver = driver;
    }
    public String fNOLWizardUnverifiedClaimInsuredName ="select[name$='FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name']";
    public String fNOLWizardFindPolicyPanelSetPolicyResultLV = "//div[@id='FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-PolicyResultLV-0-Insured']/div/div";
    //public String fNOLWizardUnverifiedClaimInsuredName = "FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name";

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Claim":
                return "//div[@id='TabBar-ClaimTab']//descendant::div[contains(@class,'expand-button')]";
            case "New Claim":
                return "//div[@id='TabBar-ClaimTab-ClaimTab_FNOLWizard']";
            case "fNOLWizardFindPolicyPanelSetSearch":
                return By.cssSelector("#FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Search").toString();
            case "Loss Date":
                return "//input[@name='FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-Claim_LossDate']";
            case "Next": case "fNOLWizardNext1": case "fNOLWizardNext2":
            case "fNOLWizardNext3": case "fNOLWizardNext4": case "fNOLWizardNext5":
                return "//div[contains(text(), 'Next')]";
            case "addPropertyDamage":
                return "(//div[text()='Properties']/..//div[text()='dd']) | (//div[text()='Add Property Damage'])";
            case "MetroReportAdd":
                return "(//div[text()='Metropolitan Reports']/..//div[text()='dd']) | (//div[contains(@id,'MetroReportsLV_tb-Add')])";
            case "Loss Description":
                return "//textarea[contains(@name,'MetroLossDescription')]";
            case "MetroReportOkButton":
                return "//button[contains(text(), 'OK')]";
            case "PolicySearch":
                return  "earch";
            case "Finish":
                return "inish";
            case "Close":
                return "Clos";
            case "Basic Info Relation to Insured":
                return "//select[@name='FNOLWizard-FullWizardStepSet-FNOLWizard_BasicInfoScreen-Claim_ReportedByType']";
            case "Claimant Name":
                return "//select[@name='FNOLWizard-NewClaimWizard_QuickClaimScreen-QuickClaimDV-Claimant_Picker']";
            case "ViewClaimButton":
                return "#NewClaimSaved-NewClaimSavedScreen-NewClaimSavedDV-GoToClaim > div > div > div.gw-action";
            case "Insured Name":
                return "(//div[text()='Name']/..//div[@role='button'])[1]";
            case "Update":
                return "//div[text()='pdate']";
            case "Type of Policy":
                return "//span[text()='Create Unverified Policy ']/..//div";
            case "UnverifiedPolicyNumber":
                return "Policy Number";
            case "UnverifiedPolicy Type":
                return "Type";
            case "SearchIcon":
                return By.cssSelector("#TabBar-ClaimTab-ClaimTab_FindClaim_Button").toString();
            case "getClaimNumber":
                return By.cssSelector("#NewClaimSaved-NewClaimSavedScreen-NewClaimSavedDV-Header").toString();
            case "selectVehicleOption":
                return "(//div[contains(@id,'_checkboxDiv')])[1]";
            case "New Property Incident":
                return "(//div[contains(text(), 'New Property Incident')])[1]";
            case "Ok":
                return "//*[@id=\"NewFixedPropertyIncidentPopup-NewFixedPropertyIncidentScreen-Update\"]/div/div[2]";
            case "AddMetroReportOK":
                return "//*[@id=\"NewMetroReportDetailsPopup-MetroReportDetailsScreen-Update\"]";
            case "PropertyRadioClick": return "//span[text()='Property ']/../preceding::div[1]";
            case "PropertyOK": return "OK";
            case "Injured Worker Name":return "//select[@name='FNOLWizard-FullWizardStepSet-FNOLWizard_BasicInfoScreen-Claimant_Name']";
            default:
                return key;
        }
    }
}

