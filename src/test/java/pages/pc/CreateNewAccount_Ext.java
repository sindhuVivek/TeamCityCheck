package pages.pc;

import org.openqa.selenium.WebDriver;

public class CreateNewAccount_Ext {
    private WebDriver driver;

    public CreateNewAccount_Ext() {
        this.driver = driver;
    }
    public String fNOLWizardUnverifiedClaimInsuredName ="select[name$='FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name']";
    public String fNOLWizardFindPolicyPanelSetPolicyResultLV = "//div[@id='FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-PolicyResultLV-0-Insured']/div/div";
    //public String fNOLWizardUnverifiedClaimInsuredName = "FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name";

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Account": return "//div[@aria-label='Account']//..//following-sibling::div[@data-gw-click='toggleSubMenu']";
            case "Search": return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "Actions": return "//div[@aria-label='Actions']";
            case "New Submission": return "//div[contains(@id,'AccountFileMenuActions_NewSubmission')]";
            case "Product Name": return "";
            case "New Account":return "(//div[text()='New Account'])[2]";
            case "Return to Create Account": return "//div[text()='Return to Create account']";
            default: return key;
        }
    }
}

