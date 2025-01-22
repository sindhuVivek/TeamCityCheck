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

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class WriteOff extends utilities.common.Driver {
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.WriteOff WriteOff = new pages.bc.WriteOff();
    public Map<String, String> WriteOffJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/WriteOff.json"), StandardCharsets.UTF_8));
    String Actualkey;
    String totalPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public WriteOff() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create new Write Off using the required Test Data")
    public void initialWriteOff() throws IOException, ParseException {
        for (String key : WriteOffJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + WriteOff.getLocator(key) + " || " + WriteOffJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (Actualkey.contains("ValidateWriteOff.") ) {
                continue;
            }

            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + WriteOff.getLocator(key) + "Printing accountJson key " + WriteOffJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(WriteOff.getLocator(key), WriteOffJson.get(Actualkey), globalData.get(key));


        }
    }

    @Step("the Write-Off transaction is created successfully")
    public void validateWriteOff() throws IOException, ParseException {
        for (String key : WriteOffJson.keySet()) {
            String subjectFromFile;
            String subjectFromUI;
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + WriteOff.getLocator(key) + " || " + WriteOffJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.equals("Actions") || key.equals("New Transaction") || key.equals("Write-Off") || key.equals("Set Account As Target of Write-Off")|| key.equals("Select 1st policy")|| key.equals("Next")|| key.equals("All")|| key.equals("WriteOffAmount")|| key.equals("Reason")|| key.equals("Next2")|| key.equals("Finish")) {
                continue;
            }
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + WriteOff.getLocator(key) + "Printing WriteOffJson key ：" + WriteOffJson.get(Actualkey) + "printing global data " + globalData.get(key));

            //Check subject from Page
            //Get Subject value from Excel
            if (key.equals("Amount")) {
                subjectFromFile = globalData.get(key);
                WebElement elementFromUI = driver.findElement(By.xpath("//*[@id='AccountDetailTransactions-AccountDetailTransactionsScreen-AccountDetailTransactionsLV-0-Amount']//div[@class='gw-value-readonly-wrapper']"));
                subjectFromUI = elementFromUI.getText();
                System.out.println("AmountFromUI value is " + subjectFromUI);
                System.out.println("AmountFromFile value is " + subjectFromFile);
                Assert.assertTrue(subjectFromFile.equalsIgnoreCase(subjectFromUI));
            }
        }
    }

}
