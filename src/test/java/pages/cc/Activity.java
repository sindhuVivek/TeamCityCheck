package pages.cc;

import org.openqa.selenium.WebDriver;

public class Activity {
    private WebDriver driver;

    public Activity() {
        this.driver = driver;
    }

    //public String fNOLWizardUnverifiedClaimInsuredName = "FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name";

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "tabBarClaimTabMoreOption": return "//div[text()='laim']/..//following-sibling::div[2]";
            case"tabBarSearchTabMoreOption": return "";
            case "claimSearch" : return "//input[@name='TabBar-ClaimTab-ClaimTab_FindClaim']";
            case "clickSearch" : return "//div[@id='TabBar-ClaimTab-ClaimTab_FindClaim_Button']";
            //case "clickSearchActivity" : return "//div[@id='ActivitySearch-ActivitySearchScreen-ActivitySearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "Activity Type" : return "//div[text()='Make initial contact with insured']";
            case "Description" :return "//textarea[@name='NewActivity-NewActivityScreen-NewActivityDV-Activity_Description']";
            case "Search" : return "Searc";
            case "Interview": return "//div[text()='Interview']";
            default: return key;
        }
    }
}

