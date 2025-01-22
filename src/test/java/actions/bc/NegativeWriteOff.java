package actions.bc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.math.BigDecimal;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class NegativeWriteOff extends Driver {

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final pages.bc.NegativeWriteOff negativewriteoff = new pages.bc.NegativeWriteOff();
    public Map<String, String> negativewriteoffJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/NegativeWrite-Off.json"), StandardCharsets.UTF_8));
    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public NegativeWriteOff() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Get the Negative Amount used for Negative Write-Off transaction from excel")
    //To get the Account Un-applied Amount for scenario pre-condition and final validation
    public BigDecimal getFileAmt() throws IOException, ParseException {
        BigDecimal AmtfromFile;
        for (String key : negativewriteoffJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + negativewriteoff.getLocator(key) + " || " + negativewriteoffJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (key.equals("Amount")) {
                //get the Negative Write-Off amount used in the Excel
                AmtfromFile = new BigDecimal(globalData.get(key));
                return AmtfromFile;
            }
        }
        return BigDecimal.valueOf(0);
    }
    @Step("Create a new negative write-off using the required Test Data")
    public void createNegWriteOff() throws IOException, ParseException {

        WebElement AccountDetails = driver.findElement(By.xpath("//div[@aria-label='Details']"));
        AccountDetails.click();
        WebElement UnappliedAmount = driver.findElement(By.xpath("//div[@id='AccountDetailSummary-AccountDetailSummaryScreen-AccountDetailDV-UnappliedAmount']"));
        BigDecimal AccUnappliedAmt1 = new BigDecimal(UnappliedAmount.getAttribute("data-gw-value"));
        // Verify the amount is qualified to create a Negative Write-Off.
        if (AccUnappliedAmt1.compareTo(BigDecimal.ZERO) > 0) {
            for (String key : negativewriteoffJson.keySet()) {
                Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + negativewriteoff.getLocator(key) + " || " + negativewriteoffJson.get(key) + " || " + globalData.get(key));
                Actualkey = key;
                if (key.contains(".")) {

                    String keysplitted[] = key.split("\\.");
                    key = keysplitted[1];
                }
                if (Actualkey.equals("Unapplied Fund")) {
                    continue;
                }
                System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + negativewriteoff.getLocator(key) + "Printing negativewriteoffJson key ：" + negativewriteoffJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(negativewriteoff.getLocator(key), negativewriteoffJson.get(Actualkey), globalData.get(key));
            }
            //validate the Negative Write-Off is created successfully.
            WebElement UnappliedAmount2 = driver.findElement(By.xpath("//div[@id='AccountDetailSummary-AccountDetailSummaryScreen-AccountDetailDV-UnappliedAmount']"));
            BigDecimal AccUnappliedAmt2 = new BigDecimal(UnappliedAmount2.getAttribute("data-gw-value"));
            //get the Negative Amount from Excel
            BigDecimal fileAmt = getFileAmt();
            BigDecimal expectedAmt = AccUnappliedAmt1.subtract(fileAmt);
            System.out.println("Negative Amount from excel is "+ fileAmt);
            System.out.println("Original Account Un-applied Amount of the Account is "+ AccUnappliedAmt1);
            System.out.println("Current Account Un-applied Amount of the Account is "+ AccUnappliedAmt2);
            Assert.assertEquals(AccUnappliedAmt2,expectedAmt, "Assertion failed: The negative write-off is not created successfully");
            System.out.println("Assertion passed: the Negative Write-Off created successfully");

        }
        else {

            System.out.println("The account does not qualify to create a Negative Write-Off, please use an account which Un-applied Amount is >0");
        }
    }

}
