package stepdefinitions.steps.cc;
import actions.cc.Evaluation;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import utilities.common.Config;
import java.io.IOException;

public class EvaluationSteps {

    Evaluation m;
    Config co = new Config();

    public EvaluationSteps() throws IOException, ParseException {
        m = new Evaluation();
    }
    @Then("user should be able to add a new evaluation successfully")
    public void addEvaluation() throws IOException, ParseException {
        m.evaluation();
    }
    @Then("user should be able to edit the existing evaluation successfully")
    public void editEvaluation() throws IOException, ParseException {
        m.editEvaluation();
    }
    @Then("user should be able to delete the evaluation successfully")
    public void deleteEvaluation() throws IOException, ParseException {
        m.deleteEvaluation();
    }
}