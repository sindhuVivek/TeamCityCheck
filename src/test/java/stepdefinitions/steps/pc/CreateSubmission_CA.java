package stepdefinitions.steps.pc;

import actions.pc.SubmissionScenarioCA;
import actions.pc.SubmissionScenarioCommon;
import io.cucumber.java.en.And;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CreateSubmission_CA {

    SubmissionScenarioCommon ssc = new SubmissionScenarioCommon();

    SubmissionScenarioCA ca= new SubmissionScenarioCA();

    public CreateSubmission_CA() throws IOException, ParseException {
    }


    @And("User Quotes and issues a Commercial Auto policy with Modularized Excel")
    public void createSubmissionCA() throws IOException, ParseException {
        ca.newSubmissionCA();
        ssc.quoteAndIssueSubmisison();

    }
}
