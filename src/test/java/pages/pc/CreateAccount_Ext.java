package pages.pc;

import org.openqa.selenium.WebDriver;

public class CreateAccount_Ext {

    private WebDriver driver;

    public CreateAccount_Ext() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Account":
                return "//div[@id='TabBar-AccountTab']//*[@data-gw-click='toggleSubMenu']/div";
            case "Company":
                return "//*[@id='NewAccount-NewAccountScreen-NewAccountButton-NewAccount_Company']";
            case "New Account":
                return "//*[@id='TabBar-AccountTab-AccountTab_NewAccount']//*[@aria-label='New Account']";
            case "Search":
                return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "ZIP Code":
                return "//input[@name='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-PostalCode']";
            case "Return to Create Account":
                return "//div[text()='Return to Create account']";
            case "Address 1 Label":
                return "//*[@id='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-AddressLine1_Input']//div[text()='Address 1']";
            case "Actions":

                return "//*[@id='AccountFile-AccountFileMenuActions']//*[@aria-label='Actions']";
            case "New Submission":
                return "//div[contains(@id,'AccountFileMenuActions_NewSubmission')]";
            case "Product Name":
                return "";
            case "Next Page": return "//div[@aria-label='Next']";
            default:
                return key;

        }
    }
}
