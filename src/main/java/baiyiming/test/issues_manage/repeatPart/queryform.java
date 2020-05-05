package baiyiming.test.issues_manage.repeatPart;

public class queryform {
    int tablesId;
    String selectOption;

    public int getTablesId() {
        return tablesId;
    }

    public void setTablesId(int tablesId) {
        this.tablesId = tablesId;
    }

    public String getSelectOption() {
        return selectOption;
    }

    public void setSelectOption(String selectOption) {
        this.selectOption = selectOption;
    }

    @Override
    public String toString() {
        return "queryform{" +
                "tablesId=" + tablesId +
                ", selectOption='" + selectOption + '\'' +
                '}';
    }
}
