package pages.bc;

import org.openqa.selenium.WebDriver;

public class Recapture {
    private WebDriver driver;

    public Recapture() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Account": return "//div[@id='TabBar-AccountsTab']";
            case "CurrentDate": return "//div[@id='AccountsGroup-CurrentDateInfoBar-CurrentDate']//div[contains(@class, 'gw-infoValue')]";
            case "Search": return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "AccountNumberLink": return "//div//*[@id='Accounts-AccountSearchScreen-AccountSearchResultsLV-0-AccountNumber_button']";
            case "Charges": return "//div[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailCharges']//div[@role='menuitem']";
            case "Actions": return "//div[@id='AccountGroup-AccountDetailMenuActions']";
            case "New Transaction": return "//div[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction']";
            case "Recapture": return "//div[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction']//div[contains(@class, 'gw-subMenu')]//div[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction-AccountDetailMenuActions_Recapture']//div[@role='menuitem']";
            case "DateSortAsc": return "//div[@id='AccountDetailCharges-AccountDetailChargesScreen-AccountDetailChargesListDetailPanel-ChargesLV-ChargeDateHeader']";
            case "DateSortDesc": return "//div[@id='AccountDetailCharges-AccountDetailChargesScreen-AccountDetailChargesListDetailPanel-ChargesLV-ChargeDateHeader']";
            default: return key;
        }
    }
}
