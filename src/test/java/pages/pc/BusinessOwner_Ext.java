package pages.pc;

public class BusinessOwner_Ext {

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
            case "Business Coverages":
                return"//div[contains(@id,'BOPBuildingPopup-BOPBuildingPanelSet-BuildingCoveragesTab')]";
            case "checkbox":
                return"//*[@id='BOPBuildingPopup-BOPBuildingPanelSet-BuildingCoveragesCovPatterns-CoverageCategoryInputSet-0-CovPatternInputGroup-_checkbox_checkboxDiv']/div";
            case "Location Coverages":
                return"//div[contains(@id,'BOPSBLLocationPopup-BOPSBLLocationPanelSet-LocationCoveragesTab')]";
            case "Location Additional Coverages":
                return"//div[@id='BOPSBLLocationPopup-BOPSBLLocationPanelSet-LocationAddlCoveragesTab']//*[@class='gw-label']";
            case "Small Business Line Coverages":
                return "//div[contains(@id,'SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-BOPWizardStepGroup-BOPBOPScreen-BOPBOPPanelSet-SBLLineCoveragesTab')]";
            case "Small Business Line Additional Coverages":
                return "//div[contains(@id,'SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-BOPWizardStepGroup-BOPBOPScreen-BOPBOPPanelSet-SBLAdditionalLineCoveragesTab')]";
                default:
                return key;
        }
    }
}
