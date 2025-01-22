package pages.bc;

import org.openqa.selenium.WebDriver;

public class PaymentTransfer {
    private WebDriver driver;

    public PaymentTransfer() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Actions" : return "(//div[text()='Actions' and @class ='gw-label'])[last()]";
            case "MoveToAccountUnappliedFund" : return "(//div[text()='Move To Account/Unapplied Fund'])[last()]";
            case "Search button" : return "//div[@id='MoveDirectBillPayment-EditDBPaymentScreen-PaymentDetailsDV-AccountNumber-AccountPicker']";
            case "Selected Account #" : return "//div[text()='Account #']/following-sibling::div[1]//input";
            case "Move Search" : return "(//div[text()='S' and @class ='gw-shortcutKey'])[last()]";
            case "Select" : return "(//div[text()='Select' and @class ='gw-label'])[last()]";
            case "Execute Without Distribution" : return "//div[@id='MoveDirectBillPayment-EditDBPaymentScreen-ExecuteWithoutDistribution']";
            default: return key;
        }
    }
}
