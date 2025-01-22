package pages.cc;

import org.openqa.selenium.WebDriver;

public class CheckWizard {
    private WebDriver driver;

    public CheckWizard() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Checks":
                return "//div[@aria-label='Checks' and text()='Check']";
            case "Actions":
                return "//div[text()='ctions']";
            case "Next":
            case "checkWizardNext1":
                return "Next";
            case "Payment Type":
                return "//*[@id=\"NormalCreateCheckWizard-CheckWizard_CheckPaymentsScreen-NewCheckPaymentPanelSet-NewPaymentDetailDV-Payment_PaymentType\"]/div/div/select";
            case "Category":
                return "//*[@id=\"NormalCreateCheckWizard-CheckWizard_CheckPaymentsScreen-NewCheckPaymentPanelSet-NewPaymentDetailDV-EditablePaymentLineItemsLV-0-LineCategory\"]/div/div/select";
            case "Amount":
                return "//*[@id=\"NormalCreateCheckWizard-CheckWizard_CheckPaymentsScreen-NewCheckPaymentPanelSet-NewPaymentDetailDV-EditablePaymentLineItemsLV-0-Amount\"]/div/input";
            case "Finish":
                return "//div[text()='inish']";
            default:
                return key;
        }
    }
}
