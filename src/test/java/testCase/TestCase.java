package testCase;

import java.util.ArrayList;


public class TestCase {
    private String title;
    private String testId;
    private ArrayList<Step> steps;

    public TestCase(String title){
        setTitle(title);
        steps = new ArrayList<>();
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

}
