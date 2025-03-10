
package kks.lend36back.service;

import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.CompanyDto;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.persistence.company_profile.CompanyProfileMapper;
import kks.lend36back.persistence.company_profile.CompanyProfileRepository;
import kks.lend36back.persistence.role.Role;
import kks.lend36back.persistence.role.RoleRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserMapper;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    public static final int ROLE_COMPANY = 3;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final CompanyProfileMapper companyProfileMapper;
    private final CompanyProfileRepository companyProfileRepository;

    @Transactional
    public void updateCompanyProfile(Integer userId, @Valid CompanyDto companyDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> ValidationService.throwPrimaryKeyNotFoundException("userId", userId));
        user.setEmail(companyDto.getEmail());
        userRepository.save(user);

        CompanyProfile existingProfile = companyProfileRepository.findProfileBy(userId).
                orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("userId", userId));
        companyProfileMapper.updateCompanyProfile(companyDto, existingProfile);
        companyProfileRepository.save(existingProfile);
    }

    public List<NewCompany> getAllCompanyProfiles() {
        List<CompanyProfile> companyProfiles = companyProfileRepository.findAll();
        List<NewCompany> allCompanyProfiles = companyProfileMapper.toCompanyProfile(companyProfiles);
        return allCompanyProfiles;
    }

    public void addNewCompany(NewCompany newCompany) {
        User user = createAndSaveCompanyUser(newCompany);
        createAndSaveCompanyProfile(newCompany, user);
    }

    private User createAndSaveCompanyUser(NewCompany newCompany) {
        User user = createCompanyUser(newCompany);
        userRepository.save(user);
        return user;
    }

    private User createCompanyUser(NewCompany newCompany) {
        Role role = roleRepository.getReferenceById(ROLE_COMPANY);
        User user = userMapper.toUser(newCompany);
        user.setRole(role);
        return user;
    }

    private void createAndSaveCompanyProfile(NewCompany newCompany, User user) {
        CompanyProfile companyProfile = createCompanyProfile(newCompany, user);
        companyProfileRepository.save(companyProfile);

    }

    private CompanyProfile createCompanyProfile(NewCompany newCompany, User user) {
        CompanyProfile companyProfile = companyProfileMapper.toCompanyProfile(newCompany);
        companyProfile.setUser(user);
        return companyProfile;
    }

}

/*
    public void addNewCompany(NewCompanyDto newCompany) {
        Role role = roleRepository.getReferenceById(ROLE_COMPANY);
        User user = userMapper.toUser(newCompany);
        user.setRole(role);
        userRepository.save(user);

        CompanyProfile companyProfile = companyProfileMapper.toNewCompany(newCompany);
        companyProfile.setUser(user);
        companyProfileRepository.save(companyProfile);
    }

    public CompanyProfile getCompanyProfile(Integer userId) {
        return companyProfileRepository.findProfileBy(userId)
                .orElseThrow(() -> ValidationService.throwPrimaryKeyNotFoundException("userId", userId));
    }

    public void updateCompanyProfile(Integer userId, NewCompanyProfileDto newCompanyProfileDto) {
        CompanyProfile existingProfile = companyProfileRepository.findProfileBy(userId).
                orElseThrow(() -> ValidationService.throwPrimaryKeyNotFoundException("userId not found with id: ", userId));
        companyProfileMapper.updateCompanyProfile(newCompanyProfileDto, existingProfile);
        companyProfileRepository.save(existingProfile);
    }
    public List<NewCompanyProfileDto> getAllCompanyProfiles() {
        List<CompanyProfile> companyProfiles = companyProfileRepository.findAll();
        List<NewCompanyProfileDto> allCompanyProfiles = companyProfileMapper.toCompanyProfile (companyProfiles);
        return allCompanyProfiles;

    }
    public void saveCompanyProfile(NewCompanyProfileDto newCompanyProfileDto, Integer userId) {
        CompanyProfile companyProfile = createCompanyProfile(newCompanyProfileDto, userId);
        companyProfileRepository.save(companyProfile);

    }
    private CompanyProfile createCompanyProfile(NewCompanyProfileDto newCompanyProfileDto, Integer userId) {
        User user = (User) userRepository.findById(userId)
                .orElseThrow (() -> new DuplicationResourceException(COMPANY_NUMBER_IN_USE.getMessage(), COMPANY_NUMBER_IN_USE.getErrorCode()));
        CompanyProfile companyProfile = companyProfileMapper.toCompanyProfile(newCompanyProfileDto);
        companyProfile.setUser(user);
        return companyProfile;
    }
 */