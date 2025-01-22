package pages.cc;
import org.openqa.selenium.WebDriver;

public class SearchContactsScenario {
    private WebDriver driver;

    public SearchContactsScenario() { this.driver = driver; }

    public String getLocator(String key)  {
        switch (key) {
            case "Address Book":
                return "//div[@id='TabBar-AddressBookTab']";
            case "Type":
                return "//*[@id='AddressBookSearch-AddressBookSearchScreen-AddressBookSearchDV-ContactSubtype']";
            case "SubType" :
                return "//select[@name='AddressBookSearch-AddressBookSearchScreen-AddressBookSearchDV-ContactSubtype']";
            case "Company Name" :
                return "//input[@name='AddressBookSearch-AddressBookSearchScreen-AddressBookSearchDV-NameInputSet-GlobalContactNameInputSet-Name']";
            case "Contacts SearchBtn" : case "Contacts SearchBtn2" :
                return "//div[@id='AddressBookSearch-AddressBookSearchScreen-AddressBookSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
            case "Person First Name" :
                return "//input[@name='AddressBookSearch-AddressBookSearchScreen-AddressBookSearchDV-NameInputSet-GlobalPersonNameInputSet-FirstName']";
            case "Person Last Name" :
                return "//input[@name='AddressBookSearch-AddressBookSearchScreen-AddressBookSearchDV-NameInputSet-GlobalPersonNameInputSet-LastName']";
            default:
                return key;
        }
    }
}