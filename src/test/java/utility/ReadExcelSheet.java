package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import testCase.TestCase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** Utility for reading test case data from the provided excel sheet. */
public class ReadExcelSheet {

    /**
     * This method uses Apache POI library to read test cases from the provided
     * excel sheet, and store each
     * test and its steps in a TestCase object list for later processing.
     */
    public ArrayList<TestCase> readExcelSheet() throws IOException {
        String fileSeparator = File.separator;
        String filePath = String.format("%ssrc%stest%sjava%sexcelData%stestCases.xlsx", fileSeparator, fileSeparator,
                fileSeparator, fileSeparator, fileSeparator, fileSeparator);
        String localDir = System.getProperty("user.dir");
        File file = new File(localDir + filePath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        Iterator row = sheet.rowIterator();

        // First row is column titles, skip it
        row.next();

        // Read excel sheet to store test cases/steps as TestCase testCase
        ArrayList<TestCase> tests = new ArrayList<TestCase>();
        int testCaseCounter = 0;
        while (row.hasNext()) {
            Row r = (Row) row.next();

            // Moving cursor to the cell by getting a cell number.
            Cell cell = r.getCell(0);

            // If the title column is not empty, then it is a new test case and a new test
            // definition must be created
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
}
