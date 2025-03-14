
package kks.lend36back.service;

import jakarta.validation.Valid;
import kks.lend36back.controller.company.dto.CompanyDto;
import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.persistence.company_profile.CompanyProfileMapper;
import kks.lend36back.persistence.company_profile.CompanyProfileRepository;
import kks.lend36back.persistence.role.Role;
import kks.lend36back.persistence.role.RoleRepository;
import kks.lend36back.persistence.student_profile.StudentProfile;
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
    public void updateCompanyProfile(Integer userId, CompanyDto companyDto) {
        CompanyProfile companyProfile = companyProfileRepository.findProfileBy(userId).
                orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("userId", userId));
        companyProfileMapper.updateCompanyProfile(companyDto, companyProfile);
        companyProfileRepository.save(companyProfile);
    }

    public List<NewCompany> getAllCompanyProfiles() {
        List<CompanyProfile> companyProfiles = companyProfileRepository.findAll();
        return companyProfileMapper.toCompanyProfile(companyProfiles);
    }
    public CompanyDto getCompanyProfileByUserId(Integer userId) {
        CompanyProfile companyProfile = companyProfileRepository.findProfileBy(userId)
                .orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("userId", userId));
        CompanyDto companyDto = companyProfileMapper.mapToCompanyProfileDto(companyProfile);
        User user = userRepository.findById(userId).orElseThrow(() -> ValidationService.throwPrimaryKeyNotFoundException("userId", userId));
        companyDto.setEmail(user.getEmail());
        return companyDto;
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

    public void createAndSaveCompanyProfile(NewCompany newCompany, User user) {
        CompanyProfile companyProfile = createCompanyProfile(newCompany, user);
        companyProfileRepository.save(companyProfile);

    }

    private CompanyProfile createCompanyProfile(NewCompany newCompany, User user) {
        CompanyProfile companyProfile = companyProfileMapper.toCompanyProfile(newCompany);
        companyProfile.setUser(user);
        return companyProfile;
    }
    public void deleteCompanyProfile(Integer userId) {
        User userById = userRepository.findUserById(userId);
        companyProfileRepository.deleteCompanyProfile(userById);
    }
}
