package pages.bc;

import org.openqa.selenium.WebDriver;

public class Payment_Suspense {
    private WebDriver driver;

    public Payment_Suspense() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "PaymentActions": return "(//div[text()='Actions' and @class ='gw-label'])[last()]";
            case "MoveToSuspense": return "(//div[text()=\"Move To Suspense\"])[last()]";
            case "SuspenseExecute" : return "//*[@id=\"MovePaymentToSuspense-Update\"]/div";
            case "Desktop": return "//div[@aria-label='Desktop']";
            case "SuspensePaymentTab" : return "//*[@id=\"DesktopGroup-MenuLinks-DesktopGroup_DesktopSuspensePayments\"]/div/div[2]";
            case "PolicyFilter" : return "//*[@id=\"DesktopSuspensePayments-DesktopSuspensePaymentsScreen-DesktopSuspensePaymentsLV-PaymentDateHeader_inner\"]/div";
            case "PolicyFilter2" : return "//*[@id=\"DesktopSuspensePayments-DesktopSuspensePaymentsScreen-DesktopSuspensePaymentsLV-PaymentDateHeader_inner\"]/div";
            case "Payment Date": return "//div[text()='Suspense Payments']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[2]//div[text()]";
            case "Amount": return "//div[text()='Suspense Payments']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[9]//div[text()]";
            default: return key;
        }
    }
}
