package stepdefinitions.steps.pc;

import actions.pc.CreateNewAccount_Act;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class CreateAccount {
    CreateNewAccount_Act cna = new CreateNewAccount_Act();

    public CreateAccount() throws IOException, ParseException {
    }

    @Then("account should be created successfully")
    public void createNewAccountCompany() throws IOException, ParseException, InterruptedException {
        cna.CreateNewAccount_Company();
    }

    @Then("account should be created successfully_Person")
    public void createNewAccountPerson() throws IOException, ParseException, InterruptedException {
        cna.CreateNewAccount_Person();
    }
}
