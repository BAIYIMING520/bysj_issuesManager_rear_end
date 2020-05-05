package baiyiming.test.issues_manage.repository;
import baiyiming.test.issues_manage.entity.tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface tagRepo extends JpaRepository<tag,Integer> {
    public tag findByTagId( int i );
    public ArrayList<tag> findByTagName(String Name);
    public List<tag> findAll();
    public Page<tag> findByTagName(Pageable pagea, String name);
    public Page<tag> findByTagNameAndColor(Pageable page,String TagName,int Color);
    public Page<tag> findByColor(Pageable page,int i);
    @Query(nativeQuery = true,value = "SELECT * FROM tag")
    public Page<tag> findAllQuery(Pageable page);

    @Query(nativeQuery = true,value = "SELECT DISTINCT(tagName) FROM tag")
    public ArrayList<String> getall();
}
