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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class Payment_Suspense extends utilities.common.Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.Payment_Suspense paysusp = new pages.bc.Payment_Suspense();
    public Map<String, String> paysusp_suspenseJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/Payment_Suspense.json"), StandardCharsets.UTF_8));

    String Actualkey;
    private WebDriver driver;
    private WebDriverWait wait;

    public Payment_Suspense() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("User make a payment suspense")
    public void createPaymentSuspense() throws IOException, ParseException {
        for (String key : paysusp_suspenseJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " +key +" || " + paysusp.getLocator(key) + " || " + paysusp_suspenseJson.get(key) + " || " + globalData.get(key));
            Actualkey=key;
            if(key.contains(".")){
                String keysplitted[]=key.split("\\.");
                key=keysplitted[1];
            }

            if (key.equals("Desktop") || key.equals("SuspensePaymentTab") || key.equals("PolicyFilter") || key.equals("PolicyFilter2") || key.equals("Payment Date") || key.equals("Amount")){
                continue;
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + paysusp.getLocator(key) + "Printing Payment_SuspenseJson key ：" + paysusp_suspenseJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(paysusp.getLocator(key), paysusp_suspenseJson.get(Actualkey), globalData.get(key));
        }

    }

    @Step("Validate the payment suspense created successfully")
    public void validatePaymentSuspense() throws IOException, ParseException {

        String ExpectedDueDate;
        String ActualDueDate;
        String ExpectedAmount;
        String ActualAmount;
        String currentDateWebDisplay;

        for (String key : paysusp_suspenseJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + paysusp.getLocator(key) + " || " + paysusp_suspenseJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (!key.equals("Desktop") && !key.equals("SuspensePaymentTab") && !key.equals("PolicyFilter") && !key.equals("PolicyFilter2") && !key.equals("Payment Date") && !key.equals("Amount")) {
                continue;
            }

            //Check Amount in table
            if (key.equals("Amount")) {
                //Get Subject value from Excel
                ExpectedAmount = globalData.get(key);
                WebElement elementFromUI = driver.findElement(By.xpath("//div[text()='Suspense Payments']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[9]//div[text()]"));
                ActualAmount = elementFromUI.getText();
                System.out.println("ActualAmount value is "+ ActualAmount);
                Assert.assertTrue(ActualAmount.equalsIgnoreCase(ExpectedAmount));
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + paysusp.getLocator(key) + "Printing Payment_SuspenseJson key ：" + paysusp_suspenseJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(paysusp.getLocator(key), paysusp_suspenseJson.get(Actualkey), globalData.get(key));
        }

        //Check Payment Date
        currentDateWebDisplay = dataDrivenMethods.gettingText("//*[@id=\"DesktopGroup-CurrentDateInfoBar-CurrentDate\"]/div[2]");
        System.out.println("Current Date Before Recapture: " + currentDateWebDisplay);

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate date = LocalDate.parse(currentDateWebDisplay, inputFormatter);
        ExpectedDueDate = date.format(outputFormatter);
        System.out.println("Current Date in Charges Date Column Format: " + ExpectedDueDate);//Get Subject value from Excel

        WebElement elementFromUI1 = driver.findElement(By.xpath("//div[text()='Suspense Payments']/following::table[1]//tr[not(contains(@class,'gw-header'))][1]/td[2]//div[text()]"));
        ActualDueDate = elementFromUI1.getText();
        System.out.println("ActualDueDate value is "+ ActualDueDate);

        Assert.assertEquals(ExpectedDueDate, ActualDueDate);

    }

}
