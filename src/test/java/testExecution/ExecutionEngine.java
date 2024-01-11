package testExecution;

import org.testng.annotations.Test;
import testCase.TestCase;
import utility.ExcelReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExecutionEngine {

    /**
     * Creates a list of TestCases using the ExcelReader and
     * then calls the TestCase.executeTest() method on each test case.
     */
    @Test
    public void executeTests() throws IOException {
        ExcelReader reader = new ExcelReader();
        ArrayList<TestCase> tests = reader.readExcelSheet();

        // Loop over tests and execute one-by-one
        for (int i = 0; i < tests.size(); i++) {
            tests.get(i).executeTest();
        }
    }
}
