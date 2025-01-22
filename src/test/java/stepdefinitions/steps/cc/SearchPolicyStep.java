package stepdefinitions.steps.cc;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import utilities.common.Config;
import java.io.IOException;
import actions.cc.SearchPolicy;


public class SearchPolicyStep {

    SearchPolicy m;
    Config co = new Config();
    public SearchPolicyStep() throws IOException, ParseException {
        m = new SearchPolicy();
    }
    @Then("User should able to search the Policy in Claim Center")
    public void searchClaim() throws IOException, ParseException {
        m.searchPolicy();
    }
}



