package executionEngine;

import testCase.TestCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUtility.ReadExcelSheet;

import java.io.IOException;
import java.util.ArrayList;

public class DataProviderTest {

    @DataProvider(name = "createTestsArray")
    public Object[][] createTestsArray() throws IOException {
        ReadExcelSheet reader = new ReadExcelSheet();
        ArrayList<TestCase> tests = reader.readExcelSheet();
        // Must return object array with data when using @DataProvider
        Object[][] tests2 = new Object[tests.size()][1];
        for (int i = 0; i < tests.size(); i++) {
            tests2[i][0] = tests.get(i);
        }
        return tests2;
    }

    @Test(dataProvider = "createTestsArray")
    public void executeTest(TestCase testCase) throws IOException, InterruptedException {
        String keyword;
        String object;
        String objectType;
        String data;
        String description;
        int stepsCount = testCase.getSteps().size();

        System.out.print("Executing test case: " + testCase.getTitle());

        // Iterate over test steps and pass test details to the executeStep method
        for (int p = 0; p < stepsCount; p++) {
            keyword = testCase.getStep(p).getKeyword();
            object = testCase.getStep(p).getObject();
            objectType = testCase.getStep(p).getObjectType();
            data = testCase.getStep(p).getData();
            description = testCase.getStep(p).getDescription();

            System.out.println("  Executing step: " + description);
            testCase.executeStep(keyword, object, objectType, data, description);
        }

        System.out.print("End of test script");

    }

}
