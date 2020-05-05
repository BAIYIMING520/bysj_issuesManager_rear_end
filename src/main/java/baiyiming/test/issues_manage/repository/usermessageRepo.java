package baiyiming.test.issues_manage.repository;

import baiyiming.test.issues_manage.entity.usermessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usermessageRepo extends JpaRepository<usermessage,Integer> {
    public usermessage findByUmId(int umId);
}
