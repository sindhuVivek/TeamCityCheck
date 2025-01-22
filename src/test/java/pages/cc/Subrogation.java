package pages.cc;

import org.openqa.selenium.WebDriver;

public class Subrogation {
    private WebDriver driver;

    public Subrogation() {
        this.driver = driver;
    }

    //public String fNOLWizardUnverifiedClaimInsuredName = "FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name";

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "tabBarClaimTabMoreOptions": return "//div[text()='laim']/..//following-sibling::div[2]";
            case "claimSearch" : return "//div[@id='TabBar-ClaimTab-ClaimTab_FindClaim']";
            case "Subrogation" : return "//div[@id='Claim-MenuLinks-Claim_ClaimSubrogationGroup']";
            case "Edit" : return "//div[@id = 'SubrogationGeneral-ClaimSubroSummaryScreen-SubrogationMainPanelSet-Edit']";
            case "Update" : return "//div[@id='SubrogationGeneral-ClaimSubroSummaryScreen-SubrogationMainPanelSet-Update']";
            case "clickSearch" : return "//div[@id='TabBar-ClaimTab-ClaimTab_FindClaim_Button']";
            default: return key;
        }
    }
}

