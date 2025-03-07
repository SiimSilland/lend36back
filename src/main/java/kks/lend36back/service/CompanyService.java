
package kks.lend36back.service;

import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfileDto;
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
import org.springframework.stereotype.Service;

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

    public void updateCompanyProfile(Integer userId, NewCompanyProfileDto newCompanyProfile) {
      CompanyProfile companyProfile = companyProfileRepository.findProfileBy(userId)
        .orElseThrow(() -> ValidationService.throwPrimaryKeyNotFoundException("userId", userId));

// Update only non-null fields
    companyProfileMapper.updateCompanyProfile(newCompanyProfile, companyProfile);
    companyProfileRepository.save(companyProfile);
}
}