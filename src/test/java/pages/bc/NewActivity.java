package pages.bc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewActivity {
    private WebDriver driver;

    public NewActivity() {
        this.driver = driver;
    }

    // Method to get the locator

    public String getLocator(String key) {
        switch (key) {
            case "Desktop": return "//div[@aria-label='Desktop']";
            case "My Activities": return "//div[@aria-label='My Activities']";
            case "Actions": return "//div[@aria-label='Actions' and @role='button']";
            case "New Shared Activity": return "//div[@aria-label='New Shared Activity']";
            case "Reminder": return "//div[@aria-label='New Shared Activity']/../../div[4]//div[@role='menuitem']/div[2][@aria-label='Reminder']";
            case "notification": return "//div[@aria-label='New Shared Activity']/../../div[4]//div[@role='menuitem']/div[2][@aria-label='notification']";
            case "Return to My Activities": return "Return to My Activities";
            case "Update": return "//div[@aria-label='Update']";
            case "My Approval Requests": return "//div[@aria-label='My Approval Requests']";
            case "OpenedAsc": return "//div[@class='gw-header-content-wrapper']//div[text()='Opened']";
            case "OpenedDesc": return "//div[@class='gw-header-content-wrapper']//div[text()='Opened']";
            case "SubjectLine": return "//*[@id='DesktopActivities-DesktopActivitiesScreen-DesktopActivitiesLV-0-Subject_button']";
            default: return key;
        }
    }
}
