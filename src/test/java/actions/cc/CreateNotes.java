package actions.cc;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utilities.common.Driver;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.*;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class CreateNotes extends Driver {
    private final pages.cc.Notes notes = new pages.cc.Notes();
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    public Map<String, String> openClaim = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/openClaim.json"), StandardCharsets.UTF_8));
    public Map<String, String> searchNote = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/searchNote.json"), StandardCharsets.UTF_8));
    public Map<String, String> createNote = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/createNote.json"), StandardCharsets.UTF_8));

    String Actualkey;
    private WebDriver driver;

    public CreateNotes() throws Exception {
    }

    @Step("Search Existing Claim")
    public void openClaim() throws IOException, ParseException {
        for (String key : openClaim.keySet()) {
            Actualkey = key;
            System.out.println("entered for key " + Actualkey + "printing get locator " + notes.getLocator(key) + "Printing fnoljson key " + openClaim.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(notes.getLocator(key), openClaim.get(Actualkey), globalData.get(key));
        }
    }
    @Step("Search Existing Note")
    public void searchNote() throws IOException, ParseException {
        for (String key : searchNote.keySet()) {
            Actualkey = key;
            System.out.println("entered for key " + Actualkey + "printing get locator " + notes.getLocator(key) + "Printing fnoljson key " + openClaim.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(notes.getLocator(key), searchNote.get(Actualkey), globalData.get(key));
        }
    }
    @Step("Create New Note")
    public void createNote() throws IOException, ParseException {
        for (String key : createNote.keySet()) {
            Actualkey = key;
            System.out.println("entered for key " + Actualkey + "printing get locator " + notes.getLocator(key) + "Printing fnoljson key " + createNote.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(notes.getLocator(key), createNote.get(Actualkey), globalData.get(key));
        }
    }
}
