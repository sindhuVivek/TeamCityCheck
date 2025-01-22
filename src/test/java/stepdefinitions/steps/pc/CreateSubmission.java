package stepdefinitions.steps.pc;

import actions.pc.CreateNewAccount_Act;
import actions.pc.SubmissionScenarioCommon;
import actions.pc.SubmissionScenarioHO;
import actions.pc.SubmissionScenarioPA;
import actions.cc.CreateClaim;
import actions.pc.SubmissionScenarioCommon;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CreateSubmission {
    actions.pc.SubmissionScenarioCP cp = new actions.pc.SubmissionScenarioCP();
    SubmissionScenarioHO ho = new SubmissionScenarioHO();
    SubmissionScenarioPA pa = new SubmissionScenarioPA();
    CreateNewAccount_Act cna = new CreateNewAccount_Act();
    SubmissionScenarioCommon ssc = new SubmissionScenarioCommon();
    actions.pc.SubmissionScenarioGL gl = new actions.pc.SubmissionScenarioGL();

    public CreateSubmission() throws IOException, ParseException {
    }

    @Then("User Quotes and issues a Homeowners policy with Modularized Excel")
    public void createSubmissionHO() throws IOException, ParseException, InterruptedException {
        cna.CreateNewAccount_Person();
        ho.newSubmissionHO();
        ssc.quoteAndIssueSubmisison();
    }

    @Then("user quotes and issues a Personal Auto submission with Modularized Excel")
    public void createSubmissionPA() throws IOException, ParseException, InterruptedException {
        cna.CreateNewAccount_Person();
        pa.newSubmissionPA();
        ssc.quoteAndIssueSubmisison();
    }

    @Then("user quotes and issues a Commercial Property submission with Modularized Excel")
    public void SubmissionScenarioCP() throws IOException, ParseException, InterruptedException {
        cp.newSubmissionCP();
    }

    @Then("User Quotes and issues a General Liability policy with Modularized Excel")
    public void createSubmissionGL() throws IOException, ParseException {
        gl.newSubmissionGL();
        ssc.quoteAndIssueSubmisison();
    }

    @Then("User gets a Quick Quote for General Liability with Modularized Excel")
    public void createQuickQuoteGL() throws IOException, ParseException, InterruptedException {
        gl.newSubmissionQQGL();
        ssc.quickQuote();
    }
}
