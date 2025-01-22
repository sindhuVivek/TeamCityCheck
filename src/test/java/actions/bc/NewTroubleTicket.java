package actions.bc;

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
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class NewTroubleTicket extends utilities.common.Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.NewTroubleTicket troubleticket = new pages.bc.NewTroubleTicket();
    public Map<String, String> troubleticketJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/NewTroubleTicket.json"), StandardCharsets.UTF_8));

    String Actualkey;
    Integer TroubleTicketCountBefore;
    Integer TroubleTicketCountAfter;

    private final WebDriver driver;

    private void waitPageLoading() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
    }

    public NewTroubleTicket() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
    }

    @Step("User get the count of existing Trouble Tickets")
    public void getTroubleTicketCount() throws IOException, ParseException, InterruptedException {
        for (String key : troubleticketJson.keySet()) {
  //        WebElement listViewCount;
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + troubleticket.getLocator(key) + " || " + troubleticketJson.get(key) + " || " + globalData.get(key));
              Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (!Actualkey.equals("GotoTroubleTicketScreen.TroubleTicketScreen")) {
                continue;
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + troubleticket.getLocator(key) + "Printing troubleticketJson key ：" + troubleticketJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(troubleticket.getLocator(key), troubleticketJson.get(Actualkey), globalData.get(key));

            if (key.equals("TroubleTicketScreen")) {
                Thread.sleep(10000);
                List<WebElement> LastButton = driver.findElements(By.id("AccountDetailTroubleTickets-AccountDetailTroubleTicketsScreen-TroubleTicketsLV-_ListPaging-last")); // Use the appropriate id for the last button
                if (LastButton.size() > 0) {
                    LastButton.get(0).click();
                    Thread.sleep(5000);
                    WebElement table = driver.findElement(By.id("AccountDetailTroubleTickets-AccountDetailTroubleTicketsScreen-TroubleTicketsLV"));
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    TroubleTicketCountBefore = rows.size() - 1;
                    System.out.println("(Before trouble ticket created) Total number of rows: " + TroubleTicketCountBefore);
                } else {
                    WebElement table = driver.findElement(By.id("AccountDetailTroubleTickets-AccountDetailTroubleTicketsScreen-TroubleTicketsLV"));
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    TroubleTicketCountBefore = rows.size() - 1;
                    System.out.println("(Before trouble ticket created) Total number of rows: " + TroubleTicketCountBefore);
                }
            }
        }
    }

    @Step("User creates a new trouble ticket")
    public void createTroubleTicket() throws IOException, ParseException, InterruptedException {
        for (String key : troubleticketJson.keySet()) {
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + troubleticket.getLocator(key) + " || " + troubleticketJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            if (Actualkey.equals("GotoTroubleTicketScreen.TroubleTicketScreen")) {
                continue;
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + troubleticket.getLocator(key) + "Printing troubleticketJson key ：" + troubleticketJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(troubleticket.getLocator(key), troubleticketJson.get(Actualkey), globalData.get(key));

        }
    }

    @Step("the trouble ticket is created successfully")
    public void validateTroubleTicket() throws IOException, ParseException, InterruptedException {
        for (String key : troubleticketJson.keySet()) {

            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + troubleticket.getLocator(key) + " || " + troubleticketJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {
                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }


            if (!Actualkey.equals("GotoTroubleTicketScreen.TroubleTicketScreen")) {
                continue;
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + troubleticket.getLocator(key) + "Printing troubleticketJson key ：" + troubleticketJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(troubleticket.getLocator(key), troubleticketJson.get(Actualkey), globalData.get(key));

            if (key.equals("TroubleTicketScreen")) {
                Thread.sleep(10000);
                List<WebElement> LastButton = driver.findElements(By.id("AccountDetailTroubleTickets-AccountDetailTroubleTicketsScreen-TroubleTicketsLV-_ListPaging-last")); // Use the appropriate id for the last button
                if (LastButton.size() > 0) {
                    LastButton.get(0).click();
                    Thread.sleep(5000);
                    WebElement table = driver.findElement(By.id("AccountDetailTroubleTickets-AccountDetailTroubleTicketsScreen-TroubleTicketsLV"));
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    TroubleTicketCountAfter = rows.size() - 1;
                    System.out.println("(After trouble ticket created) Total number of rows: " + TroubleTicketCountAfter);
                } else {
                    WebElement table = driver.findElement(By.id("AccountDetailTroubleTickets-AccountDetailTroubleTicketsScreen-TroubleTicketsLV"));
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
                    TroubleTicketCountAfter = rows.size() - 1;
                    System.out.println("(After trouble ticket created) Total number of rows: " + TroubleTicketCountAfter);
                }
            }
            //validate trouble ticket created successfully
            int result = TroubleTicketCountAfter - TroubleTicketCountBefore;
            if (result == 1) {
                Assert.assertEquals(result, 1);
                System.out.println("The new trouble ticket creates successfully");
            } else {
                Assert.assertEquals(result, -1);
                System.out.println("The new trouble ticket doesn't create successfully");
            }

        }
    }
}




