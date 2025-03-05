package kks.lend36back.service;

import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.controller.company.dto.NewCompanyProfile;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.persistence.company_profile.CompanyProfileMapper;
import kks.lend36back.persistence.company_profile.CompanyProfileRepository;
import kks.lend36back.persistence.role.Role;
import kks.lend36back.persistence.role.RoleRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserMapper;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
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
    public void addNewCompany(NewCompany newCompany) {
        Role role = roleRepository.getReferenceById(ROLE_COMPANY);
        User user = userMapper.toUser(newCompany);
        user.setRole(role);
        userRepository.save(user);

        CompanyProfile companyProfile = companyProfileMapper.toCompanyProfile(newCompany);
        companyProfile.setUser(user);
        companyProfileRepository.save(companyProfile);
    }

    public List<NewCompanyProfile> getCompanyProfile() {
        List<CompanyProfile> AllCompanyProfiles = companyProfileRepository.findAll();
        List<NewCompanyProfile> companyProfiles = companyProfileMapper.toCompanyProfiles(AllCompanyProfiles);
        return companyProfiles;
    }

    public void updateCompanyProfile(NewCompanyProfile newCompanyProfile) {
        CompanyProfile companyProfile = CompanyProfileMapper.toCompanyProfiles(newCompanyProfile);
        companyProfile.setCompanyprofile(companyProfile);
        companyProfileRepository.save(newCompanyProfile);
    }
}
   /* public void updateCompanyProfile(NewCompanyProfile newCompanyProfile, NewCompany newCompany) {
        Role role = roleRepository.getReferenceById(ROLE_COMPANY);
        User user = userMapper.toUser(newCompany);
        user.setRole(role);
        userRepository.save(user);
    }
}


   /*1 public void updateCompanyProfile(NewCompanyProfile newCompanyProfile) {
        CompanyProfile companyProfile = createProfile

    }
}
*/