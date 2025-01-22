package pages.cc;
import org.openqa.selenium.WebDriver;

public class SearchPolicyScenario {
    private WebDriver driver;

    public SearchPolicyScenario() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Search":
                return "//div[@id='TabBar-SearchTab']";
            case "Policy #":
                return "//input[@name='SimpleClaimSearch-SimpleClaimSearchScreen-SimpleClaimSearchDV-PolicyNumber']";
            case "SearchPolicyClick":
                return "//div[@id='SimpleClaimSearch-SimpleClaimSearchScreen-SimpleClaimSearchDV-ClaimSearchAndResetInputSet-Search']";
            default:
                return key;
        }
    }
}

