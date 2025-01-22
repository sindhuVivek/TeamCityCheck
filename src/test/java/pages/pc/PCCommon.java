package pages.pc;

import org.openqa.selenium.WebDriver;

public class PCCommon {
    private WebDriver driver;
    public PCCommon() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Policy":
                return "//div[@aria-label='Policy']/parent::div[@role='menuitem']/following-sibling::div[contains(@class,'expand-button')]";
            case "Policy Number":
                return "Policy #";
            case "Search":
                return "//div[contains(@id,'PolicyRetrievalItem_Button')]/span[contains(@aria-label,'search-icon')]";
            default: return key;
        }
    }
}
