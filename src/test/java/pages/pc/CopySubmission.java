package pages.pc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CopySubmission {

    private WebDriver driver;

    public CopySubmission() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Actions":
                return "//div[@aria-label='Actions' and @role='button']";
            case "Copy Submission":
                return "//div[@aria-label='Copy Submission']/parent::div[@role='menuitem']";
            case "Next":
                return "//div[text()='Next']/parent::div[@role='button']";
            case "Quote":
                return "//div[@aria-label='Quote']/parent::div[@role='button']";
            case "Bind Options":
                return "//div[@aria-label='Bind Options']/parent::div[@role='button']";
            case "Issue Policy":
                return "//div[@aria-label='Issue Policy']/parent::div[@role='menuitem']";
            case "Submission Message":
                return "//div[contains(@id,'JobCompleteScreen-Message')]/div";
            default: return key;
        }
        }
}
