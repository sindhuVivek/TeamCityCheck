package pages.bc;

import org.openqa.selenium.WebDriver;

public class NewDisbursement {
    private WebDriver driver;

    public NewDisbursement() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Actions": return "//div[@aria-label='Actions']";
            case "New Transaction" : return "//div[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction']";
            case "Disbursement": return "//*[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction-AccountDetailMenuActions_Disbursement']";
            case "DisbursementTab": return "//*[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailDisbursements']";
            case "Disbursement #": return "//*[@id=\"AccountDetailDisbursements-AccountDetailDisbursementsScreen-DisbursementsLV-DisbursementNumberHeader_inner\"]";
            case "Disbursement #2": return "//*[@id=\"AccountDetailDisbursements-AccountDetailDisbursementsScreen-DisbursementsLV-DisbursementNumberHeader_inner\"]";
            case "Amount In Table": return "//div[text()='Disbursements']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[8]//div[text()]";
            case "Amount In Table2": return "//div[text()='Disbursements']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[8]//div[text()]";
            case "Status": return "//div[text()='Disbursements']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[6]//div[text()]";
            case "Due Date": return "//div[text()='Due Date']/following-sibling::div//div[text()]";
            default: return key;
        }
    }
}
