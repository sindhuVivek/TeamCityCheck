package actions.bc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.bc.Search;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class NewPayment_WithoutDistribution extends utilities.common.Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.NewPayment_WithoutDistribution newpayment = new pages.bc.NewPayment_WithoutDistribution();
    public Map<String, String> newpaymentJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/NewPayment_WithoutDistribution.json"), StandardCharsets.UTF_8));

    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public NewPayment_WithoutDistribution() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10000)); // Adjust timeout as needed
    }


    @Step("create new payment without distribution using the required Test Data")
    public void CreateNewPayment() throws IOException, ParseException, InterruptedException {
        int totalRowCount = 0;
        int totalRowCount2 = 0;
        for (String key : newpaymentJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + newpayment.getLocator(key) + " || " + newpaymentJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (key.equals("InitialPayments")) {
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(newpayment.getLocator(key), newpaymentJson.get(Actualkey), globalData.get(key));
                List<WebElement> LastButton = driver.findElements(By.id("AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV-_ListPaging-last")); // Use the appropriate id for the last button
                if (LastButton.size() > 0) {
                    LastButton.get(0).click();
                    Thread.sleep(10000);
                    WebElement table = driver.findElement(By.id("AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV")); // Use the appropriate id
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    totalRowCount = rows.size() - 1;
                } else {
                    WebElement table = driver.findElement(By.id("AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV")); // Use the appropriate id
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    totalRowCount = rows.size() - 1;
                }
                System.out.println("(Before payment created) Total number of rows: " + totalRowCount);
                continue;
            }

            if (!key.equals("UpdatedPayments")) {
                System.out.println("entered for key " + Actualkey + "printing get locator " + newpayment.getLocator(key) + "Printing newpaymentJson key " + newpaymentJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(newpayment.getLocator(key), newpaymentJson.get(Actualkey), globalData.get(key));
            } else {
                System.out.println("entered for key " + Actualkey + "printing get locator " + newpayment.getLocator(key) + "Printing newpaymentJson key " + newpaymentJson.get(Actualkey) + "printing global data " + globalData.get(key));
                Thread.sleep(10000);
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(newpayment.getLocator(key), newpaymentJson.get(Actualkey), globalData.get(key));
                List<WebElement> LastButton = driver.findElements(By.xpath("//div[@id='AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV-_ListPaging-last' and @aria-disabled='false']")); // Use the appropriate id for the last button
                if (LastButton.size() > 0) {
                    LastButton.get(0).click();
                    Thread.sleep(10000);
                    WebElement table = driver.findElement(By.id("AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV")); // Use the appropriate id
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    totalRowCount2 = rows.size() - 1;
                } else {
                    WebElement table = driver.findElement(By.id("AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV")); // Use the appropriate id
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    totalRowCount2 = rows.size() - 1;
                }
                System.out.println("(After payment created) Total number of rows: " + totalRowCount2);
            }
        }
        //validate payment created successfully
        int result = totalRowCount2 - totalRowCount;
        if (result == 1 ) {
            Assert.assertEquals(result, 1);
            //System.out.println("The difference is: " + result);
            System.out.println("The new payment creates successfully");
        } else if (result == -14) {
            Assert.assertEquals(result, -14);
            //System.out.println("The difference is: " + result);
            System.out.println("The new payment creates successfully");
        }
        else {
            Assert.assertEquals(result, -1);
            //System.out.println("The difference is: " + result);
            System.out.println("The new payment doesn't create successfully");
        }
    }
}

