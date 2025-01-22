package pages.pc;

import org.openqa.selenium.WebDriver;

public class commercial_Ext {
    private WebDriver driver;

    public commercial_Ext() {
        this.driver = driver;
    }


    public static String getLocator(String key) {
        switch (key) {
            case "Account":
                return "//div[@aria-label='Account']//..//following-sibling::div[@data-gw-click='toggleSubMenu']";
            case "Search":
                return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "Actions":
                return "//div[@aria-label='Actions']";
            case "New Submission":
                return "//div[contains(@id,'AccountFileMenuActions_NewSubmission')]";
            case "Product Name":
                return "";

            case "Next":
                return "Next";
            case "Next Page":
                return "//div[@aria-label='Next']";

            case "OK":
                return "//*[@id=\"CPBuildingPopup-Update\"]";
            case "ActivityTabMenu":
                return "//div[@id='TabBar-SearchTab-Search_ActivitySearch']";
            case "Rate":
                return "//*[@id=\"SubmissionWizard-Job_RiskAnalysisScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Rate\"]/div/div[2]";
            case "Blanketok":
                return "//*[@id=\"CPBlanketPopup-Update\"]/div";
            case "Management":
                return "//*[contains(@id,\"-ModifiersScreen-ScheduleRateDV-0-ScheduleRateLV-2-CreditDebit\")]/div/input";
            case "Bind Options":
                return "//div[@aria-label='Bind Options']/parent::div[@role='button']";
            case "Submission Message":
                return "//div[contains(@id,'JobCompleteScreen-Message')]/div";
            default:
                return key;

        }
    }
}

