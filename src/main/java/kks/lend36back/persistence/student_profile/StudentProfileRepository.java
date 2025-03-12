package kks.lend36back.persistence.student_profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {
    @Query("select s from StudentProfile s where s.user.id = :userId")
    StudentProfile findByUserId(Integer userId);

}