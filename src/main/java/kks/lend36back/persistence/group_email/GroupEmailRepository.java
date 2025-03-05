package kks.lend36back.persistence.group_email;

import kks.lend36back.persistence.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface GroupEmailRepository extends JpaRepository<GroupEmail, Integer> {

    @Query("select g from GroupEmail g where g.email = :email and g.status = :status")
    Optional<GroupEmail> findByEmail(String email, String status);


}

