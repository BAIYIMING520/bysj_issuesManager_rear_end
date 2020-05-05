package baiyiming.test.issues_manage.repeatPart;

public enum Resolution {
    //这里要说明一下 如果data的Status属性是 Patch Available 则意味着这一项的属性为null 列表中没有给出解决方法 在原来的方式中给出了补丁
    Fixed("Fixed"),
    Duplicate("Duplicate"),
    Wont_Fix("Won't Fix"),
    Cannot_Reproduce("Cannot Reproduce"),
    Invalid("Invalid"),
    Not_A_Problem("Not A Problem");
    private String ResolutionType;
    Resolution(String resolutionType) {
        ResolutionType = resolutionType;
    }
    public String getResolutionType() {
        return ResolutionType;
    }
}
