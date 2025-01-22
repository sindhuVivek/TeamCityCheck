package pages.bc;

import org.openqa.selenium.WebDriver;

public class ReverseWriteOff {
    private WebDriver driver;

    public ReverseWriteOff() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Previous Amount": return "//*[@id=\"AccountSummary-AccountSummaryScreen-SummaryChartPanelSet-ValueChart\"]/div/div[2]/div[5]/div/div[2]";
            case "Actions": return "//div[@aria-label='Actions']";
            case "New Transaction": return "//div[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction']";
            case "Write-Off Reversal": return "//div[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction-AccountDetailMenuActions_WriteoffReversal']";
            case "Search": return "//div[contains(@id,'WriteoffReversal') and contains(@id,'SearchLinksInputSet-Search') and @role='button']";
            case "Reversal Amount": return "//*[@id=\"AccountNewWriteoffReversalWizard-NewWriteoffReversalAccountWriteoffsScreen-NewWriteoffReversalWriteoffsLV-0-Amount\"]/div/div";
            case "Select": return "//div[@id='AccountNewWriteoffReversalWizard-NewWriteoffReversalAccountWriteoffsScreen-NewWriteoffReversalWriteoffsLV-0-Select']";
            case "Finish": return "//div[contains(@id,'WriteoffReversalWizard-Finish')]";
            case "Overview": return "//*[@id=\"AccountGroup-MenuLinks-AccountGroup_AccountOverview\"]/div[1]/div[2]";
            case "Actual Amount": return "//*[@id=\"AccountSummary-AccountSummaryScreen-SummaryChartPanelSet-ValueChart\"]/div/div[2]/div[5]/div/div[2]";
            default: return key;
        }
    }
}
