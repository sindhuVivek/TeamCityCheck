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
import java.util.Map;
import java.util.logging.Logger;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReverseWriteOff extends utilities.common.Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.ReverseWriteOff reverseWriteOff = new pages.bc.ReverseWriteOff();
    public Map<String, String> reverseWriteOffJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/ReverseWriteOff.json"), StandardCharsets.UTF_8));

    String Actualkey;
    String ActualAmount;
    String ReversalAmount;
    String PreviousAmount;


    private WebDriver driver;
    private WebDriverWait wait;

    public ReverseWriteOff() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("User initiates a Reverse Write Off transaction")
    public void createReverseWriteOff() throws IOException, ParseException {

        for (String key : reverseWriteOffJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + reverseWriteOff.getLocator(key) + " || " + reverseWriteOffJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (key.equals("Overview") || key.equals("Actual Amount")){
                continue;
            }

            //Get Reversal Amount in table
            if (key.equals("Reversal Amount")) {
                //Get Subject value from Excel
                WebElement elementFromUI = driver.findElement(By.xpath("//*[@id=\"AccountNewWriteoffReversalWizard-NewWriteoffReversalAccountWriteoffsScreen-NewWriteoffReversalWriteoffsLV-0-Amount\"]/div/div"));
                ReversalAmount = elementFromUI.getText();
                System.out.println("ReversalAmount value is "+ ReversalAmount);
            }


            //Get Previous Amount in chart
            if (key.equals("Previous Amount")) {
                //Get Subject value from Excel
                WebElement elementFromUI = driver.findElement(By.xpath("//*[@id=\"AccountSummary-AccountSummaryScreen-SummaryChartPanelSet-ValueChart\"]/div/div[2]/div[5]/div/div[2]"));
                PreviousAmount = elementFromUI.getText();
                System.out.println("PreviousAmount value is "+ PreviousAmount);
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + reverseWriteOff.getLocator(key) + "Printing reverseWriteOffJson key ：" + reverseWriteOffJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(reverseWriteOff.getLocator(key), reverseWriteOffJson.get(Actualkey), globalData.get(key));

        }
    }
    @Step("Validate the Reverse Write Off created successfully")
    public void validateReverseWriteOff() throws IOException, ParseException {
        for (String key : reverseWriteOffJson.keySet()) {


            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + reverseWriteOff.getLocator(key) + " || " + reverseWriteOffJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (!key.equals("Overview") && !key.equals("Actual Amount")) {
                continue;
            }

            if (key.equals("Actual Amount")) {
                WebElement elementFromUI = driver.findElement(By.xpath("//*[@id=\"AccountSummary-AccountSummaryScreen-SummaryChartPanelSet-ValueChart\"]/div/div[2]/div[5]/div/div[2]"));
                ActualAmount = elementFromUI.getText().replaceAll("[^0-9.-]", "").trim(); // Remove non-numeric characters except for decimal points and minus sign
                System.out.println("ActualAmount value is " + ActualAmount);

                // Assuming PreviousAmount and ReversalAmount are already defined and hold values with unwanted characters
                double previousAmount = Double.parseDouble(PreviousAmount.replaceAll("[^0-9.-]", "").trim()); // Remove non-numeric characters and convert to double
                double reversalAmount = Double.parseDouble(ReversalAmount.replaceAll("[^0-9.-]", "").trim()); // Remove non-numeric characters and convert to double
                double expectedActualAmount = previousAmount - reversalAmount;

                System.out.println("Expected ActualAmount value is " + expectedActualAmount);

                // Converting ActualAmount from string to double for comparison
                double actualAmount = Double.parseDouble(ActualAmount);
            }

                System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + reverseWriteOff.getLocator(key) + "Printing reverseWriteOffJson key ：" + reverseWriteOffJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(reverseWriteOff.getLocator(key), reverseWriteOffJson.get(Actualkey), globalData.get(key));

        }

    }
}