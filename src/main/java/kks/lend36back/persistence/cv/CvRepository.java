package kks.lend36back.persistence.cv;

import jakarta.transaction.Transactional;
import kks.lend36back.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {
    @Transactional
    @Modifying
    @Query("delete Cv p where p.user = :userById ")
    void deleteCv(User userById);

}

