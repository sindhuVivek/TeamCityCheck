package pages.bc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTroubleTicket {
    private WebDriver driver;

   // private WebElement accountSelectCheckbox;

    public NewTroubleTicket() {
        this.driver = driver;
    }

    public String getLocator(String key) {

        switch (key) {
            case "TroubleTicketScreen": return "//*[@id='AccountGroup-MenuLinks-AccountGroup_AccountDetailTroubleTickets']";
            case "My Trouble Tickets": return "//div[@id='DesktopGroup-MenuLinks-DesktopGroup_DesktopTroubleTickets']";
            case "Desktop": return "//div[@aria-label='Desktop']";
            case "Search": case "Search1": return "//div[contains(@id,'SearchLinksInputSet-Search')]";
            case "AccountSelect": return "//div[text()='Accounts']/following::table//tr[2]/td[2]//div[@role='checkbox']";
            case "PolicySelect": return "//div[text()='Policies']/following::table//tr[2]/td[2]//div[@role='checkbox']";
            case "Finish": return "inish";
            case "Next": case "Next1": case "Next2": case "Next3": return "Next";
            default: return key;
        }
    }
}



