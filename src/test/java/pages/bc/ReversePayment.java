package pages.bc;
import org.openqa.selenium.WebDriver;

public class ReversePayment {
    public WebDriver driver;

    public ReversePayment() {
        this.driver = driver;
    }
    public String getLocator(String key) {
        switch (key) {
            case "Payments" : return "//*[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailPayments']";
            case "Last Payment Actions" : return "(//div[text()='Actions' and @class ='gw-label'])[last()]";
            case "Last Reverse" : return  "(//div[text()=\"Reverse\"])[last()]";
            case "Reverse Reason" : return "Reason";
            case "Reverse OK" : return "//*[@id='DBPaymentReversalConfirmationPopup-Update']";
            case "Last Item button" : return "(//*[contains(@id, '-ActionButton')]//*[@role='button'])[last()]";
            default: return key;
        }
    }
}
