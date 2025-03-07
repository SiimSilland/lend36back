package kks.lend36back.persistence.company_profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Integer> {


    @Query("select c from CompanyProfile c where c.user.id = :userId")
    Optional<CompanyProfile> findProfileBy(Integer userId);
}

