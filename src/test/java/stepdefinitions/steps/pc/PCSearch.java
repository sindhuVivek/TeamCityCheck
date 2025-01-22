package stepdefinitions.steps.pc;

import actions.pc.PCSearch_Act;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PCSearch {

    PCSearch_Act sa = new PCSearch_Act();

    public PCSearch() throws IOException, ParseException {
    }

    @Then("user searches the account using account number")
    public void searchAccount_AccNumber() {
        sa.searchAccount_AccountNumber();
    }

    @Then("user searches the account using firstname and lastname")
    public void searchAccount_Name() {
        sa.searchAccount_FNLN();
    }

    @Then("user searches the account using Company")
    public void searchAccount_Company() {
        sa.searchAccount_Comp();
    }

    @Then("user searches the contact by Name")
    public void searchContact_Name() {
        sa.searchContact_FNLN();
    }

    @Then("user searches the contact by Company")
    public void searchContact_Company() {
        sa.searchContact_Comp();
    }

    @Then("user searches for a policy using Policy number")
    public void searchPolicy_Number() {
        sa.searchPolicy_Number();
    }

    @Then("user searches for a policy using name")
    public void searchPolicy_Name() {
        sa.searchPolicy_FNLN();
    }

    @Then("user searches for a activity with data")
    public void searchActivity() {
        sa.searchAct();
    }

    @Then("user searches for a note with data")
    public void searchNote() {
        sa.searchNotes();
    }

    @When("User searches a existing policy in PC")
    public void searchExistingPolicy() {
        sa.searchPolicy_Number();
    }
}
