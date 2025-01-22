package pages.pc;

import org.openqa.selenium.WebDriver;

public class AuditSchedule_Ext {
    private WebDriver driver;

    public AuditSchedule_Ext() {
        this.driver = driver;
    }


    public static String getLocator(String key) {
        switch (key) {
            case "Search Policy Tab": return "//div[@id='TabBar-PolicyTab']//div[@class='gw-action--expand-button']";
            case "Policy": return "//div[@aria-label='Policy']//..//following-sibling::div[@data-gw-click='toggleSubMenu']";
            case "Search": return "//div[contains(@id,'TabBar-PolicyTab-PolicyTab_PolicyRetrievalItem_Button')]";
            case "Policy #": return "//input[@name='TabBar-PolicyTab-PolicyTab_PolicyRetrievalItem']";
            case "Audit Schedule": return "//*[@id='PolicyFile-MenuLinks-PolicyFile_PolicyFile_Audits']";
            case "Final Audit":return "//*[@id='PolicyFile_Audits-AuditInformationScreen-AuditsLV-0-AuditType_button']";
            case "Details": return "//*[@id='AuditWizard-Details']/div";
            case "Start": return "//*[@id='PolicyFile_Audits-AuditInformationScreen-AuditsLV-0-Start']/div";
            case "Audited Basis": return "//input[@name='AuditWizard-AuditWizard_DetailsScreen-AuditDetailsPanelSet-0-PeriodDV-0-AuditedBasis']";
            case "Details1": return "//*[@id='UWBlockProgressIssuesPopup-IssuesScreen-DetailsButton']/div/div[2]";
            case "Special Approve": return "//div[text()='Special Approve']";
            case "OK": return "//div[@id='RiskApprovalDetailsPopup-Update']";
            default: return key;
        }
    }
}

