package testCase;

/**
 * This Plain Old Java Object (POJO) is crafted to encapsulate and manage test step details retrieved from an Excel sheet representing the test script.
 */

public class Step {
    private String stepId;
    private String keyword;
    private String object;
    private String objectType;
    private String data;
    private String description;

    public Step(String stepId, String keyword, String object, String objectType, String data, String description) {
        setStepId(stepId);
        setKeyword(keyword);
        setObject(object);
        setObjectType(objectType);
        setData(data);
        setDescription(description);
    }

    public Step() {}

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStepId() {
        return stepId;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getObject() {
        return object;
    }

    public String getObjectType() {
        return objectType;
    }

    public String getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }

}
