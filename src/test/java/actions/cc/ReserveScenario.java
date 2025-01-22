package actions.cc;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cc.Reserve;
import pages.cc.VerifyUser;
import utilities.common.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.Duration;
import java.util.Map;


import static org.apache.commons.io.FileUtils.readFileToString;
import static utilities.common.DataDrivenMethods.loadMultipleJson;

public class ReserveScenario extends Driver {

    public utilities.common.DataDrivenMethods dataDrivenMethods = new utilities.common.DataDrivenMethods();
    private final Reserve reserve = new Reserve();
    public Map<String, String> createReserve = loadMultipleJson(readFileToString(new File("src/test/resources/json/cc/Reserve.json"), StandardCharsets.UTF_8));

    String Actualkey;
    private WebDriver driver;

    public ReserveScenario() throws Exception {
    }
    @Step("user create reserve and validate reserve is displayed under transaction screen")
    public void createReserve() throws Exception {
        for (String key : createReserve.keySet()) {
            Actualkey = key;
            System.out.println("entered for key " + Actualkey + " printing get locator " + reserve.getLocator(key) + " Printing reserve key " + createReserve.get(Actualkey) + " printing global data " + globalData.get(key));
            dataDrivenMethods.getAllMethodsToPerformRequiredActions(reserve.getLocator(key), createReserve.get(Actualkey), globalData.get(key));
        }
    }
}
