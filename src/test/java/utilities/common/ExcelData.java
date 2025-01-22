package utilities.common;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelData extends Driver {

    private static Workbook excelFile;
    static Map<String, String> sheetsIdsRequired;

    static String[] parts;
    static Map<String, String> sheetNameTestDataIdMap;
    static Map<String, String> sheetDataMultipleObject = new HashMap<>();
    static Map<String, String> sheetDataObject = new HashMap<>();
    Sheet referenceSheet;
    public static void initializeExcelFile(String excelPath) throws IOException {
        FileInputStream file = new FileInputStream(excelPath);
        excelFile = new XSSFWorkbook(file);
    }
    @Step("Generate Dynamic Test Data")
    public static Map<String, String> getRequiredTestData(String scenarioName, String excelPath) throws IOException {
        if (scenarioName != null && !scenarioName.isEmpty()) {
            initializeExcelFile(excelPath);
            sheetsIdsRequired = getSheetNamesAndTestDataIdsObject(scenarioName);
            //  Map<String, String> globalData = null;
            for (String sheetName : sheetsIdsRequired.keySet()) {
                String testDataIDs = sheetsIdsRequired.get(sheetName);
                if (testDataIDs.contains(",")) {
                    Allure.step("Multiple testDataID: " + testDataIDs);
                    globalData_multiple = getSheetDataObjectMultipleTestId(sheetName, testDataIDs);
                    System.out.println("printing global"+globalData_multiple);
                    //  globalData.put(sheetName, getSheetDataObjectMultipleTestId(sheetName, testDataIDs));
                } else {
                    Allure.step("Single testDataID: " + testDataIDs);
                    globalData_single= getSheetDataObject(sheetName, testDataIDs);
                    System.out.println("printing else global"+globalData_single);
                }
            }
            Allure.step("Data retrieved");

            globalData.putAll(globalData_single);
            if(globalData_multiple.isEmpty() || globalData_multiple ==null){}
                else{globalData.putAll(globalData_multiple);}
            System.out.println("printing final global"+globalData);
            return globalData;
        }
        return null;
    }

    private static Map<String, String> getSheetDataObject(String sheetName, String testDataId) {

        Sheet sheet = excelFile.getSheet(sheetName);
        if (sheet != null) {
            Row headerRow = sheet.getRow(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row
                if (row.getCell(0).getStringCellValue().equals(testDataId)) {
                    for (Cell cell : row) {
                        String header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
                        sheetDataObject.put(header, getCellValue(cell).toString());
                    }
                    break;
                }
            }
        }
        return sheetDataObject;
    }

    public static Map<String, String> getSheetDataObjectMultipleTestId(String sheetName, String testDataIds) {

        Sheet sheet = excelFile.getSheet(sheetName);
        if (sheet != null) {
            Row headerRow = sheet.getRow(0);
            testDataIdArray = testDataIds.split(",");
            for (String testDataId : testDataIdArray) {
                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue; // Skip header row
                    if (row.getCell(0).getStringCellValue().equals(testDataId)) {
                        for (Cell cell : row) {
                            String header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
                            String key = testDataId + "_" + header; // Create unique key for each entry
                            sheetDataMultipleObject.put(key, getCellValue(cell).toString());
                        }
                        break;
                    }
                }
            }
        }
        return sheetDataMultipleObject;
    }

    private static Map<String, String> getSheetNamesAndTestDataIdsObject(String scenarioName) {
         sheetNameTestDataIdMap = new HashMap<>();
        Sheet referenceSheet = excelFile.getSheet("Reference");
        for (Row row : referenceSheet) {
            if (row.getCell(0).getStringCellValue().equals(scenarioName)) {
                for (Cell cell : row) {
                    System.out.println("PRINTING sheet ref"+cell.getStringCellValue());
                  parts = cell.getStringCellValue().split("::");
                    if (parts.length ==2) {
                        sheetNameTestDataIdMap.put(parts[0], parts[1]);
                    }
                }
                break;
            }
        }
        return sheetNameTestDataIdMap;
    }

    private static String getCellValue(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return formatter.formatCellValue(cell); // Use DataFormatter for numeric values
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                switch (cell.getCachedFormulaResultType()) {
                    case STRING:
                        return cell.getStringCellValue().trim();
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            return cell.getDateCellValue().toString();
                        } else {
                            return formatter.formatCellValue(cell); // Use DataFormatter for numeric values
                        }
                    case BOOLEAN:
                        return String.valueOf(cell.getBooleanCellValue());
                    default:
                        return cell.getCellFormula();
                }
            case BLANK:
                return "";
            default:
                return "";
        }
    }

}