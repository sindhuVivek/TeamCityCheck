package actions.bc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class NewPayment_WithDistribution extends utilities.common.Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.NewPayment_WithDistribution newpayment = new pages.bc.NewPayment_WithDistribution();
    public Map<String, String> newpaymentJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/NewPayment_WithDistribution.json"), StandardCharsets.UTF_8));

    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public NewPayment_WithDistribution() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }


    @Step("create new payment with distribution using the required Test Data")
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
                    Thread.sleep(5000);
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

            if (key.equals("Execute")) {
                try {
                    WebElement ExecuteButton = driver.findElement(By.id("NewDirectBillPayment-EditDBPaymentScreen-Update")); // Use the appropriate id for the Execute button
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(newpayment.getLocator(key), newpaymentJson.get(Actualkey), globalData.get(key));
                } catch (NoSuchElementException e) {
                    WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"NewDirectBillPayment-EditDBPaymentScreen-PaymentDetailsDV-UnappliedFunds\"]/div/div/select")); // Use the Xpath for the Unapplied Fund drop-down list
                    Select dropdown = new Select(dropdownElement);
                    dropdown.selectByIndex(1);
                    Thread.sleep(5000);
                    dataDrivenMethods.getAllMethodsToPerformRequiredActions(newpayment.getLocator(key), newpaymentJson.get(Actualkey), globalData.get(key));
                }
                continue;
            }

            if (!key.equals("UpdatedPayments")) {
                System.out.println("entered for key " + Actualkey + "printing get locator " + newpayment.getLocator(key) + "Printing newpaymentJson key " + newpaymentJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(newpayment.getLocator(key), newpaymentJson.get(Actualkey), globalData.get(key));
            } else {
                System.out.println("entered for key " + Actualkey + "printing get locator " + newpayment.getLocator(key) + "Printing newpaymentJson key " + newpaymentJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(newpayment.getLocator(key), newpaymentJson.get(Actualkey), globalData.get(key));
                List<WebElement> LastButton = driver.findElements(By.id("AccountPayments-AccountDetailPaymentsScreen-DirectBillPaymentsListDetail-AccountDBPaymentsLV-_ListPaging-last")); // Use the appropriate id for the last button
                if (LastButton.size() > 0) {
                    LastButton.get(0).click();
                    Thread.sleep(5000);
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

