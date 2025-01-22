package pages.cc;
import org.openqa.selenium.WebDriver;

public class SearchScenario {
    private WebDriver driver;

    public SearchScenario() {
        this.driver = driver;
    }
    public String getLocator(String key) {
        switch (key) {
            case "Search":
                return "//div[@id='TabBar-SearchTab']";
            case "Claim #":
                return "//input[@name='SimpleClaimSearch-SimpleClaimSearchScreen-SimpleClaimSearchDV-ClaimNumber']";
            case "SearchClaimClick":
                return "//div[@id='SimpleClaimSearch-SimpleClaimSearchScreen-SimpleClaimSearchDV-ClaimSearchAndResetInputSet-Search']";
            case "ClickClaimLink":
                return "//div[contains(@id,'ClaimNumber_button') and @role='button']";
            default:
                return key;
        }
    }
}
