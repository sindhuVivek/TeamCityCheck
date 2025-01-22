package pages.pc;

import org.openqa.selenium.WebDriver;

public class PolicyChange {
    private WebDriver driver;
    public PolicyChange() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Actions":
                return "//div[@aria-label='Actions' and @role='button']";
            case "Change Policy":
                return "//div[@aria-label='Change Policy']/parent::div[@role='menuitem']";
            case "Effective Date":
                return "//div[text()='Effective Date']/following-sibling::div[@class='gw-value']//input[@type='text']";
            case "Description":
            case "Building Description":
                return "//div[text()='Description']/following-sibling::div[@class='gw-value']//input[@type='text']";
            case "Next":
                return "//div[contains(@aria-label,'Next')]/parent::div[@role='button']";
            case "Offering Selection":
                return "//div[text()='Offering Selection']/following-sibling::div[@class='gw-value']//select";
            case "Quote":
                return "//div[@aria-label='Quote']/parent::div[@role='button']";
            case "Issue Policy":
                return "//div[@aria-label='Issue Policy']/parent::div[@role='button']";
            case "Submission Message":
                return "//div[contains(@id,'JobCompleteScreen-Message')]/div";
            case "Coverage Type":
                return "//div[text()='Policy Coverages and Exclusions']/parent::div[@role='tab']";
            case "Employer's Liability Limit":
                return "//select[contains(@name,'EmpLia')]";
            case "Organization Type":
                return "//select[contains(@name,'OrganizationType')]";
            case "Add Location Actions":
                return "//div[@aria-label='options']";
            case "Add Building":
                return "//div[@aria-label='Add Building']/parent::div[@role='menuitem']";
            case "New Building":
                return "//div[text()='New Building']/parent::div[@role='menuitem']";
            case "OK":
                return "//div[@aria-label='OK']/parent::div[@role='button']";
            default: return key;
        }
    }
}
