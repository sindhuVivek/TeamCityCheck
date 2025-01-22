package actions.bc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class ReversePayment extends Driver {
    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    public Map<String, String> reversePaymentJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/ReversePayment.json"), StandardCharsets.UTF_8));
    public final pages.bc.ReversePayment  reversePayLocator = new pages.bc.ReversePayment();
    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public ReversePayment() throws IOException, ParseException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create payment reverse using the required Test Data")
    public void createReversalPayment() throws IOException, ParseException, InterruptedException {
        for (String key : reversePaymentJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + reversePayLocator.getLocator(key) + " || " + reversePaymentJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println("entered for key " + Actualkey + "printing get locator " + reversePayLocator.getLocator(key) + "Printing accountJson key " + reversePaymentJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(reversePayLocator.getLocator(key), reversePaymentJson.get(Actualkey), globalData.get(key));

            if(key.equals("Payments")){
                List<WebElement> LastButton = driver.findElements(By.id("AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV-_ListPaging-last")); // Use the appropriate id for the last button
                if (!LastButton.isEmpty()) {
                    LastButton.get(0).click();
                    Thread.sleep(10000);
                } else {
                    System.out.println("No paging displayed!!");
                }
            }

        }
    }
    @Step("Validate payment reverse successfully")
    public void validationReversePayment() throws  IOException, ParseException {
        WebElement lastItemActionButton = driver.findElement(By.xpath("(//*[contains(@id, '-ActionButton')]//*[@role='button'])[last()]"));
        String actionText = lastItemActionButton.getText();
        Assert.assertTrue(actionText.equals("Reversed"));
    }
}
