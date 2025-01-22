package pages.pc;

import org.openqa.selenium.WebDriver;

public class PolicyRewrite_Ext {

    private WebDriver driver;

    public PolicyRewrite_Ext() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Search": return "//div[@aria-label='Search']//..//following-sibling::div[@data-gw-click='toggleSubMenu']";
            case "Search Policy": return "//*[@id='PolicySearch-PolicySearchScreen-DatabasePolicySearchPanelSet-PolicySearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "Search Account": return "//*[@id='AccountSearch-AccountSearchScreen-AccountSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "Open Policy": return "//*[@id='PolicySearch-PolicySearchScreen-DatabasePolicySearchPanelSet-PolicySearch_ResultsLV-0-PolicyNumber_button']";
            case "Open Account": return "//*[@id='AccountSearch-AccountSearchScreen-AccountSearchResultsLV-0-AccountNumber']";
            case "Rewrite Account Number": return "//*[@id=\"AccountFile_AccountSearch-OtherAccountSearchScreen-AccountSearchDV-AccountNumber\"]/div/input";
            case "Search Other Account": return "//*[@id='AccountFile_AccountSearch-OtherAccountSearchScreen-AccountSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "Open Other Account": return "//*[@id='AccountFile_AccountSearch-OtherAccountSearchScreen-OtherAccountSearchResultsLV-0-Select']";
            case "Select Policy": return "//*[@id='AccountFile_RewritePoliciesSelection-AccountFile_PolicySelectionLV-0-_Checkbox']";
            case "Rewrite Policies": return "//*[@id='AccountFile_RewritePoliciesSelection-RewritePoliciesButton']";
            case "Open Rewrite Policy": return "//*[@id='AccountFile_Summary-AccountSummaryDashboard-OpenPolicyTransactionsAccountListViewTile-OpenPolicyTransactionsAccountListViewTile_LV-0-Transaction']";
            case "Quote": return "//*[@id='ReinstatementWizard-ReinstatementWizard_ReinstatePolicyScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote']";
            case "Rewrite Quote": return "//*[@id='RewriteWizard-LOBWizardStepGroup-RewriteWizard_PolicyInfoScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote']";
            case "Rewrite New Account Quote": return "//*[@id='RewriteNewAccountWizard-LOBWizardStepGroup-RewriteNewAccountWizard_PolicyInfoScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote']";
            case "UW Issue Approve": return "//*[@id='RewriteWizard-Job_RiskAnalysisScreen-RiskAnalysisCV-RiskEvaluationPanelSet-1-UWIssueRowSet-Approve']";
            case "View Policy": return "//*[@id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy']";
            case "Rewrite Message": return "//*[@id=\"JobComplete-JobCompleteScreen-ttlBar\"]//div[@class='gw-TitleBar--title']";
            case "OK": return "//div[@role='button']//div[@aria-label='OK']";
            default: return key;
        }
    }
}
