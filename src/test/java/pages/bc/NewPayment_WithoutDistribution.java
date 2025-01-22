package pages.bc;

public class NewPayment_WithoutDistribution {

    public String getLocator(String key) {
        switch (key) {
            case "InitialPayments": return "//*[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailPayments']/div[1]";
            case "Actions": return "//div[@aria-label='Actions' and @role='button']";
            case "New Payment": return "//*[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_Payments']/div[1]";
            case "NewDirectBillPayment": return "//*[@id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_Payments-AccountDetailMenuActions_NewDirectBillPayment']";
            case "Execute Without Distribution": return "//*[@id='NewDirectBillPayment-EditDBPaymentScreen-ExecuteWithoutDistribution']";
            case "UpdatedPayments": return "//div[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailPayments-AccountDetailPayments_AccountPayments']/div[1]";
            default: return key;
        }
    }
}
