package baiyiming.test.issues_manage.repeatPart;

public enum Priority {
    Minor("Minor"), Major("Major"), Trivial("Trivial"), Critical("Critical"), Blocker("Blocker");
    private String priority;
    private Priority(String name) {
        this.priority = name;
    }
    public String getType(){
        return this.priority;
    }
}