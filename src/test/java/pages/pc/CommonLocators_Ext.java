package pages.pc;

public class CommonLocators_Ext {

    public String getLocator(String key) {
        switch (key) {
            case "Quote":
                return "//div[@aria-label='Quote']/parent::div[@role='button']";
            case "Bind Options":
                return "//div[@aria-label='Bind Options']/parent::div[@role='button']";
            case "Submission Message":
                return "//div[contains(@id,'JobCompleteScreen-Message')]/div";
            case "UW Issue Approve":
                return "//*[contains(@id,'Job_RiskAnalysisScreen-RiskAnalysisCV-RiskEvaluationPanelSet-1-UWIssueRowSet-Approve')]";
            case "OK":
                return "//div[@role='button']//div[@aria-label='OK']";
            default:
                return key;
        }
    }
}
