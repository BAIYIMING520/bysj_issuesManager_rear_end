package baiyiming.test.issues_manage.repeatPart;

public enum Status {
    Open("Open"),
    Resolved("Resolved"),
    PatchAvailable("Patch Available"),
    Closed("Closed");
    private String statusType;
    private Status(String statusType) {
        this.statusType = statusType;
    }
    public String getStatusType() {
        return statusType;
    }
}
