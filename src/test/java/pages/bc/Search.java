package pages.bc;

public class Search {

    public String getLocator(String key) {
        switch (key) {
            case "Account": return "//div[@aria-label='Account']";
            case "Policy": return "//div[@aria-label='Policy']";
            case "SearchButton": return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "SearchResultAccount": return "//div[contains(@id,'AccountSearchResultsLV-0-AccountNumber_button')]";
            case "SearchResultPolicy": return "//div[contains(@id,'PolicySearchResultsLV-0-PolicyNumber_button')]";
            default: return key;
        }
    }
}
