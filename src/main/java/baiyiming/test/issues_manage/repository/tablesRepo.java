package baiyiming.test.issues_manage.repository;
import baiyiming.test.issues_manage.entity.tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface tablesRepo extends JpaRepository<tables,Integer> {
    public tables findByTablesId(int i);
    public Page<tables> findAll(Pageable pageable);
    public Page<tables> findByTablesId(Pageable pageable,int i);
    public Page<tables> findByBuilder(Pageable pageable,String name);
    public Page<tables> findByTablesName(Pageable pageable,String name);
    public void deleteByTablesId(int id);
    public tables findByTablesName(String i);
    public ArrayList<tables> findByBuilder(String i);

    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM tables;")
    public int getDistinctWithTable();
    @Query(nativeQuery = true,value = "SELECT tablesId,tablesName FROM tables;")
    public ArrayList<List> getNameAndId();
}
