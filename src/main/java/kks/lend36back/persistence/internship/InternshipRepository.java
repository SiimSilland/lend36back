package kks.lend36back.persistence.internship;

import jakarta.validation.constraints.NotNull;
import kks.lend36back.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface InternshipRepository extends JpaRepository<Internship, Integer> {
    Internship findByCompanyUser(@NotNull User companyUser);

    @Query("select i from Internship i where i.companyUser.id = :id")
    List<Internship> findByCompanyUser_Id(@Param("id") Integer id);
}
