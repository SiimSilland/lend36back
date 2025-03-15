package kks.lend36back.persistence.group;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {


    @Query("select g from Group g where g.status = :status order by g.number")
    List<Group> findGroupsBy(String status);

    @Query("select (count(g) > 0) from Group g where g.number = :number")
    boolean groupNumberExists(Integer number);

    @Transactional
    @Modifying
    @Query("delete Group where id = :groupId ")
    void deleteGroup(Integer groupId);

}