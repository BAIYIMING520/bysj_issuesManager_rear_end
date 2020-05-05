package baiyiming.test.issues_manage.repository;
import baiyiming.test.issues_manage.entity.description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface descriptionRepo  extends JpaRepository<description,Integer> {
    public description findByDecriptionId(int id);
    public Page<description> findByDataId(Pageable pageable,int id);
    public Page<description> findByUserId(Pageable pageable,int id);
    public Page<description> findByDataIdAndUserId(Pageable pageable,int dataId, int userId);
    @Query(value = "SELECT new List(d,u.username) FROM description d INNER JOIN  user u on d.userId = u.userId where d.dataId=?1 ")
    public Page<List>findByfindByDataIdWithUserName(int id,Pageable pageable);//
}
