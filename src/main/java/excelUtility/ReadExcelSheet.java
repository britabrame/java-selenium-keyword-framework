package excelUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import keywordDriven.Actions;
import testCase.TestCase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utility.Constants;

/** Utility for reading test case data from the provided excel sheet.*/
public class ReadExcelSheet {

    /** This method uses Apache POI library to read test cases from the provided excel sheet, and store each
     * test and its steps in a TestCase object list for later processing. */
    private ArrayList readExcelSheet() throws IOException {
        String filePath = Constants.testCaseFile;
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        Iterator row = sheet.rowIterator();

        // First row is column titles, skip it
        row.next();

        // Read excel sheet to store test cases/steps as TestCase testCase
        ArrayList<TestCase> tests = new ArrayList<TestCase>();
        int testCaseCounter = 0;
        while(row.hasNext()) {
            Row r = (Row) row.next();

            // Moving cursor to the cell by getting a cell number.
            Cell cell = r.getCell(0);

            // If the title column is not empty, then it is a new test case and a new test definition must be created
            String titleColumn = cell.getStringCellValue();
            if (titleColumn != null && !titleColumn.trim().isEmpty()) {
                tests.add(new TestCase(titleColumn));
                testCaseCounter++;
            }

            // Create step for the current row and add to the current test
            String stepId = r.getCell(1).getStringCellValue();
            String keyword = r.getCell(2).getStringCellValue();
            String object = r.getCell(3).getStringCellValue();
            String objectType = r.getCell(4).getStringCellValue();
            String data = r.getCell(5).getStringCellValue();
            String desc = r.getCell(6).getStringCellValue();

            tests.get(testCaseCounter - 1).addStep(stepId, keyword, object, objectType, data, desc);

        }
        return tests;
    }

    /** Calls the readExcelSheet() method, iterates over the tests case testCase returned from that method, and executes
     *  test steps using the perform() method from the Actions class. */
    public void executeTests() throws IOException, InterruptedException {
        ArrayList<TestCase> tests = readExcelSheet();
        Actions actions = new Actions();
        String keyword;
        String object;
        String objectType;
        String data;
        String description;

        // Iterate ove test cases and pass test details to the Actions.perform() method
        for(int i = 0; i < tests.size(); i++) {
            System.out.println("Executing test: " + tests.get(i).getTitle());
            for (int p = 0; p < tests.get(i).getSteps().size(); p++) {
                keyword = tests.get(i).getStep(p).getKeyword();
                object = tests.get(i).getStep(p).getObject();
                objectType = tests.get(i).getStep(p).getObjectType();
                data = tests.get(i).getStep(p).getData();
                description = tests.get(i).getStep(p).getDescription();

                System.out.println("  Executing step: " + description + ": " + data);
                actions.perform(keyword,object,objectType,data,description);
            }
        }
        System.out.print("End of test script");

    }
}

