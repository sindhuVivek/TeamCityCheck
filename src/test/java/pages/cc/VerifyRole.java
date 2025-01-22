package pages.cc;

import org.openqa.selenium.WebDriver;

public class VerifyRole {
    private WebDriver driver;

    public VerifyRole() {
        this.driver = driver;
    }

    //public String fNOLWizardUnverifiedClaimInsuredName = "FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name";

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {

            case "Administration": return "Adminis";
            case "Roles": return "//div[text()='Roles']";
            case"Role Description": return "(//div[text()='Description']/following::div[@class='gw-value-readonly-wrapper'])[1]";
            case"Permission": return "(//div[text()='Permission']/following::td//div[@class='gw-label'])[5]";
            case"Code": return"(//div[text()='Code']/following::div[@class='gw-value-readonly-wrapper'])[1]";
            case"Description": return"(//div[text()='Description']/following::div[@class='gw-value-readonly-wrapper'])[3]" ;
            default:
                return key;
        }
    }
}

