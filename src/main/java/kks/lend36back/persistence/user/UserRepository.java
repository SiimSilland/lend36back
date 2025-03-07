package kks.lend36back.persistence.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = :email and u.password = :password and u.status = :status")
    Optional <User> findUserBy(String email, String password, String status);

    @Query("select u from User u where u.id = :id")
    User findUserById(Integer id);


}