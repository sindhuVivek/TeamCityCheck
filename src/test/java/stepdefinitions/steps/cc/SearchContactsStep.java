package stepdefinitions.steps.cc;
import actions.cc.SearchContacts;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import utilities.common.Config;
import java.io.IOException;

public class SearchContactsStep {

    SearchContacts m;
    Config co = new Config();

    public SearchContactsStep() throws IOException, ParseException {
        m = new SearchContacts();
    }
    @Then("User should able to search the Company Contacts with Company Name details in Claim Center")
    @Then("User should able to search the Person Contact with Person details in Claim Center")
    public void searchContacts() throws IOException, ParseException {
        m.searchContacts();
    }
    }
