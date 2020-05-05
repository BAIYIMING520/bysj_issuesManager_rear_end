package baiyiming.test.issues_manage.repeatPart;

public class queryInfo {
    public String querypara;
    public int pageIndex;
    public int pageSize;

    public queryInfo(){
        this.querypara=null;
        this.pageIndex=1;
        this.pageSize=10;
    }

    @Override
    public String toString() {
        return "queryInfo{" +
                "querypara='" + querypara + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getQuerypara() {
        return querypara;
    }
    public void setQuerypara(String querypara) {
        this.querypara = querypara;
    }
    public int getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
