package stepdefinitions.steps.pc;

import actions.pc.CreateNewAccount_Act;
import actions.pc.SubmissionScenarioCommon;
import actions.pc.SubmissionScenario_BOP;
import io.cucumber.java.en.And;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CreateSubmission_BOP {

    actions.pc.SubmissionScenarioHO ho= new actions.pc.SubmissionScenarioHO();
    SubmissionScenario_BOP bo= new SubmissionScenario_BOP();

    CreateNewAccount_Act cna = new CreateNewAccount_Act();

    SubmissionScenarioCommon ssc = new SubmissionScenarioCommon();

    public CreateSubmission_BOP() throws IOException, ParseException {
    }

    @And("User Quotes and issues a Business Owner policy with Modularized Excel")
    public void createSubmissionBOP() throws IOException, ParseException {
        bo.newSubmissionBOP();
        ssc.quoteAndIssueSubmisison();

    }
}
