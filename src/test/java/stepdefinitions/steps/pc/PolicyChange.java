package stepdefinitions.steps.pc;

import actions.pc.PolicyChangeScenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PolicyChange {
    actions.pc.PolicyChangeScenario pc=new actions.pc.PolicyChangeScenario();

    public PolicyChange() throws IOException, ParseException {
    }

    @When("User initiates policy change")
    public void initiatePolicyChange() throws Exception {
        pc.initiateChangePolicyTransaction();
    }
    @And("Updates the CA policy")
    public void updateCAPolicy() throws Exception {
        pc.updateValuesCAPolicyChangeTransaction();
        pc.verifyPolicyChangeBoundMessage();
    }
    @And("Updates the WC policy")
    public void updateWCPolicy() {
        pc.updateValuesWCPolicyChangeTransaction();
        pc.verifyPolicyChangeBoundMessage();
    }
    @And("Updates the IM policy")
    public void updateIMPolicy() throws Exception {
        pc.updateValuesIMPolicyChangeTransaction();
        pc.verifyPolicyChangeBoundMessage();
    }
}
