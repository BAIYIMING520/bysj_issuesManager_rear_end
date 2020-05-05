package baiyiming.test.issues_manage.repository;
import baiyiming.test.issues_manage.entity.data;
import baiyiming.test.issues_manage.repeatPart.Percentage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public interface dataRepo extends JpaRepository<data,Integer> {
    //这里写基础类的所有查询方式
    //先写list类型的 之后在使用page函数进行返回 在这里使用后端分页的方式
    public data findByDataId(int id);
    public Page<data> findByTablesId(Pageable pageable,int id);
    public Page<data> findByType(Pageable pageable, String type);
    public Page<data> findByTitle(Pageable pageable,String title);
    public Page<data> findByAssignee(Pageable pageable,String Assignee);
    public Page<data> findByReporter(Pageable pageable,String Reporter);
    public Page<data> findByPriority(Pageable pageable,String Priority);
    public Page<data> findByStatus(Pageable pageable,String Status);
    public Page<data> findByResolution(Pageable pageable,String Resolution);
    public Page<data> findByTablesIdAndType(Pageable pageable,int id, String type);
    public Page<data> findByTablesIdAndTagId(Pageable pageable,int id1, int id2);
    public Page<data> findByTablesIdAndTagIdAndType(Pageable pageable,int id1,int id2,String type);

    ////这里测试page参数一定要放 后面即不传入在sql语句中的参数应该放在后面 否则编译不通过 否则就使用:变量名 需要在para中加入注解
//    @Query(value = "select d from data d where d.tablesId=?1")
//    public Page<data> findTest(int para,Pageable pageable);//这里测试是否函数名会导致查询不成功
//    //这里工程要求 推荐还是使用jpa的推荐的方式来进行函数的命名
    @Transactional
    @Query(value = "select * from data where tablesId=?1 and if(?2 != '',type = ?2, 2=2) and if(?3 !='',priority = ?3, 3=3)"+
            "and if(?4 !='', status=?4, 4=4) and if(?5 !='',title=?5, 5=5)",nativeQuery = true)
    public Page<data> findOption(int tableId,String Type,String Priority,String Status, String title,Pageable pageable);

    @Query(value =
            "SELECT tablesName,tablesId,percentage FROM tables NATURAL JOIN " +
            "(SELECT tablesId, ROUND(unacheive/total*100,1) AS percentage " +
            "FROM (SELECT data.tablesId,COUNT(*) AS unacheive FROM data WHERE data.tagId!=0 GROUP BY data.tablesId) AS T1 " +
            "NATURAL JOIN " +
            "(SELECT data.tablesId ,COUNT(*) AS total FROM data GROUP BY data.tablesId) AS T2) AS T",
            nativeQuery = true )
    public ArrayList<List> findPercentage();

    //------------------------------------>       返回单表数据分析接口       <--------------------------------//
    @Query(nativeQuery = true, value = "SELECT type,count(*) FROM data WHERE tablesId=:tablesId GROUP BY type ")
    public ArrayList<List> findCountBytype(int tablesId);
    @Query(nativeQuery = true, value = "SELECT priority,count(*) FROM data WHERE tablesId=:tablesId GROUP BY priority ")
    public ArrayList<List> findCountBypriority(int tablesId);
    @Query(nativeQuery = true, value = "SELECT status,count(*) FROM data WHERE tablesId=:tablesId GROUP BY status ")
    public ArrayList<List> findCountBystatuse(int tablesId);
    @Query(nativeQuery = true, value = "SELECT tagName,num FROM (SELECT tagId, count(*) as num  FROM data WHERE tablesId=:tablesId GROUP BY tagId) AS T NATURAL JOIN tag;")
    public ArrayList<List> findCountBytag(int tablesId);
    //------------------------------------>       返回全局数据分析数据接口       <--------------------------------//
    @Query(nativeQuery = true,value = "select  tablesId,type,count(*) from data group by tablesId,type;")
    public ArrayList<List> getTableCountByType();
    @Query(nativeQuery = true,value = "select  tablesId,priority,count(*) from data group by tablesId,priority;")
    public ArrayList<List> getTableCountByPriority();
    @Query(nativeQuery = true,value = "select  tablesId,status,count(*) from data group by tablesId,status;")
    public ArrayList<List> getTableCountByStatus();
    @Query(nativeQuery = true, value = "SELECT tablesId,tagName,num FROM (SELECT tablesId, tagId, count(*) as num  FROM data GROUP BY tagId,tablesId) AS T NATURAL JOIN tag;")
    public ArrayList<List> getTableCountByTagId();
    //------------------------------------>       返回类型数据名       <--------------------------------//
    //这里返回的是表的名称以及num
    @Query(nativeQuery = true,value = "SELECT tablesId,tablesName,num FROM (SELECT tablesId, count(*) as num  FROM data GROUP BY tablesId,tablesId) AS T NATURAL JOIN tables")
    public ArrayList<List> getTotalCountByTablesId();

    @Query(nativeQuery = true, value = "SELECT DISTINCT (type) FROM data; ")
    public ArrayList<String> getNameDataByType();

    @Query(nativeQuery = true, value = "SELECT DISTINCT (priority) FROM data;")
    public ArrayList<String> getNameDataByPriority();

    @Query(nativeQuery = true, value = "SELECT DISTINCT (status) FROM data;")
    public ArrayList<String> getNameDataByStatus();
    //tag数据直接从tag表中获取就ok
}
