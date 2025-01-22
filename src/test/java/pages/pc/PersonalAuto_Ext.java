package pages.pc;

public class PersonalAuto_Ext {
    public String getLocator(String key) {
        switch (key) {
            case "New Person":
                return "//div[contains(@id,'ContactType')]";
            case "RolesTab":
                return "//div[contains(@id,'RolesCardTab')]";
            case "NoOfAccidentsPolicyLevel":
                return "//*[@id='gw-center-bottom-section']//div[text()='Number of Accidents']//following::select[1]";
            case "NoOfAccidentsAccountLevel":
                return "//*[@id='gw-center-bottom-section']//div[text()='Number of Accidents']//following::select[2]";
            case "NoOfViolationsPolicyLevel":
                return "//*[@id='gw-center-bottom-section']//div[text()='Number of Violations']//following::select[1]";
            case "NoOfViolationsAccountLevel":
                return "//*[@id='gw-center-bottom-section']//div[text()='Number of Violations']//following::select[2]";
            case "VIN":
                return "//input[contains(@name,'Vin')]";
            case "Model Year":
                return "//input[contains(@name,'Year')]";
            case "Make":
                return "//input[contains(@name,'Make')]";
            case "Model":
                return "//input[contains(@name,'Model')]";
            case "Body Type":
                return "//select[contains(@name,'BodyType')]";
            case "AdditionalCoveragesTab":
                return "//div[contains(@id,'AdditionalCoveragesTab')]";
            case "ExclusionsAndConditionsTab":
                return "//div[contains(@id,'exclusionsAndConditionsCardTab')]";
            case "Search":
                return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "NewPerson1":
                return "//div[contains(@id,'DriverDetails1-PAQuickQuoteDriverPanelSet-AddDriverButton-0-ContactType')]";
            case "NewVehicle1":
                return "//div[contains(@id,'VehicleDetails1-PAQuickQuoteVehiclePanelSet-AddVehicleButton')]";
            case "Actions":
                return "//div[@aria-label='Actions']";
            case "New Submission":
                return "//div[contains(@id,'AccountFileMenuActions_NewSubmission')]";
            case "OK":
                return "//div[@role='button']//div[@aria-label='OK']";
            case "AddDriver":
                return "//div[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-PAVehiclesScreen-PAVehiclesPanelSet-VehiclesListDetailPanel-VehiclesDetailsCV-PersonalAuto_VehicleDV-PersonalAuto_AssignDriversInputSet-DriverPctLV_tb-AddDriver-0-Driver\"]/div[@role='button']/div[@class='gw-label']";
            default:
                return key;
        }
    }
}