package stepdefinitions.steps.cc;

// Selenium imports
import actions.cc.*;
import actions.pc.PolicyRewriteScenario;
import io.cucumber.java.en.Given;
// Framework imports
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import pages.generic.navigation.Login;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import pages.generic.navigation.Login;
import utilities.common.Config;
import utilities.common.ExcelData;

import java.io.IOException;

public class CommonSteps {

    //Objects needed to run the class
    CreateClaim m;
    VerifyUserScenario cc;
    VerifyRoleScenario role;
    VerifyGroupScenario group;
    Config co = new Config();
    SubrogationScenario ss;
    ReserveScenario reserve;
    ActivityScenario act;
    NegotiationScenario negotiation;
    CheckScenario check;
    ServiceScenario cs;
    PolicyRewriteScenario prs;


    public CommonSteps() throws Exception {
        m = new CreateClaim();
        cc = new VerifyUserScenario();
        role=new VerifyRoleScenario();
        group=new VerifyGroupScenario();
        ss = new SubrogationScenario();
        act=new ActivityScenario();
        reserve = new ReserveScenario();
        negotiation = new NegotiationScenario();
        cs = new ServiceScenario();
        check = new CheckScenario();
        prs = new PolicyRewriteScenario();
    }

    Login login = new Login();
    // Cucumber step to open desired URL and login as specified user
    @Given("User logs into {string} application")
    public void userIsOnLoginScreen(String application) {

        // Run generic login method
        login.genericLogin(application);

    }

    // Cucumber step to generate the dynamic testdata
    @When("scenario name {string} and excelPath {string} to generate dynamic testdata for {string}")
    public void scenarioNameAndExcelPathToGenerateDynamicTestdataFor(String scenarioName, String path, String appName) throws IOException {
        Allure.step("Generating the testdata for the specified scenario");
        ExcelData.getRequiredTestData(scenarioName,path);
        Allure.step("Testdata is generated successfully");
    }
    @Then("user should be able to verify the user details with data Provided")
    public void verifyUser() throws IOException, ParseException {
        cc.verifyUser();
    }
    @Then("user was validated successfully")
    public void validateUser() throws IOException, ParseException {
        System.out.println("User is validated Successfully");
    }
    @Then("group was validated successfully")
    public void validateGroup() throws IOException, ParseException {
        System.out.println("Group is validated Successfully");
    }
    @Then("user should be able to verify the group details with data Provided")
    public void verifyGroup() throws IOException, ParseException {
        group.verifyGroup();
    }
    @Then("user should be able to verify the role details with data Provided")
    public void verifyRole() throws IOException, ParseException {
        role.verifyRole();
    }
    @Then("role was validated successfully")
    public void validateRole() throws IOException, ParseException {
        System.out.println("Role is validated Successfully");
    }
    @Then("user opens the subrogation with subrogationStatus,outcome and Subrogation should be Validated successfully")
    public void openSubrogationAndValidateStatus() throws IOException, ParseException {
        ss.openSubrogation();
    }
    @Then("user closes the subrogation with subrogationStatus,outcome and Subrogation should be Validated successfully")
    public void closeSubrogationAndValidateStatus() throws IOException, ParseException {
        ss.closeSubrogation();
    }
    @Then("user create reserve and validate reserve is created successfully")
    public void createNewReserve() throws Exception {
        reserve.createReserve();
    }

    @Then("user clicks on action menu to create a new activity")
    public void createNewActivity() throws IOException, ParseException {
        act.createActivity();
    }
    @Then("user should be able to search created activity")
    public void searchCreatedActivity() throws IOException, ParseException {
        act.searchActivity();
    }
    @Then("user should be able to add a new Negotiation")
    public void addNegotiation() throws IOException, ParseException {
        negotiation.addNegotiation();
    }

    @Then("user should be able to edit a negotiation")
    public void editNegotiation() throws IOException, ParseException {
        negotiation.editNegotiation();
    }
    @Then("user should be able to delete a negotiation")
    public void deleteNegotiation() throws IOException, ParseException {
        negotiation.deleteNegotiation();
    }

    @Then("user create check and validate check is created successfully")
    public void createNewCheck() throws Exception {
        check.createCheck();
        check.validateCheckDetails();
    }

    @Then("User rewrites an existing policy with the type rewrite new term")
    public void rewriteNewTerm() throws Exception {
        prs.policyRewriteAndVerify("New Term");
    }

    @Then("User rewrites an existing policy with the type rewrite remainder of term")
    public void rewriteRemainderOfTerm() throws Exception {
        prs.policyRewriteAndVerify("Remainder Of Term");
    }

    @Then("User rewrites an existing policy with the type rewrite full term")
    public void rewriteFullTerm() throws Exception {
        prs.policyRewriteAndVerify("Full Term");
    }

    @Then("User rewrites an existing policy to new account")
    public void rewriteNewAccount() throws Exception {
        prs.policyRewriteAndVerify("New Account");
    }
}