package stepdefinitions.steps.pc;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CopySubmission {
    actions.pc.CopySubmissionScenario cs=new actions.pc.CopySubmissionScenario();

    public CopySubmission() throws IOException, ParseException {
    }

    @When("User perform Copy Submission Transaction")
    public void performCopySubmission() throws IOException, ParseException, InterruptedException {
        cs.createCopySubmission();
    }
    @Then("User should be able to copy submission and issue a Policy.")
    public void verifyIssuedPolicy() throws IOException, ParseException {
        cs.verifySubmissionBoundMessage();
    }
}
