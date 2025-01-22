package pages.cc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyUser {
    private WebDriver driver;

    public VerifyUser() {
        this.driver = driver;
    }

    //public String fNOLWizardUnverifiedClaimInsuredName = "FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name";

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Administration": return "Adminis";
            case "Search": return "earch";
            case "User Select": return "//div[@id='AdminUserSearchPage-UserSearchScreen-AdminUserSearchResultsLV-0-DisplayName']//div[@role='button']";
            case "Name": return "(//div[text()='Name']/..//div[@id='UserDetailPage-UserDetailScreen-UserDetailDV-UserDetailCommons-UserDetailInputSet-Name-GlobalPersonNameInputSet-NameSummary']//div)[2]";
            case "Role Name": return "//div[text()='Roles']/following::tr[2]/td[2]//div[@class='gw-label']";
            case "Role Description": return "//div[text()='Roles']/following::tr[2]/td[3]//div[@class='gw-value-readonly-wrapper']";
            case "Group": return "//div[text()='Groups']/following::tr[4]/td[2]//div[@class='gw-label']";
            case "Member Status": return "//div[text()='Groups']/following::tr[4]/td[3]//div[@class='gw-label']";
            case "Manager Status": return "//div[text()='Groups']/following::tr[4]/td[4]//div[@class='gw-label']";
            case "Profile": return "//div[text()='Profi']";
            case "Email": return "(//div[text()='Email']/..//div[@id='UserDetailPage-UserDetailScreen-UserProfileDV-UserContactInputSet-UserPreferencesContactInputSet-Email']//div)[2]";
            case "Authority Limit": return "//div[text()='Authorit']";
            case "Authority Limit Profile": return "(//div[text()='Authority Limit Profile']/..//div[@id='UserDetailPage-UserDetailScreen-UserAuthorityLimitsDV-AuthorityLimitsProfile']//div)[2]";
            case "Authority Description": return "(//div[text()='Description']/..//div[@id='UserDetailPage-UserDetailScreen-UserAuthorityLimitsDV-Description']//div)[2]";
            case "Limit Type": return "//div[text()='Authority Limits']/following::tr[2]/td[2]//div[@class='gw-label']";
            case "Amount": return "//div[text()='Authority Limits']/following::tr[2]/td[6]//div[@id='UserDetailPage-UserDetailScreen-UserAuthorityLimitsDV-EditableAuthorityLimitsLV-0-LimitAmount']/div";
            default:
                return key;
        }
    }
}

