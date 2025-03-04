package kks.lend36back.persistence.company_profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Integer> {
    @Transactional
    @Modifying
    @Query("""
            update CompanyProfile c set c.name = ?1
            where c.name = ?2 and c.registrationNumber = ?3 and c.description = ?4 and c.www = ?5""")
    int updateCompany(@NonNull String name, @NonNull String name1, String registrationNumber, String description, String www);
}