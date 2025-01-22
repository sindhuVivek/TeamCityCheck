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

public class ReversalNegativeWriteOff extends utilities.common.Driver {
    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.ReversalNegativeWriteOff RevNegWriteOff = new pages.bc.ReversalNegativeWriteOff();
    public Map<String, String> RevNegWriteOffJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/RevNegWriteOff.json"), StandardCharsets.UTF_8));

    String Actualkey;
    String totalPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public ReversalNegativeWriteOff() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create new Reversal Negative Write Off using the required Test Data")
    public void initialReversalNegativeWriteOff() throws IOException, ParseException {
        for (String key : RevNegWriteOffJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + RevNegWriteOff.getLocator(key) + " || " + RevNegWriteOffJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }


            System.out.println("entered for key " + Actualkey + "printing get locator " + RevNegWriteOff.getLocator(key) + "Printing accountJson key " + RevNegWriteOffJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(RevNegWriteOff.getLocator(key), RevNegWriteOffJson.get(Actualkey), globalData.get(key));


        }
    }

    @Step("the Negative Write-Off Reversal transaction is created successfully")
    public void validateReversalNegativeWriteOff() throws IOException, ParseException {
        for (String key : RevNegWriteOffJson.keySet()) {
            String subjectFromFile;
            String subjectFromUI;
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + RevNegWriteOff.getLocator(key) + " || " + RevNegWriteOffJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + RevNegWriteOff.getLocator(key) + "Printing RevNegWriteOffJson key ：" + RevNegWriteOffJson.get(Actualkey) + "printing global data " + globalData.get(key));


            //Check subject from Page
            //Get Subject value from Excel
            if (key.equals("ValidationAmount")) {
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
