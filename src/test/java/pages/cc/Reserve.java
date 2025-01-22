package pages.cc;

import org.openqa.selenium.WebDriver;

public class Reserve {
    private WebDriver driver;

    public String getLocator(String key) {
        switch (key) {
            case "Actions": return "//div[text()='ctions']";
            case "Reserve": return "//div[contains(@id,'ClaimMenuActions_NewTransaction_ReserveSet')]//div[@role='menuitem']//div[@aria-label='Reserve']";
            case "Add": return "Add";
            case "Exposure": return "//select[contains(@name,'Exposure')]";
            case "Cost Type": return "//select[contains(@name,'CostType')]";
            case "Cost Category": return "//select[contains(@name,'CostCategory')]";
            case "Amount": return "//div[contains(@id,'NewAmount')]//input[@type='text' and @value='0.00']";
            case "Transactions": return "//div[@aria-label='Transactions']";
            case "Reserves": return "//select[contains(@name,'TransactionsLVRangeInput')]";
            case "Create Date": return "//div[contains(@id,'CreateDateHeader_toggleSort')]";
            case "View Details": return "//div[contains(@id,'-0-TransactionAmountViewDetail')]";
            case "ValidateCostType": return "//div[text()='Cost Type']/following-sibling::div[@class='gw-value']//div[@class='gw-label']";
            default: return key;
        }
    }
}

