package baiyiming.test.issues_manage.repository;

import baiyiming.test.issues_manage.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;

@Repository
public interface userRepo  extends JpaRepository<user,Integer> {
    public user findByUserId(int userId);//这里应该转换成list列表 我们在中间可以声明不能出现重复的username
    public user findByUsername(String userName);
    public ArrayList<user> findAll();
    public boolean deleteAllByUsername(String userName);
    @Query( value = "SELECT COUNT(*) FROM user WHERE user.recentLoginTime<:date ",nativeQuery = true)
    public int findRecentUserNumber(Date date);

}
