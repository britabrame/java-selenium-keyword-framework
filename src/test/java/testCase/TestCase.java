package testCase;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;

import utility.Keywords;

public class TestCase {
    private String title;
    private String testId;
    private ArrayList<Step> steps;
    private Keywords actions;

    public TestCase(String title) {
        setTitle(title);
        steps = new ArrayList<>();
        actions = new Keywords();
    }

    public String getTitle() {
        return title;
    }

    public String getTestId() {
        return testId;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public Step getStep(int index) {
        return steps.get(index);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public void addStep(String stepId, String keyword, String object, String objectType, String data, String desc) {
        Step step = new Step(stepId, keyword, object, objectType, data, desc);
        steps.add(step);
    }

    /**
     * This method takes test step details and calls the appropriate action method
     * for the given step.
     */
    public void executeStep(String keyword, String obj, String objectType, String data, String desc)
            throws InterruptedException {
        switch (keyword.toLowerCase()) {
            case "openbrowser":
                actions.openBrowser();
                break;
            case "goto":
                actions.goTo(data);
                break;
            case "closebrowser":
                actions.closeBrowser();
                break;
            case "click":
                actions.clickElement(obj, objectType);
                break;
            case "input":
                actions.input(obj, objectType, data);
                break;
            case "expectVisible":
                actions.expectVisible(obj, objectType);
                break;
        }
    }

}
