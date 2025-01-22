package pages.bc;

public class NewPayment_WithDistribution {

    public String getLocator(String key) {
        switch (key) {
            case "InitialPayments": return "//*[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailPayments']/div[1]";
            case "Actions": return "//div[@aria-label='Actions' and @role='button']";
            case "New Payment": return "//*[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_Payments']/div[1]";
            case "NewDirectBillPayment": return "//*[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_Payments-AccountDetailMenuActions_NewDirectBillPayment']";
            case "Execute": return "//*[@id='NewDirectBillPayment-EditDBPaymentScreen-Update']/div/div[2]";
            case "UpdatedPayments": return "//*[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailPayments']/div[1]";
            default: return key;
        }
    }
}
