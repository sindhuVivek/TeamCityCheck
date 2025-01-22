package pages.cc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Notes {
    private WebDriver driver;

    public String getLocator(String key) {
        switch (key) {
            case "Claim":
                return "//div[@id='TabBar-ClaimTab']//descendant::div[contains(@class,'expand-button')]";
            case "SearchIcon":
                return "//div[@id='TabBar-ClaimTab-ClaimTab_FindClaim_Button']";
            case "ClaimNumber":
                return "//div[@id='TabBar-ClaimTab-ClaimTab_FindClaim']//div/input";
            case "Notes":
                return "//div[@id='Claim-MenuLinks-Claim_ClaimNotes']//div[@role='menuitem']";
            case "Topic":
                return "Topic:";
            case "Author:":
                return "Author:";
            case "Find Text:":
                return "Find Text:";
            case "Related To":
                return "Related To:";
            case "Date Range:":
                return "";
            case "Search":
                return "earch";
            case "Verify_Author":
                return "//div[text()='Author']/following-sibling::div[@class='gw-value']//div/div[contains(@class,'readonly')]";
            case "Verify_Topic":
                return "//div[text()='Topic']/following-sibling::div[@class='gw-value']//div/div[contains(@class,'readonly')]";
            case "Verify_NotesDetails":
                return "//div[contains(@id,'NotesSearchScreen')]//div[@class='gw-NoteBody--inner gw-value-readonly-wrapper']";
            case "Actions":
                return "Actions";
            case "Note":
                return "//div[contains(@id,'NewNote')]//div[@role='menuitem']";
            case "NoteTopic":
                return "//select[contains(@name,'NoteDetailDV-Topic')]";
            case "Security Type":
                return "//select[contains(@name,'NoteDetailDV-SecurityType')]";
            case "Subject":
                return "//input[contains(@name,'NoteDetailDV-Subject')]";
            case "Text":
                return "//div[contains(@id,'NoteDetailDV-Body')]//div[contains(@class,'TextArea')]//textarea";
            case "Related":
                return "//select[contains(@name,'NoteDetailDV-RelatedTo')]";
            case "Confidential":
                return "Confidential";
            case "Update":
                return "Update";
            default:
                return key;
        }
    }

}
