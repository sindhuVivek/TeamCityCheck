package pages.cc;

import org.openqa.selenium.WebDriver;

public class Negotiation {
    private WebDriver driver;

    public Negotiation() {
        this.driver = driver;
    }

    public String getLocator(String key) {
        switch (key) {
            case "Plan of Action": return "//div[@role='menuitem']/div[@aria-label='Plan of Action']";
            case "New Negotiation": return "//div[@id='ClaimNegotiations-ClaimNegotiationsScreen-CN_Add']//div[@aria-label='New Negotiation']";
            case "Name": return "//div[contains(@id,'General_Name')]//input";
            case "Edit": return "//div[@aria-label='Edit']";
            case "NegotiationCheckbox": return "//div[contains(@id,'0-_Checkbox_checkboxDiv')]";
            case "NegotiationsTitle": return "//div[contains(@id,'ClaimNegotiationsScreen')]//div[@role='heading']";
            default: return key;
        }
    }
}

