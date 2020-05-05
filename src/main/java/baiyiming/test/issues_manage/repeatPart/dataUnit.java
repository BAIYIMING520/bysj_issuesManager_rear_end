package baiyiming.test.issues_manage.repeatPart;

import java.util.ArrayList;

public class dataUnit {
    //总的totalint
    public String tablesName;
    public int tablesId;
    public int total;
    public ArrayList<KeyValuePair> KVarray;

    public String getTablesName() {
        return tablesName;
    }

    public void setTablesName(String tablesName) {
        this.tablesName = tablesName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<KeyValuePair> getKVarray() {
        return KVarray;
    }

    public void setKVarray(ArrayList<KeyValuePair> KVarray) {
        this.KVarray = KVarray;
    }

    public int getTablesId() {
        return tablesId;
    }

    public void setTablesId(int tablesId) {
        this.tablesId = tablesId;
    }

}
