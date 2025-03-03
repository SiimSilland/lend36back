package kks.lend36back.persistence.group_email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupEmailRepository extends JpaRepository<GroupEmail, Integer> {

    @Query("select g from GroupEmail g where g.email = :email")
    Optional<GroupEmail> findByEmail(String email);

}

