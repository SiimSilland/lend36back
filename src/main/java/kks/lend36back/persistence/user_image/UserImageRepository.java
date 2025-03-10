package kks.lend36back.persistence.user_image;

import kks.lend36back.persistence.student_profile.StudentProfile;
import kks.lend36back.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface UserImageRepository extends JpaRepository<UserImage, Integer> {
    @Transactional
    @Modifying
    @Query("delete UserImage p where p.user = :userId")
    void deleteUserImage(User userId);
}