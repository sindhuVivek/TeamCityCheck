package pages.pc;
public class Homeowners_Ext {


    public String getLocator(String key) {
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
            case "Return to Create Account":
                return "//div[text()='Return to Create account']";
            case "Accept Terrorism Risk Insurance Act":
                return "#SubmissionWizard-LOBWizardStepGroup-SubmissionWizard_PolicyInfoScreen-SubmissionWizard_PolicyInfoDV-ReinsuranceInfoInputSet-Reinsurance_Ext_1";
            case "Reinsurance":
                return "#SubmissionWizard-LOBWizardStepGroup-SubmissionWizard_PolicyInfoScreen-SubmissionWizard_PolicyInfoDV-TRIAInfo_ExtInputSet-TerrorismRisk_Ext_1";
            case "Location Name":
                return "[id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityEUScreen-GeneralLiabilityEUDV-SubmissionWizard_GL_ExposureUnitsLV-0-Location']";
            case "Class Code":
                return "#SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityEUScreen-GeneralLiabilityEUDV-SubmissionWizard_GL_ExposureUnitsLV-0-ClassCode > div.gw-vw--value > input";
            case "Basis":
                return "#SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityEUScreen-GeneralLiabilityEUDV-SubmissionWizard_GL_ExposureUnitsLV-0-BasisAmount > div > input[type=text]";
            case "Search Coverages":
                return "#CoveragePatternSearchPopup-CoveragePatternSearchScreen-CoveragePatternSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search";
            case "Designated Pollutants Coverage":
                return "#CoveragePatternSearchPopup-CoveragePatternSearchScreen-CoveragePatternSearchResultsLV-0-_Checkbox";
            case "Designated Pollutants":
                return "#SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityScreen-AdditionalCoveragesPanelSet-AdditionalCoveragesDV-0-CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-StringTermInput > div > input[type=text]";
            case "Location 1":
                return "#SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GeneralLiabilityEUScreen-GeneralLiabilityEUDV-SubmissionWizard_GL_ExposureUnitsLV-0-Location > div > div > select > option:nth-child(2)";
            case "QuotePolicyChange":
                return "#PolicyChangeWizard-LOBWizardStepGroup-LineWizardStepSet-HOPModifiersScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote";
            case "Who occupies this dwelling?":
                return "//*[@id=\"SubmissionWizard-SubmissionWizard_PreQualificationScreen-PreQualQuestionSetsDV-QuestionSetsDV-0-QuestionSetLV-2-QuestionModalInput-ChoiceSelectInput\"]/div/div/select";
            case "Loss of Rental Income":
                return "//div[contains(@id,'-dwellingCoveragePatternIterator-3-CoverageInputSet-CovPatternInputGroup-HOPCovDLossOfRent_1')]";
            case "Approve":
                return "#PolicyChangeWizard-Job_RiskAnalysisScreen-RiskAnalysisCV-RiskEvaluationPanelSet-1-UWIssueRowSet-Approve";
            default:
                return key;
        }
    }
}

