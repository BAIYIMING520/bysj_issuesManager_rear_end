package baiyiming.test.issues_manage.repeatPart;

public enum Type {
    Improvement("Improvement"),
    Bug("Bug"),
    Task("Task"),
    SubTask("SubTask");
    private String type;
    Type(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
