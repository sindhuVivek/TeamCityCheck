package stepdefinitions.steps.cc;

import actions.cc.SearchPolicy;
import actions.cc.ServiceScenario;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import utilities.common.Config;

import java.io.IOException;


public class ServiceStep {

    ServiceScenario cs;
    Config co = new Config();
    public ServiceStep() throws IOException, ParseException {
        cs = new ServiceScenario();
    }

    @Then("user create a new service from action menu")
    public void createNewService() throws IOException, ParseException {
        cs.createService();
    }

    @Then("User should be able to assign a service")
    public void assignAService() throws IOException, ParseException {
        cs.assignService();
    }

    @Then("User should be able to remove a service")
    public void removeAService() throws IOException, ParseException {
        cs.removeService();
    }

    @Then("user should be able to search the service")
    public void userShouldBeAbleToSearchService() throws IOException, ParseException {
        cs.searchService();
    }
}



