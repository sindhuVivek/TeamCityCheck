package pages.bc;

import org.openqa.selenium.WebDriver;

public class ReversalNegativeWriteOff {
    private WebDriver driver;

    public ReversalNegativeWriteOff() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Actions": return "//div[@aria-label='Actions' and @role='button']";
            case "New Transaction": return "//div[@aria-label='New Transaction']";
            case "Negative Write-Off Reversal": return "//div[@aria-label='Negative Write-Off Reversal']";
            case "Search Negative Write-Off": return "//div[contains(@id,'AccountNewNegativeWriteoffReversalWizard-NewNegativeWriteoffReversalSearchScreen-NegativeWriteoffSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search') and @role='button']";
            case "Select 1st Negative Write-Off": return "(//div[@class=\"gw-multi-content-cell\"]/div[contains(@id,'NegativeWriteoffsLV')])[last()]";
            case "Finish": return "//div[@aria-label='Finish']";
            //validate Negative Write Off successfully Reversal
            case "Transactions": return "//*[@id=\"AccountGroup-MenuLinks-AccountGroup_AccountDetailTransactions\"]/div/div[2]";
            case "DateAsc": return "//div[@class='gw-header-content-wrapper']//div[text()='Date']";
            case "DateDesc": return "//div[@class='gw-header-content-wrapper']//div[text()='Date']";
            case "ValidationAmount": return "//*[@id='AccountDetailTransactions-AccountDetailTransactionsScreen-AccountDetailTransactionsLV-0-Amount']";
            default: return key;


        }
    }
}
