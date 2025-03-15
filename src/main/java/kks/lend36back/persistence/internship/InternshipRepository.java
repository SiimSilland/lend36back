package kks.lend36back.persistence.internship;

import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface InternshipRepository extends JpaRepository<Internship, Integer> {

    @Query("select i from Internship i where i.companyUser.id = :id")
    List<Internship> findByCompanyUser_Id(@Param("id") Integer id);


    @Query("SELECT i FROM Internship i WHERE i.companyUser = :companyUser")
    Internship findInternshipBy(@Param("companyUser") User companyUser);

    @Transactional
    @Modifying
    @Query("delete from Internship i where i.companyUser = :companyUser")
    void deleteInternship(@Param("companyUser") User companyUser);
    Optional<Internship> findByCompanyUser(InternshipDto internshipDto);

    Optional<Object> findById(Long userId);

}
