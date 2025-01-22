package stepdefinitions.steps.cc;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import actions.cc.SearchClaim;
import utilities.common.Config;

public class SearchClaimStep {

    SearchClaim m;
    Config co = new Config();
    public SearchClaimStep() throws IOException, ParseException {
        m = new SearchClaim();
    }
  @Then("User should able to search the claim")
    public void searchClaim() throws IOException, ParseException {
        m.searchClaim();
   }
}