package actions.bc;
import io.qameta.allure.Allure;
import pages.bc.Search;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class SearchAccountPolicy extends Driver {
    String Actualkey;
    private WebDriver driver;
    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();
    private final Search searchAccountPolicy = new Search();
    public Map<String, String> searchAccountPolicyjson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/Search.json"), StandardCharsets.UTF_8));

    public SearchAccountPolicy() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("search policy using the required Test Data")
    public void searchPolicy() throws Exception {
        for (String key : searchAccountPolicyjson.keySet()) {
            Actualkey = key;
            if (key.contains(".")){
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];

            }

            if (Actualkey.equals("SearchAccount.Account") || key.equals("Account #")||Actualkey.equals("SearchAccount.SearchButton")||key.equals("SearchResultAccount")){
                continue;
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + searchAccountPolicy.getLocator(key) + "Printing activityjson key ：" + searchAccountPolicyjson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(searchAccountPolicy.getLocator(key), searchAccountPolicyjson.get(Actualkey), globalData.get(key));
        }
    }

    public void verifySearchedPolicy() throws Exception {
        WebElement policies_PolicyInfobar_PolicyTag = driver.findElement(By.xpath("//*[@id='PolicyGroup-PolicyInfoBar-PolicyNumber']/div[1]"));
        WebElement policies_PolicyInfobar_PolicyNumber = driver.findElement(By.xpath("//*[@id='PolicyGroup-PolicyInfoBar-PolicyNumber']/div[2]"));
        String result = policies_PolicyInfobar_PolicyTag.getText();
        String policyNumber = policies_PolicyInfobar_PolicyNumber.getText();
        if (!result.equals("Policy#")) {
            System.out.println("Policy is not searched out, result is "+ result);
        }
        Assert.assertTrue(result.equals("Policy#"));
        System.out.println("Policy Number is " + policyNumber);
    }

    @Step("search account using the required Test Data")
    public void searchAccount() throws IOException, ParseException {
        WebElement AccountSummary;
        for (String key : searchAccountPolicyjson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + searchAccountPolicy.getLocator(key) + " || " + searchAccountPolicyjson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }
            if (Actualkey.equals("SearchPolicy.SearchButton") || key.equals("Policy") || key.equals("Policy #") || key.equals("SearchResultPolicy")) {
                continue;
            }

            System.out.println("entered for key " + Actualkey + "printing get locator " + searchAccountPolicy.getLocator(key) + "Printing accountJson key " + searchAccountPolicyjson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(searchAccountPolicy.getLocator(key), searchAccountPolicyjson.get(Actualkey), globalData.get(key));

        }
        // verify account search successfully
        AccountSummary = driver.findElement(By.xpath("//*[@id=\"AccountSummary-AccountSummaryScreen-ttlBar\"]"));
        System.out.println("AccountSummaryText:" + AccountSummary.getText());
        Assert.assertEquals(AccountSummary.getText(), "Account Summary");
    }
}