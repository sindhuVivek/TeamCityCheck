package pages.cc;

import org.openqa.selenium.WebDriver;

public class VerifyGroup {
    private WebDriver driver;

    public VerifyGroup() {
        this.driver = driver;
    }

    //public String fNOLWizardUnverifiedClaimInsuredName = "FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name";

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Administration": return "Adminis";
            case "Groups": return "//div[text()='Groups']";
            case "Search": return "earch";
            case "Queues": return "//div[text()='ueues']";
            case "Group Select": return "//div[@id='AdminGroupSearchPage-GroupSearchScreen-GroupSearchResultsLV-0-Name']";
            case "Group Type": return "//div[text()='Type']/..//div[@id='GroupDetailPage-GroupDetailScreen-GroupDetailDV-Type']/div/div/div";
            case "Supervisor": return "//div[text()='Supervisor']/..//div[@id='GroupDetailPage-GroupDetailScreen-GroupDetailDV-Supervisor']/div/div/div";
            case "Security Zone": return "//div[text()='Security Zone']/..//div[@id='GroupDetailPage-GroupDetailScreen-GroupDetailDV-SecurityZone']/div/div/div";
            case "User Name": return "//div[text()='Users']/following::tr[2]/td[2]//div[@class='gw-link gw-label']";
            case "Member Status": return "//div[text()='Users']/following::tr[2]/td[3]//div[@class='gw-value-readonly-wrapper']";
            case "Active Status": return "//div[text()='Users']/following::tr[2]/td[4]//div[@class='gw-value-readonly-wrapper']";
            case "Vacation Status": return "//div[text()='Users']/following::tr[2]/td[8]//div[@class='gw-label']";
            case "Proximity Search Status": return "//div[text()='Users']/following::tr[2]/td[10]//div[@class='gw-label']";
            //case "Queues": return "(//div[text()='Description']/following::div[@class='gw-value-readonly-wrapper'])[3]";
            case "Visible in Subgroups": return "//div[text()='Visible in Subgroups?']/following::tr//td[4]//div[@class='gw-label']";
            case "Description": return "//div[text()='Description']/following::tr//td[3]//div[@class='gw-value-readonly-wrapper']";
            default:
                return key;
        }
    }
}

