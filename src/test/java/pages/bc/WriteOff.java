package pages.bc;

import org.openqa.selenium.WebDriver;

public class WriteOff {
    private WebDriver driver;

    public WriteOff() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Actions": return "//div[@aria-label='Actions' and @role='button']";
            case "New Transaction": return "//div[@aria-label='New Transaction']";
            case "Write-Off": return "//div[@aria-label='Write-Off']";
            case "Set Account As Target of Write-Off": return "//div[@aria-label='Set Account As Target of Write-Off']";
            case "Select 1st policy": return "//div[contains(@id,'AccountPolicyPeriodsLV-0-Select')]";
            case "Next": return "//div[@aria-label='Next']";
            case "All": return "//div[contains(@id,'FullAmount_Input')]//div[@role='checkbox']";
            case "WriteOffAmount": return "Amount";
            case "Reason": return "Reason";
            case "Next2": return "//div[@aria-label='Next']";
            case "Finish": return "//div[@aria-label='Finish']";
            //validate Write Off successfully Created in policy level
            case "Transactions": return "//div[contains(@id, 'DetailTransactions')]//div[@aria-label='Transactions']";
            case "DateDesc": return "//div[@class='gw-header-content-wrapper']//div[text()='Date']";
            case "DateAsc": return "//div[@class='gw-header-content-wrapper']//div[text()='Date']";
            case "Description": return "//td[contains(@id, 'TransactionDetailsLV-0-TransactionDesc_Cell')]//div[text()]";
            case "Paid": return "//td[contains(@id, 'TransactionDetailsLV-0-Paid_Cell')]//div[text()]";
            //validate Write Off successfully Created in account level
            case "Items": return "//td[contains(@id, 'AccountDetailTransactionsLV-0-TransactionDesc_Cell')]//div[text()]";
            case "Amount": return "//td[contains(@id, 'AccountDetailTransactionsLV-0-Amount_Cell')]//div[text()]";
            default: return key;


        }
    }
}
