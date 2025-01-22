package pages.bc;

import org.openqa.selenium.WebDriver;

public class NegativeWriteOff {
    private WebDriver driver;

    public NegativeWriteOff() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {

            case "Actions": return "//div[@aria-label='Actions' and @role='button']";
            case "New Transaction": return "//div[@aria-label='New Transaction']";
            case "Negative Write-Off": return "//div[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction-AccountDetailMenuActions_NegativeWriteoff']";
            case "Next": return "//div[contains(@id,'AccountNewNegativeWriteoffWizard-Next')]";
            case "Unapplied Fund":return "//select[@name='AccountNewNegativeWriteoffWizard-NewNegativeWriteoffWizardDetailsStepScreen-AccountDesignatedUnappliedInputs-UnappliedFund']";
            case "Full Amount": return "//div[contains(@id,'NegativeWriteoffDetailsDV-UseFullAmount_checkboxDiv') and @role='checkbox']";
            case "Amount": return "//input[contains(@name,'NegativeWriteoffDetailsDV-Amount')]";
            case "Click Next1": return "//div[contains(@id,'WriteoffWizard-Next')]";
            case "Finish": return "//div[contains(@id,'AccountNewNegativeWriteoffWizard-Finish')]";
            default: return key;
        }
    }
}
