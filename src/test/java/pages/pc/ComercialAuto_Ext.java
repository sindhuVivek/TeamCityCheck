package pages.pc;

public class ComercialAuto_Ext {

    public String getLocator(String key) {
        switch (key) {
            case "Account":
                return "//div[@aria-label='Account']//..//following-sibling::div[@data-gw-click='toggleSubMenu']";
            case "Search":
                return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "Actions":
                return "//div[@aria-label='Actions']";
            case "New Submission":
                return "//div[contains(@id,'AccountFileMenuActions_NewSubmission')]";
            case "Product Name":
                return "";
            default:
                return key;
        }
    }
}
