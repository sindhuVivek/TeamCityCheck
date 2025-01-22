package pages.cc;

import org.openqa.selenium.WebDriver;

public class Service {
    private WebDriver driver;

    public Service() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "tabBarClaimTabMoreOption":
                return "//div[text()='laim']/..//following-sibling::div[2]";
            case "tabBarSearchTabMoreOption":
                return "";
            case "claimSearch":
                return "//input[@name='TabBar-ClaimTab-ClaimTab_FindClaim']";
            case "clickSearch":
                return "//div[@id='TabBar-ClaimTab-ClaimTab_FindClaim_Button']";
            case "Vendor Name":
                return "//div[contains(@id,'SpecialistMenuIcon')]";
            case "Auto body":
                return "//div[text()='Auto body']/preceding::div[@role='checkbox'][1]";
            case "Update": case "Update1":
                return "//div[contains(@id,'CustomUpdateButton')]";
            case "Ok":
                return "//div[contains(@id,'UpdateServiceRequestServices')]";
            case "New Vendor2":
                return "//div[contains(text(),'New Vendor')][1]";
            case "AssignFromList": case "Assign": return "//div[@id='ClaimServiceRequests-StateToolbar-AssignService' or @id='AssignServiceRequestPopup-AssignmentPopupScreen-AssignmentPopupDV-AssignmentPopupScreen_ButtonButton']";
            case "CancelServiceBtn": case "Cancel Service": return "//div[@id='ClaimServiceRequests-StateToolbar-Cancel' or @id='OperationReasonPromptPopup-Update']";
            default:
                return key;
        }
    }
}

