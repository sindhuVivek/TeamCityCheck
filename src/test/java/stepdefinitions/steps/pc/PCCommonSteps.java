package stepdefinitions.steps.pc;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PCCommonSteps {
    actions.pc.PCCommonScenario cs=new actions.pc.PCCommonScenario();
actions.pc.AuditScheduleScenario audit = new actions.pc.AuditScheduleScenario();
    public PCCommonSteps() throws IOException, ParseException {
    }

    @When("User searches a existing policy")
    public void searchAndOpenPolicy() throws IOException, ParseException {
        cs.searchAndOpenPolicy();
    }

    @When("I begin to audit the policy")
    public void auditPolicy() throws IOException, ParseException {
    audit.auditCreationAndValidation();
    }
}
