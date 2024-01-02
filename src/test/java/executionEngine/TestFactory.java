package executionEngine;

import java.io.IOException;
import java.util.ArrayList;

import excelUtility.ReadExcelSheet;
import keywordDriven.Actions;
import testCase.TestCase;

public class TestFactory {
    private ReadExcelSheet reader = new ReadExcelSheet();

    public void executeTests() throws IOException, InterruptedException {
        ArrayList<TestCase> tests = reader.readExcelSheet();
        Actions actions = new Actions();
        String keyword;
        String object;
        String objectType;
        String data;
        String description;

        // Iterate ove test cases and pass test details to the Actions.perform() method
        for (int i = 0; i < tests.size(); i++) {
            System.out.println("Executing test: " + tests.get(i).getTitle());
            for (int p = 0; p < tests.get(i).getSteps().size(); p++) {
                keyword = tests.get(i).getStep(p).getKeyword();
                object = tests.get(i).getStep(p).getObject();
                objectType = tests.get(i).getStep(p).getObjectType();
                data = tests.get(i).getStep(p).getData();
                description = tests.get(i).getStep(p).getDescription();

                System.out.println("  Executing step: " + description);
                actions.perform(keyword, object, objectType, data, description);
            }
        }
        System.out.print("End of test script");

    }
}
