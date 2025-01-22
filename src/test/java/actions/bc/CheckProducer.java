package actions.bc;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.bc.SearchProducer;
import utilities.common.DataDrivenMethods;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class CheckProducer extends Driver {
    private final SearchProducer searchProducer = new SearchProducer();

    public Map<String, String> searchProducerJson = loadMultipleJson(readFileToString(new File("src/test/resources/json/bc/CheckProducer.json"), StandardCharsets.UTF_8));

    public DataDrivenMethods dataDrivenMethods = new DataDrivenMethods();

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckProducer() throws IOException, ParseException {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    private void waitPageLoading() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
    }

    @Step("User searches for producer")
    public void searchProducers() {
        for (String key : searchProducerJson.keySet()) {
            String rawKey = key;

            if (key.contains(".")) {
                String[] split = key.split("\\.");
                key = split[1];
            }

            if ((key.equals("Producer Code") && globalData.get("Producer Code") == null) || (key.equals("Producer Name") && globalData.get("Producer Name") == null)) {
                continue;
            }

            System.out.println("entered for key " + rawKey + ", printing get locator" + searchProducer.getLocator(key) + ", Printing searchProducerJson key " + searchProducerJson.get(rawKey) + ", printing global data " + globalData.get(key));

            dataDrivenMethods.getAllMethodsToPerformRequiredActions(searchProducer.getLocator(key), searchProducerJson.get(rawKey), globalData.get(key));

            if (key.equals("Search")) {
                String xpath = "//table/descendant::*[text()='" + globalData.get("Name") + "']";

                System.out.println("xpath " + xpath);

                WebElement button = driver.findElement(By.xpath(xpath));
                button.click();
                waitPageLoading();
            }
        }
    }

    @Step("producer is retrived and validated successfully")
    public void verifyProduerName() {
        waitPageLoading();

        WebElement element = driver.findElement(searchProducer.Summary_ProducerName);
        String producerName = element.getText();

        Assert.assertEquals(producerName, globalData.get("Name"));

        System.out.println("Producer Name is displayed as : " + producerName);

        Allure.step("Producer Name is displayed as : " + producerName);
    }
}
