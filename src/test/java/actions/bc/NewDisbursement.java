package actions.bc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;


public class NewDisbursement extends utilities.common.Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.NewDisbursement disbursement = new pages.bc.NewDisbursement();
    public Map<String, String> disbursementJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/Disbursement.json"), StandardCharsets.UTF_8));

    String Actualkey;

    private WebDriver driver;
    private WebDriverWait wait;



    public NewDisbursement() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create new Disbursement using the required Test Data")
    public void createDisbursement() throws IOException, ParseException {

        for (String key : disbursementJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + disbursement.getLocator(key) + " || " + disbursementJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (key.equals("Disbursement #") || key.equals("Disbursement #2") || key.equals("Due Date") || key.equals("Amount In Table") || key.equals("Amount In Table2") || key.equals("Status")){
                continue;
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + disbursement.getLocator(key) + "Printing disbursementJson key ：" + disbursementJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(disbursement.getLocator(key), disbursementJson.get(Actualkey), globalData.get(key));

        }
    }

    @Step("Validate the disbursement")
    public void validateCreatedDisbursement() throws IOException, ParseException {
        for (String key : disbursementJson.keySet()) {

            String ExpectedDueDate;
            String ActualDueDate;
            String ExpectedAmount;
            String ActualAmount;
            String ExpectedStatus;
            String ActualStatus;

            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + disbursement.getLocator(key) + " || " + disbursementJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (!key.equals("Disbursement #") && !key.equals("Disbursement #2") && !key.equals("Due Date") && !key.equals("Amount In Table") && !key.equals("Amount In Table2") && !key.equals("Status")) {
                continue;
            }

            //Check Due Date
            if (key.equals("Due Date")) {
                //Get Subject value from Excel
                ExpectedDueDate = globalData.get(key);
                WebElement elementFromUI = driver.findElement(By.xpath("//div[text()='Due Date']/following-sibling::div//div[text()]"));
                ActualDueDate = elementFromUI.getText();
                System.out.println("ActualDueDate value is "+ ActualDueDate);
                Assert.assertTrue(ActualDueDate.equalsIgnoreCase(ExpectedDueDate));
            }

            //Check Amount in table
            if (key.equals("Amount In Table")) {
                //Get Subject value from Excel
                ExpectedAmount = globalData.get(key);
                WebElement elementFromUI = driver.findElement(By.xpath("//div[text()='Disbursements']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[8]//div[text()]"));
                ActualAmount = elementFromUI.getText();
                System.out.println("ActualAmount value is "+ ActualAmount);
                Assert.assertTrue(ActualAmount.equalsIgnoreCase(ExpectedAmount));
            }

            //Check Status
            if (key.equals("Status")) {
                //Get Subject value from Excel
                ExpectedStatus = globalData.get(key);
                WebElement elementFromUI = driver.findElement(By.xpath("//div[text()='Disbursements']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[6]//div[text()]"));
                ActualStatus = elementFromUI.getText();
                System.out.println("ActualStatus value is "+ ActualStatus);
                Assert.assertTrue(ExpectedStatus.equalsIgnoreCase(ActualStatus));
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + disbursement.getLocator(key) + "Printing disbursementJson key ：" + disbursementJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(disbursement.getLocator(key), disbursementJson.get(Actualkey), globalData.get(key));

        }
    }
}
