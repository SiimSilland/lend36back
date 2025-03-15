package kks.lend36back.persistence.groupemail;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface GroupEmailRepository extends JpaRepository<GroupEmail, Integer> {

    @Query("select g from GroupEmail g where g.email = :email and g.status = :status")
    Optional<GroupEmail> findGroupEmailBy(String email, String status);

    @Query("select g from GroupEmail g where (:groupId = 0 or g.group.id = :groupId) order by g.firstName, g.lastName")
    List<GroupEmail> findGroupEmailsBy(Integer groupId);

    @Query("select g from GroupEmail g where g.email = :email")
    Optional<GroupEmail> findGroupEmailByEmail(String email);

    @Transactional
    @Modifying
    @Query("delete GroupEmail where email = :email ")
    void deleteGroupEmail(String email);

}

