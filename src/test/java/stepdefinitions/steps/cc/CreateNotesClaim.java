package stepdefinitions.steps.cc;

import actions.cc.CreateNotes;
import io.cucumber.java.en.Then;
import utilities.common.Driver;

import java.io.IOException;
import java.text.ParseException;


public class CreateNotesClaim extends Driver {
    actions.cc.CreateNotes notes;
    {
        try {
            notes = new CreateNotes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Then("user open a claim")
    public void openClaim() throws IOException, ParseException {
        notes.openClaim();
    }
    @Then("user search a Note")
    public void searchNote() throws IOException, ParseException {
        notes.searchNote();
    }
    @Then("user create a Claim Note")
    public void createNote() throws IOException, ParseException {
        notes.createNote();
    }
}
