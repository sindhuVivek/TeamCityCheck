package stepdefinitions.steps.pc;

import actions.pc.PolicyChangeScenario;
import actions.pc.SubmissionScenarioCommon;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import utilities.common.DataDrivenMethods;

import java.io.IOException;

public class PolicyChangeSteps {
    PolicyChangeScenario pcs = new PolicyChangeScenario();
    SubmissionScenarioCommon ssc = new SubmissionScenarioCommon();
    DataDrivenMethods ddm = new DataDrivenMethods();
    public PolicyChangeSteps() throws IOException, ParseException {
    }

    @Then("User executes a Policy Change and issues it for Homeowners with Modularized Excel")
    public void executePolicyChangeHO() throws IOException, ParseException, InterruptedException {
        pcs.initiatePolicyChange();
        pcs.policyChangeHO();
        ssc.quoteAndIssueSubmisison();
    }

    @Then("User executes a Policy Change and issues it for Personal Auto with Modularized Excel")
    public void executePolicyChangePA() throws IOException, ParseException, InterruptedException {
        ddm.click("//*[@id=\"PolicySearch-PolicySearchScreen-DatabasePolicySearchPanelSet-PolicySearch_ResultsLV-0-PolicyNumber_button\"]");
        pcs.initiatePolicyChange();
        pcs.policyChangePA();
        ssc.quoteAndIssueSubmisison();
    }

}

