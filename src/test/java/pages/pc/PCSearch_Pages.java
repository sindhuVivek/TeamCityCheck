package pages.pc;

import org.openqa.selenium.WebDriver;

public class PCSearch_Pages {
    private WebDriver driver;

    public PCSearch_Pages() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Search dropdown":
                return "//*[@id='TabBar-SearchTab']//*[@data-gw-click='toggleSubMenu']";
            case "AccountsTabMenu":
                return "//*[@id='TabBar-SearchTab-Search_AccountSearch']//div[text()='Accounts']";
            case "SearchButton":
                return "//*[@id='AccountSearch-AccountSearchScreen-AccountSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "PolicyTabMenu":
                return "//*[@id='TabBar-SearchTab-Search_PolicySearch']//div[text()='Policies']";
            case "ContactsTabMenu":
                return "//*[@id='TabBar-SearchTab-Search_ContactSearch']//div[text()='Contacts']";
            case "SearchButtonContact":
                return "//*[@id='ContactSearch-ContactSearchScreen-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "SearchButtonPolicy":
                return "//*[@id='PolicySearch-PolicySearchScreen-DatabasePolicySearchPanelSet-PolicySearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "ActivityTabMenu":
                return "//*[@id='TabBar-SearchTab-Search_ActivitySearch']//div[text()='Activities']";
            case "SearchActivity":
                return "//*[@id='ActivitySearch-ActivitySearchScreen-ActivitySearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "SearchNote":
                return "//*[@id='PolicyFile_Notes-Policy_NotesScreen-NoteSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "SearchResultsPolicyLink":
                return "//*[@id='PolicySearch-PolicySearchScreen-DatabasePolicySearchPanelSet-PolicySearch_ResultsLV-0-PolicyNumber_button']";
            case "NotesSideTab":
                return "//*[@id='PolicyFile-MenuLinks-PolicyFile_PolicyFile_Notes']//div";
            default:
                return key;

        }
    }
}
