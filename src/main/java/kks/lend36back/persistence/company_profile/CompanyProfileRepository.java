package kks.lend36back.persistence.company_profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Integer> {

    @Query("select c from CompanyProfile c where c.name = :companyName")
    List<CompanyProfile> getCompanyProfilesBy(String companyName);

}