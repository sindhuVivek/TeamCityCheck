package stepdefinitions.steps.cc;
import actions.cc.CreateClaim;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class CreateFNOLClaim {
    CreateClaim cc = new CreateClaim();

    public CreateFNOLClaim() throws IOException, ParseException {
    }

    // Cucumber step to create a IM claim
    @Then("user creates a claim for the IM claim type")
    public void creatClaim() throws IOException, ParseException {
        cc.createClaim();
    }
    @Then("user creates a unverified claim for the IM claim type")
    public void creatUnverifiedClaim() throws IOException, ParseException {
        cc.createUnverifiedIMClaim();
    }
    @Then("user creates a claim for the Quick IM claim type")
    public void creatQuickIMClaim() throws IOException, ParseException {
        cc.createQuickIMClaim();
    }
    @Then("user creates a claim for the Excess claim type")
    public void creatVerifiedExcessClaim() throws IOException, ParseException {
        cc.createVerifiedExcessClaim();
    }
    @Then("user creates a claim for the CP claim type")
    public void createCPClaim() throws IOException, ParseException {
        cc.createCPClaim();
    }

    @Then("user creates a claim for the Quick CP claim type")
    public void createQuickCPClaim() throws IOException, ParseException {
        cc.createQuickCPClaim();
    }

    @Then("user creates a unverified claim for the CP claim type")
    public void createUnverifiedCPClaim() throws IOException, ParseException {
        cc.createUnverifiedCPClaim();
    }
    @Then("user searches for the created PA claim")
    public void creatVerifiedPAClaim() throws IOException, ParseException {
        cc.createVerifiedPAClaim();
    }
    @Then("user searches for the created Unverified PA claim")
    public void creatUnVerifiedPAClaim() throws IOException, ParseException {
        cc.createUnVerifiedPAClaim();
    }
    @Then("user searches for the created Quick PA claim")
    public void creatQuickPAClaim() throws IOException, ParseException {
        cc.createQuickPAClaim();
    }
    @Then("user creates a claim for the BOP claim type")
    public void createVerifiedBOPClaim() throws IOException, ParseException {
        cc.createVerifiedBOPClaim();
    }
    @Then("user creates a unverified claim for the BOP claim type")
    public void createUnVerifiedBOPClaim() throws IOException, ParseException {
        cc.createUnVerifiedBOPClaim();
    }
    @Then("user creates a claim for the Quick BOP claim type")
    public void createQuickBOPClaim() throws IOException, ParseException {
        cc.createQuickBOPClaim();
    }
    @Then("user creates a claim for the CA claim type")
    public void createVerifiedCAClaim() throws IOException, ParseException {
        cc.createVerifiedCAClaim();
    }

    @Then("user creates a unverified claim for the CA claim type")
    public void createUnVerifiedCAClaim() throws IOException, ParseException {
        cc.createUnVerifiedCAClaim();
    }

    @Then("user creates a quick claim for the CA claim type")
    public void createQuickCAClaim() throws IOException, ParseException {
        cc.createQuickCAClaim();
    }
    @Then("user creates a claim for the HO claim type")
    public void createVerifiedHOClaim() throws IOException, ParseException {
        cc.createVerifiedHOClaim();
    }
    @Then("user creates a unverified claim for the HO claim type")
    public void createUnVerifiedHOClaim() throws IOException, ParseException {
        cc.createUnVerifiedHOClaim();
    }

    @Then("user creates a claim for the WC claim type")
    public void creatClaimWC() throws IOException, ParseException {
        cc.createVerifiedWCClaim();
    }
    @Then("user creates a unverified claim for the WC claim type")
    public void createUnVerifiedWCClaim() throws IOException, ParseException {
        cc.createUnverifiedWCClaim();
    }

}

