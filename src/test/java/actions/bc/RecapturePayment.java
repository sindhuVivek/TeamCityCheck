package actions.bc;

import io.cucumber.java.bs.A;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Locale;


import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class RecapturePayment extends utilities.common.Driver{
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.Recapture recapture = new pages.bc.Recapture();
    public Map<String, String> recaptureJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/Recapture.json"), StandardCharsets.UTF_8));

    String Actualkey;
    String dateAfterRecapture;
    String chargeTypeAfterRecapture;
    String amountTypeAfterRecapture;
    String currentDateWebDisplay;
    String expCurrentDateCharges; // Format: "MM-DD-YYYY"
    String chargeType = "Recapture";
    String amountExcelValue = globalData.get("Amount");

    private WebDriver driver;
    private WebDriverWait wait;

    public RecapturePayment() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
    }

    private void waitPageLoading() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
    }

    @Step("User Creates a recapture using the required Test Data")
    public void recaptureCreate() throws IOException, ParseException {
        for (String key : recaptureJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + recapture.getLocator(key) + " || " + recaptureJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;

            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + recapture.getLocator(key) + "Printing recaptureJson key ：" + recaptureJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(recapture.getLocator(key), recaptureJson.get(Actualkey), globalData.get(key));

            if (key.equals("Account")) {
                currentDateWebDisplay = dataDrivenMethods.gettingText("//div[@id='AccountsGroup-CurrentDateInfoBar-CurrentDate']//div[contains(@class, 'gw-infoValue')]");
                System.out.println("Current Date Before Recapture: " + currentDateWebDisplay);

                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

                LocalDate date = LocalDate.parse(currentDateWebDisplay, inputFormatter);
                expCurrentDateCharges = date.format(outputFormatter);
                System.out.println("Current Date in Charges Date Column Format: " + expCurrentDateCharges);
            }

            if (key.equals("Finish")) {
                waitPageLoading();
            }
        }
    }

    @Step("User should be able to create and validates the \"Recapture\"")
    public void validateRecapture() throws IOException, ParseException, java.text.ParseException {

        for (String key : recaptureJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + recapture.getLocator(key) + " || " + recaptureJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;

            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (key.equals("DateSortAsc")) {
                waitPageLoading();
            }

            if (key.equals("DateSortDesc")) {
                waitPageLoading();

                WebElement dateWebElement = driver.findElement(By.xpath("//div[@id='AccountDetailCharges-AccountDetailChargesScreen-AccountDetailChargesListDetailPanel-ChargesLV']//tr[not(contains(@class, 'gw-header-row'))][1]//td//div[@data-gw-getset='date']//div[@class='gw-value-readonly-wrapper']"));
                dateAfterRecapture = dateWebElement.getText();
                System.out.println("Date After Recapture: " + dateAfterRecapture);
                Assert.assertTrue(dateAfterRecapture.equalsIgnoreCase(expCurrentDateCharges));

                WebElement chargeTypeWebElement = driver.findElement(By.xpath("//div[@id='AccountDetailCharges-AccountDetailChargesScreen-AccountDetailChargesListDetailPanel-ChargesLV']//tr[not(contains(@class, 'gw-header-row'))][1]//td//div[contains(@id, 'ChargeType')]//div[@class='gw-value-readonly-wrapper']"));
                chargeTypeAfterRecapture = chargeTypeWebElement.getText();
                System.out.println("Charge Type After Recapture: " + chargeTypeAfterRecapture);
                Assert.assertTrue(chargeTypeAfterRecapture.equals(chargeType));

                WebElement amountWebElement = driver.findElement(By.xpath("//div[@id='AccountDetailCharges-AccountDetailChargesScreen-AccountDetailChargesListDetailPanel-ChargesLV']//tr[not(contains(@class, 'gw-header-row'))][1]//td//div[contains(@id, '-Amount')]//div[@class='gw-value-readonly-wrapper']"));
                amountTypeAfterRecapture = amountWebElement.getText();
                System.out.println("Amount After Recapture: " + amountTypeAfterRecapture + " " + amountTypeAfterRecapture.getClass().getName());
                System.out.println("Amount from excel: " + amountExcelValue + " " + amountExcelValue.getClass().getName());
                double amountExcelValueDouble = Double.parseDouble(amountExcelValue);
                String excelValueInAmountFormat = String.format("$%.2f", amountExcelValueDouble);
                System.out.println("Excel Value in Amount Format: " + excelValueInAmountFormat);
                Assert.assertTrue(excelValueInAmountFormat.equalsIgnoreCase(amountTypeAfterRecapture));
            }
        }
    }
}
