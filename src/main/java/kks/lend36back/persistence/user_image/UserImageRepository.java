package kks.lend36back.persistence.user_image;

import kks.lend36back.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserImageRepository extends JpaRepository<UserImage, Integer> {
    @Transactional
    @Modifying
    @Query("delete UserImage p where p.user = :userId")
    void deleteUserImage(User userId);

    @Query("select u from UserImage u where u.user.id = :userId")
    Optional<UserImage> findUserImageBy(Integer userId);

    @Query("select (count(u) > 0) from UserImage u where u.user.id = :userId")
    boolean userImageExistsBy(Integer userId);


}