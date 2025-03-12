package kks.lend36back.persistence.company_profile;

import kks.lend36back.persistence.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Integer> {
    @org.springframework.transaction.annotation.Transactional

    @Modifying
    @Query("delete from CompanyProfile c where c.user = :user")
    void deleteCompanyProfile(User user);

    @Query("select c from CompanyProfile c where c.user.id = :userId")
    Optional<CompanyProfile> findProfileBy(Integer userId);


    boolean existsByRegistrationNumber(String registrationNumber);



}

