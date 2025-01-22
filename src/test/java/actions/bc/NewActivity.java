package actions.bc;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class NewActivity extends Driver {
    public DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final pages.bc.NewActivity activity = new pages.bc.NewActivity();
    public Map<String, String> activityJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/Activity.json"), StandardCharsets.UTF_8));

    String Actualkey;
    String totalPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public NewActivity() throws IOException, ParseException {
        this.driver = utilities.common.Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    @Step("Create new Activity using the required Test Data")
    public void createActivity() throws IOException, ParseException {
        for (String key : activityJson.keySet()) {
            WebElement listViewCount;
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + activity.getLocator(key) + " || " + activityJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + activity.getLocator(key) + "Printing activityjson key ：" + activityJson.get(Actualkey) + "printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(activity.getLocator(key), activityJson.get(Actualkey), globalData.get(key));

            if (key.equals("OpenedAsc")) {
                listViewCount = driver.findElement(By.xpath("//div[@class=\"gw--paging-info\"]"));
                String pagelist = listViewCount.getText();//(16 - 30 of 272)
                int lastSpaceIndex = pagelist.lastIndexOf(' ');
                totalPage = pagelist.substring(lastSpaceIndex + 1).replace(")", "").trim();
                System.out.println("ActivityCount Before Creating New Activity =: " + totalPage);

            }

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String DueDate = currentDateTime.format(formatter);
            String EscaDate = currentDateTime.plusDays(5).format(formatter);
            System.out.println("DueDate is : " + DueDate);

            if (key.equals("Priority")) {
                dataDrivenMethods.setValueForFieldWithInput("Due Date", DueDate);
                dataDrivenMethods.setValueForFieldWithInput("Escalation Date", EscaDate);
            }

        }
    }

    @Step("Create new Activity using the required Test Data")
    public void validatecreatedActivity() throws IOException, ParseException {
        for (String key : activityJson.keySet()) {
            WebElement listViewCount;
            String subjectFromFile;
            String subjectFromUI;
            Allure.step("Action performed on UI for key: {} --- {} --- {} --- {}" + " || " + key + " || " + activity.getLocator(key) + " || " + activityJson.get(key) + " || " + globalData.get(key));
            Actualkey = key;
            if (key.contains(".")) {

                String keysplitted[] = key.split("\\.");
                key = keysplitted[1];
            }

            System.out.println("entered for key ：" + Actualkey + "printing get locator ：" + activity.getLocator(key) + "Printing activityjson key ：" + activityJson.get(Actualkey) + "printing global data " + globalData.get(key));

            //Check total number
            if (key.equals("OpenedDesc")) {
                listViewCount = driver.findElement(By.xpath("//div[@class=\"gw--paging-info\"]"));
                String pagelist = listViewCount.getText();//(16 - 30 of 272)
                int lastSpaceIndex = pagelist.lastIndexOf(' ');
                String totalPageAfter = pagelist.substring(lastSpaceIndex + 1).replace(")", "").trim();
                Assert.assertEquals(Integer.parseInt(totalPageAfter),Integer.parseInt(totalPage) + 1);
                System.out.println("ActivityCount After Creating New Activity =: " + totalPageAfter);
            }

            //Check subject from Page
            if (key.equals("SubjectLine")) {
                //Get Subject value from Excel
                subjectFromFile = globalData.get(key);
                WebElement elementFromUI = driver.findElement(By.xpath("//div[text()='Subject']/following-sibling::div//div[@class='gw-value-readonly-wrapper']"));
                subjectFromUI = elementFromUI.getText();
                System.out.println("subjectFromUI value is "+ subjectFromUI);
                System.out.println("subjectFromFile value is "+ subjectFromFile);
                Assert.assertTrue(subjectFromFile.equalsIgnoreCase(subjectFromUI));
            }


        }
    }
}
