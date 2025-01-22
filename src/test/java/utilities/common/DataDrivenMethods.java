package utilities.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class DataDrivenMethods {
    private WebDriver driver;
    private WebDriverWait wait;

    public DataDrivenMethods() {
        this.driver = Driver.getThreadDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    public static Map<String, String> loadJson(String path) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Map<String, String> map = new LinkedHashMap<>();

        try {
            // Parse JSON file into a LinkedHashMap
            map = mapper.readValue(new File(path), new TypeReference<LinkedHashMap<String, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.forEach((key, value) -> System.out.println(key + ": " + value));


        return map;
    }

    public static Map<String, String> jsonObjectToMap(JSONObject jsonObject) {
        Map<String, String> map = new LinkedHashMap<>();
        Iterator<String> keys = jsonObject.keys();

        while (((Iterator<?>) keys).hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);
            map.put(key, value.toString());
        }

        return map;
    }
    public static void readAndStoreJson(JsonNode node, String prefix, Map<String, String> resultMap){
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String fieldName = prefix.isEmpty() ? field.getKey() : prefix + "." + field.getKey();
                readAndStoreJson(field.getValue(), fieldName, resultMap);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                readAndStoreJson(node.get(i), prefix + "[" + i + "]", resultMap);
            }
        } else {
            resultMap.put(prefix, node.asText());
        }


    }

    public static Map<String, String> loadMultipleJson(String jsonString) throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);
      // System.out.println("printing json string"+jsonString);
        Map<String, String> resultMap = new LinkedHashMap<>();
        readAndStoreJson(rootNode, "", resultMap);
       // resultMap.forEach((key, value) -> System.out.println(key + " : " + value));
        return resultMap;
    }


    public void clickAnyButton(String labelName) {
       // waitPageLoading();
        String xpath = getXpath("button", labelName);
        try {
            WebElement button = driver.findElement(By.xpath(xpath));
            button.click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        catch (StaleElementReferenceException | ElementClickInterceptedException e){
            WebElement button = driver.findElement(By.xpath(xpath));
            button.click();
        }try {
            handleAlert();
            System.out.println("Alert appeared and handled");
        } catch (Exception e) {
            System.out.println("Alert didn't appear");
        }

        waitPageLoading();

    }

    public void setValueForFieldWithInput(String fieldName, String value) {
        waitPageLoading();
        if (value != null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String xpath = getXpath("input", fieldName);
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            inputField.clear();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            inputField.sendKeys(value);
        }
    }

    public void setValueForFieldWithCSSInput(String fieldName, String value) {
        waitPageLoading();
        if(value!=null){
        WebElement inputField = driver.findElement(By.cssSelector(fieldName));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", inputField);
        inputField.click(); // Ensure element is clickable before typing
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value='" + value + "';", inputField);}
    }

    public void clickBasedOnInputValue(String fieldName, String value) {
        waitPageLoading();
        String xpath = getXpath("clickValue", fieldName, value);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }

    public void setValueForFieldWithTextArea(String fieldName, String value) {
        waitPageLoading();
        if (value != null) {
            String xpath = getXpath("textarea", fieldName);
            WebElement textArea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            textArea.click(); // Ensure element is clickable before typing
            textArea.clear(); // Clear existing text
            textArea.sendKeys(value);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    public void setValueForSpecificFieldWithInput(String locator, String value) {
        waitPageLoading();
        if (value != null) {
            // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            // wait.until(ExpectedConditions.visibilityOf(element));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            try {
                element.click(); // Ensure element is clickable before typing
                element.clear(); // Clear existing text
                Thread.sleep(1000);
            } catch (StaleElementReferenceException e) {
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
                element.click(); // Ensure element is clickable before typing
                element.clear();
            }
            catch(InterruptedException e)
            {

            }
            element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            element.sendKeys(value);
        }
    }

    public void deleteAndSetValueForSpecificFieldWithInput(String locator, String value) {
        waitPageLoading();
        if (value != null) {
            WebElement element = driver.findElement(By.xpath(locator));
            element.click();  // Ensure element is clickable before typing
            String s = Keys.chord(Keys.CONTROL, "A");
            element.sendKeys(s); // Select existing text
            String s1 = Keys.chord(Keys.DELETE);
            element.sendKeys(s1); // Delete existing text
            element.sendKeys(value);
        }
    }

    public void assertValueBasedOnText(String locator, String expectedValue) {
        waitPageLoading();
        WebElement element = driver.findElement(By.xpath(locator));
        String actualValue = element.getText();
        if (!actualValue.equals(expectedValue)) {
            throw new AssertionError("Value is not matching, expected value - " + expectedValue + " but actual value is - " + actualValue);
        }
    }

    public void selectOptionsForFieldWithSelect(String fieldName, String text) {
        waitPageLoading();
        try {
            if (text != null) {
                String xpath = getXpath("select", fieldName);
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                Select option = new Select(dropdown);
                option.selectByVisibleText(text);
                waitForPageLoadBarToDisappear();
                //Thread.sleep(1000);
//                dropdown.sendKeys(Keys.TAB);
//                dropdown.sendKeys(Keys.ENTER);
            }
        } catch (StaleElementReferenceException e) {
            String xpath = getXpath("select", fieldName);
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            Select option = new Select(dropdown);
            option.selectByVisibleText(text);
            //waitForPageLoadBarToDisappear();
//            dropdown.sendKeys(Keys.TAB);
//            dropdown.sendKeys(Keys.ENTER);

        }
    }

    public void selectOptionsForSpecificFieldWithSelect(String locator, String text) {
        waitPageLoading();
        if (text != null) {
            WebElement dropdown = driver.findElement(By.xpath(locator));
            dropdown.click(); // Ensure dropdown is clickable before interacting
            List<WebElement> options = dropdown.findElements(By.tagName("option"));
            boolean optionFound = false;
            for (WebElement option : options) {
                System.out.println("Printing options" + option.getText());
                if (option.getText().equals(text)) {
                    option.click();
                    optionFound = true;
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!optionFound) {
                throw new NoSuchElementException("Option with value '" + text + "' not found in dropdown.");
            }
        }
    }

    public void clickAnyMenuItemLeftPane(String label) {
        waitForPageLoadBarToDisappear();
        String xpath = getXpath("leftMenuItem", label);
        WebElement menuItem = driver.findElement(By.xpath(xpath));
        menuItem.click();
    }

    public void radioSelectByID(String id, String radioInput) {
        waitPageLoading();
        if (radioInput != null) {
            String xpath = "//div[text()='" + id + "']/../div//span[contains(.,'" + radioInput + "')]/../div";
            WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            try {
                radioButton.click();
                // Thread.sleep(1000);
            } catch (ElementClickInterceptedException e) {
                radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                radioButton.click();
            }
        }

    }

    public void selectRadioByLabel(String label, String radioInput) {
        waitPageLoading();
        String radioButtonXpath = "";
        if (radioInput.equalsIgnoreCase("yes")) {
            radioButtonXpath = "//tr/td//div[contains(text(),\"" + label + "\")]/../../../../following-sibling::td[1]//div[@aria-label='Yes']";
        } else {
            radioButtonXpath = "//tr/td//div[contains(text(),\"" + label + "\")]/../../../../following-sibling::td[1]//div[@aria-label='No']";
        }
        WebElement radioButton = driver.findElement(By.xpath(radioButtonXpath));
        radioButton.click();
    }

    public void selectProduct(String productName) {
        waitPageLoading();
        System.out.println("Selecting product: " + productName);
        String productButton = "//div[text()=\"" + productName + "\"]//ancestor::tr[contains(@id,'ProductSelectionLV')]//div[contains(@id,'ddSubmission')]";
        WebElement nextPagination = driver.findElement(By.xpath("//div[@id=\"NewSubmission-NewSubmissionScreen-ProductOffersDV-ProductSelectionLV-_ListPaging-next\"]"));
        if (!driver.findElements(By.xpath(productButton)).isEmpty()) {
            WebElement product = driver.findElement(By.xpath(productButton));
            product.click();
        } else {
            if (nextPagination.isEnabled()) {
                nextPagination.click();
                WebElement product = driver.findElement(By.xpath(productButton));
                product.click();
            } else
                assertExpectedAndActualText("Product not available", "Product should be available");

        }
    }

    public String getActionType(String labelName) {
        waitPageLoading();
        String buttonXpath = getXpath("button", labelName);
        String editableXpath = getXpath("editable", labelName);
        if (!driver.findElements(By.xpath(buttonXpath)).isEmpty()) {
            return "labelClick";
        } else if (!driver.findElements(By.xpath(editableXpath)).isEmpty()) {
            WebElement editableElement = driver.findElement(By.xpath(editableXpath));
            String type = editableElement.getAttribute("data-gw-getset");
            switch (type) {
                case "text":
                case "date":
                    return "labelSetValue";
                case "radio":
                    return "selectRadioByID";
                case "select":
                    return "labelSelect";
                default:
                    throw new IllegalArgumentException("Unknown type: " + type);
            }
        }
        throw new NoSuchElementException("Element not found for labelName: " + labelName);
    }

    private String getXpath(String key, String labelName) {
        switch (key) {
            case "button":
                return "(//div[@role='button' or @role='link' or @role='menuitem']//descendant::div[@aria-label='" + labelName + "'][1] | " +
                        "//div[@role='button' or @role='link' or @role='menuitem']//descendant::div[text()='" + labelName + "'][1])";
            case "select":
                return "//*[@id='gw-center-bottom-section']//div[text()='" + labelName + "']//following::select[1]";
            case "input":
                return "//div[text()='" + labelName + "']//following::input[1]";
            case "input1":
                return "//div[text()='" + labelName + "']//following::input[@type = 'text'][1]";
            case "button2":
                return"(//div[@role='button' or @role='link' or @role='menuitem']//descendant::div[@aria-label='" + labelName + "'][2] | " +
                        "//div[@role='button' or @role='link' or @role='menuitem']//descendant::div[text()='" + labelName + "'][2])";
            case "textarea":
                return "//*[@id='gw-center-bottom-section']//div[text()='" + labelName + "']//following::textarea[1]";
            case "leftMenuItem":
                return "//div[@role='menuitem']//parent::div[contains(@class,'WestPanel')]//child::div[@aria-label='" + labelName + "'][1]";
            case "editable":
                return "(//div[text()='" + labelName + "'][1]//following::div[contains(@class,'editable')][1])[1]";
            default:
                throw new IllegalArgumentException("Unknown key: " + key);
        }
    }

    private String getXpath(String key, String labelName, String value) {
        switch (key) {
            case "clickValue":
                return "//div[text()='" + value + "']";
            default:
                throw new IllegalArgumentException("Unknown key: " + key);
        }
    }


    public String getAllMethodsToPerformRequiredActions(String locator, String actionType, String value) {
        waitPageLoading();
        String id;
        String returnValue = null;
        if (locator.startsWith("id")) {
            id = "[id$='" + locator.substring(3) + "']";
        } else if (locator.startsWith("aria-label")) {
            id = "[aria-label='" + locator.substring(10) + "']";
        } else if (locator.startsWith("xpath")) {
            id = locator.substring(5);
        } else if (locator.startsWith("css")) {
            id = locator.substring(3);
        } else {
            id = locator;
        }

        if (value == null || value.equals("") || value.toLowerCase().equals("na")) {
            System.out.println(locator + actionType + value);
            switch (actionType) {
                case "standardClick":
                    driver.findElement(By.xpath(id)).click();
                    break;
                case "labelClick":
                    clickAnyButton(id);
                    break;
                case "xpathClick":
                    click(id);
                    break;
                case "movePointer":
                    movePointer();
                    break;
                case "jsClick":
                    clickByJS(id);
                    break;
                case "cssClick":
                    driver.findElement(By.cssSelector(id)).click();
                    break;
                case "labelValueClick":
                    clickBasedOnInputValue(id, value);
                    break;
                case "labelSelect":
                    selectOptionsForFieldWithSelect(id, value);
                    break;
                case "xpathSelect":
                    selectOptionsForSpecificFieldWithSelect(id, value);
                    // selectOptionsForFieldWithSelect(id, value);
                    break;
                case "cssSetValue":
                    setValueForFieldWithCSSInput(id, value);
                    break;
                case "labelSetValue":
                    setValueForFieldWithInput(id, value);
                    break;
                case "labelTextArea":
                    setValueForFieldWithTextArea(id, value);
                    break;
                case "xpathSetValue":
                    setValueForSpecificFieldWithInput(id, value);
                    break;
                case "xpathDeleteAndSetValue":
                    deleteAndSetValueForSpecificFieldWithInput(id, value);
                    break;
                case "xpathAssert":
                    assertValueBasedOnText(id, value);
                    break;
                case "assertXpath":
                    verifyTextofElement(id);
                    break;
                case "leftMenuClick":
                    clickAnyMenuItemLeftPane(value);
                    break;
                case "selectRadioByID":
                    radioSelectByID(id, value);
                    break;
                case "labelSelectProduct":
                    selectProduct(value);
                    break;
                case "storeVariableData":
                    storeVariableData();
                    break;
                case "labelHover":
                    labelHover(id);
                    break;
                case"okClick":
                    clickAnyButton2(id);
                    break;

                case "xpathClickAndHandleAlert":
                    clickAndHandleAlert(id);
                    break;
                case "labelInputValue":
                    setValueForFieldWithInputValue(id, value);
                    break;
                case "doubleClick":
                    doubleclick(id);
                    break;
                case "setJsonColumnValue":
                    this.setJsonColumnValue(value);
                    System.out.println("Read the column value: " + actionType);
                    break;
                case "selectCheckboxByLabel":
                    checkboxSelectByLabel(id);
                    break;
                case "xpathClickAndHandleWarnings":
                    clickAndHandleWarnings(id);
                    break;
                default:
                    System.out.println("Invalid actionType: " + actionType);
                    break;
            }
        } else {
            switch (actionType) {
                case "click":
                case "labelClick":
                case "xpathClick":
                    driver.findElement(By.xpath(id)).click();
                    break;
                case "labelValueClick":
                    clickBasedOnInputValue(id, value);
                    break;
                case "jsClick":
                    clickByJS(id);
                    break;
                case "movePointer":
                    movePointer();
                    break;
                case "labelSelect":
                    selectOptionsForFieldWithSelect(id, value);
                    break;
                case "xpathSelect":
                    selectOptionsForSpecificFieldWithSelect(id, value);
                    break;
                case "labelSetValue":
                    setValueForFieldWithInput(id, value);
                    break;
                case "labelTextArea":
                    setValueForFieldWithTextArea(id, value);
                    break;
                case"okClick":
                    clickAnyButton2(id);
                    break;
                case "xpathSetValue":
                    setValueForSpecificFieldWithInput(id, value);
                    break;
                case "xpathDeleteAndSetValue":
                    deleteAndSetValueForSpecificFieldWithInput(id, value);
                    break;
                case "cssSetValue":
                    setValueForFieldWithCSSInput(id, value);
                    break;
                case "xpathAssert":
                    assertValueBasedOnText(id, value);
                    break;
                case "leftMenuClick":
                    clickAnyMenuItemLeftPane(value);
                    break;
                case "selectRadioByID":
                    radioSelectByID(id, value);
                    break;
                case "selectRadioByLabel":
                    selectRadioByLabel(locator, value);
                    break;
                case "labelSelectProduct":
                    selectProduct(value);
                    break;
                case "assertXpath":
                    verifyTextofElement(id);
                    break;
                case "storeVariableData":
                    storeVariableData();
                    break;
                case "labelHover":
                    labelHover(id);
                    break;
                case "labelInputValue":
                    setValueForFieldWithInputValue(id, value);
                    break;
                case "doubleClick":
                    doubleclick(id);
                    break;
                case "setJsonColumnValue":
                    this.setJsonColumnValue(value);
                    System.out.println("Read the column value: " + actionType);
                case "selectCheckboxWithinTable":
                    selectCheckboxWithinTable(value);
                    break;
                default:
                    System.out.println("Invalid actionType: " + actionType);
                    break;
            }
        }
        return returnValue;
    }

    private void storeVariableData() {
        String claimNumberWithTex = driver.findElement(By.xpath("//*[@id=\"NewClaimSaved-NewClaimSavedScreen-NewClaimSavedDV-Header\"]")).getText();
        String actualClaimNumber = claimNumberWithTex.substring(6, 19);
        TestDataContainer.setDataMap("Claim Number", actualClaimNumber);
        Allure.step("Claim Number is:" + actualClaimNumber);
        String claimretrieval = TestDataContainer.getDataMap("Claim Number");
    }



    public void clickAnyButton2(String labelName) {
        // waitPageLoading();
        String xpath = getXpath("button2", labelName);
        try {
            WebElement button = driver.findElement(By.xpath(xpath));
            button.click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        catch (StaleElementReferenceException e){
            WebElement button = driver.findElement(By.xpath(xpath));
            button.click();
        }
        waitPageLoading();

    }


    public String gettingText(String element) {

        return driver.findElement(By.xpath(element)).getText();
    }

    private void clickByJS(String id) {
        try {
            WebElement btn = driver.findElement(By.xpath(id));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", btn);
            btn.click();
        } catch (Exception e) {
            WebElement btn = driver.findElement(By.xpath(id));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", btn);
            btn.click();
        }
    }

    public void click(String id) {

        try {

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(id))));
            driver.findElement(By.xpath(id)).click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            driver.findElement(By.xpath(id)).click();
        }
        try {
            handleAlert();
            System.out.println("Alert appeared and handled");
        } catch (Exception e) {
            System.out.println("Alert didn't appear");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //waitForPageLoadBarToDisappear();
    }

    private void movePointer() {
        // Tab once
        Actions act = new Actions(driver);
        act.sendKeys(Keys.HOME).build().perform();
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.ENTER).build().perform();
    }

    private void waitPageLoading() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
    }

    // Method to wait for the page to load and the load bar disappear
    protected void waitForPageLoadBarToDisappear() {
        try {

            // Declare load bar variable
            By pageLoadBar = By.xpath("//div[@class='gw-page-load-bar--" +
                    "inner gw-page-load-bar--filling']");

            // Wait for invisibility of load bar
            wait.pollingEvery(Duration.ofMillis(1000))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.
                            invisibilityOfElementLocated(pageLoadBar)));

        } catch (NullPointerException ignored) {


        }

    }


    // Method to capture the text from a web element and compare this to a
    // passed expected value using generic string locator
    public void verifyTextofElement(String label) {

        //Title page header
        By pageTitle = By.xpath("//div[text()='" + label + "']");
        Assert.assertTrue(driver.findElement(pageTitle).getText().equalsIgnoreCase(label));

    }

    private void labelHover(String locator) {
        WebElement elementToHover = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
    }

    public void setValueForFieldWithInputValue(String fieldName, String value) {
        waitPageLoading();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (value != null) {
            String xpath = getXpath("input1", fieldName);
            WebElement inputField = driver.findElement(By.xpath(xpath));
            inputField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
            inputField.sendKeys(value);
            inputField.sendKeys(Keys.TAB);
            waitPageLoading();
        }
    }

    public void handleAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void assertExpectedAndActualText(String actual, String expected) {
        Assert.assertTrue(actual.equals(expected), "Actual and expected texts don't match");
    }

    public void clickAndHandleAlert(String labelName) {
      //  String xpath = getXpath("button", labelName);
       // WebElement button = driver.findElement(By.xpath(xpath));
        WebElement button = driver.findElement(By.xpath(labelName));
        button.click();
        try {
            handleAlert();
            System.out.println("Alert appeared and handled");
        } catch (Exception e) {
            System.out.println("Alert didn't appear");
        }
        waitPageLoading();
    }


    private void doubleclick(String locator) {
        WebElement elementToHover = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).doubleClick().perform();
    }

    public void clickElementByXPath(WebDriver driver, String Locator) {
        waitPageLoading();
        WebElement menuItem = driver.findElement(By.xpath(Locator));
        menuItem.click();
    }

    public void setJsonColumnValue(String value) {
        waitPageLoading();
        if (value != null) {
            System.out.println("Read column values");
        }
    }


    public void checkboxSelectByLabel(String label) {
        String locator = "//div[(text()=\"" + label + "\")]/preceding-sibling::div[@data-gw-getset='checkbox']";
        click(locator);
    }

    public void selectCheckboxWithinTable(String checkboxName) {
        String locator = "//div[contains(text(),\"" + checkboxName + "\")]/ancestor::td/preceding-sibling::td//div[@role='checkbox']/div";
        click(locator);
    }
    public void clickAndHandleWarnings(String id)
    {
        List<WebElement> warnings=new ArrayList<>();
        do
        {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(id))));
            driver.findElement(By.xpath(id)).click();
            try
            {
                handleAlert();
                System.out.println("Handled alert");
            }
            catch(Exception e)
            {
                System.out.println("Alert didn't appear");
            }
            warnings=driver.findElements(By.xpath("//div[text()='Clear']/parent::div[@role='button']"));
            if(!warnings.isEmpty())
            {
                driver.findElement(By.xpath("//div[text()='Clear']/parent::div[@role='button']")).click();
            }
        }while(!warnings.isEmpty());
    }
}
