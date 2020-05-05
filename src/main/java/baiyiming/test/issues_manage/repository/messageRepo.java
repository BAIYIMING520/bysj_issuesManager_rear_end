package baiyiming.test.issues_manage.repository;

import baiyiming.test.issues_manage.entity.message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface messageRepo extends JpaRepository<message,Integer> {

    //这用户返回一个list来生成连表来形成所有的发布消息
    @Query(nativeQuery = true,value = "SELECT * FROM (SELECT * FROM usermessage WHERE userId=?1 AND status=1) AS P NATURAL JOIN message;")
    ArrayList<List> findAllUnreadMessage(int userId);//返回消息列表
}
