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
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class PaymentTransfer extends utilities.common.Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.PaymentTransfer paymenttransfer = new pages.bc.PaymentTransfer();
    public Map<String, String> PaymentTransferJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/PaymentTransfer.json"), StandardCharsets.UTF_8));

    String Actualkey;
    String totalPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentTransfer() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20000)); // Adjust timeout as needed
    }

    @Step("User transfer the payment to other account")
    public void tootheraccount() throws IOException, ParseException {
        for (String key : PaymentTransferJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + paymenttransfer.getLocator(key) + " || " + PaymentTransferJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if(key.contains(".")){
                String keysplitted[]=key.split("\\.");
                key=keysplitted[1];
            }

            if(key.contains("Payments Check")) {
                continue;
            }else{
                System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + paymenttransfer.getLocator(key) + "Printing PaymentTransferJson key ：" + PaymentTransferJson.get(Actualkey) + "printing global data " + globalData.get(key));
                dataDrivenMethods.getAllMethodsToPerformRequiredActions(paymenttransfer.getLocator(key), PaymentTransferJson.get(Actualkey), globalData.get(key));
            }
        }
    }

    @Step("Payment should be Transfer to other account successfully")
    public void transfertootheraccountsuccessfully() throws IOException, ParseException, InterruptedException {
        for (String key : PaymentTransferJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + paymenttransfer.getLocator(key) + " || " + PaymentTransferJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + paymenttransfer.getLocator(key) + "Printing RevNegWriteOffJson key ：" + PaymentTransferJson.get(Actualkey) + "printing global data " + globalData.get(key));

            if(key.equals("Payments Check")) {
                Thread.sleep(5000);
                System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + paymenttransfer.getLocator(key) + "Printing PaymentTransferJson key ：" + PaymentTransferJson.get(Actualkey) + "printing global data " + globalData.get(key));
                WebElement elementFromUI = driver.findElement(By.xpath("(//table//tr[last()]//td[1]//div[contains(@class, 'gw-ButtonValueWidget')]//div)[1]"));
                String LastPaymentReceived = elementFromUI.getText();
                Assert.assertEquals(LastPaymentReceived,"Reversed");
            }
        }
    }
}
