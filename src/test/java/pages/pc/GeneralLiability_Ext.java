package pages.pc;

import org.openqa.selenium.WebDriver;

public class GeneralLiability_Ext {
    private WebDriver driver;

    public GeneralLiability_Ext() {
        this.driver = driver;
    }


    public String getLocator(String key) {
        switch (key) {
            case "Location Name":
                return "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityEUScreen-GeneralLiabilityEUDV-SubmissionWizard_GL_ExposureUnitsLV-0-Location\"]";
            case "Class Code":
                //return "//*[@class=\"gw-picker-input\"]";
                return "//*[contains(@name,'-ClassCode') and (@class='gw-picker-input')]";
            case "Basis":
                return "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityEUScreen-GeneralLiabilityEUDV-SubmissionWizard_GL_ExposureUnitsLV-0-BasisAmount\"]/div/input";
            case "Next":
                return "Next";
            case "Add":
                return "Add";
            case "Coverages":
                return "Coverages";
            case "Additional Coverages":
                return "//div[contains(@id,'GeneralLiability_AdditionalCoveragesCardTab')]";
            case "Add Coverages":
                return "Add Coverages";
            case "Search Coverages":
                return "//div[contains(@id,'CoveragePatternSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search')]";
            case "Add Selected Coverages":
                return "Add Selected Coverages";
            case "Designated Pollutants Coverage":
                return "//div[@id='CoveragePatternSearchPopup-CoveragePatternSearchScreen-CoveragePatternSearchResultsLV-0-_Checkbox']";
            case "Designated Pollutants":
                return "//*[contains(@id,'CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-StringTermInput')]/div/input";
            case "Location 1":
                return "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityEUScreen-GeneralLiabilityEUDV-SubmissionWizard_GL_ExposureUnitsLV-0-Location\"]/div/div/select/option[2]";
            case "Quote":
                return "//*[contains(@id,\"QuoteTypeToolbarButtonSet-Quote\")]/div/div[2]";
            case "Bind Options":
                return "//div[@aria-label='Bind Options']";
            case "Issue Policy":
                return "//*[@id='SubmissionWizard-SubmissionWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions-BindAndIssue'']/div/div[2]";
            case "Actions":
                return "//*[@id='AccountFile-AccountFileMenuActions']//*[@aria-label='Actions']";
            case "New Submission":
                return "//div[contains(@id,'AccountFileMenuActions_NewSubmission')]";
            case "Product Name":
                return "";
            case "Next Page":
                return "//div[@aria-label='Next']";
            default:
                return key;
        }
    }
}


