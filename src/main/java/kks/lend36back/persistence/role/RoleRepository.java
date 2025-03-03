package kks.lend36back.persistence.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.id = :id and r.name = :name")
    Role findByIdAndName(Integer id, String name);

}