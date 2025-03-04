package kks.lend36back.service;

import kks.lend36back.controller.company.dto.NewCompany;
import kks.lend36back.persistence.company_profile.CompanyProfile;
import kks.lend36back.persistence.company_profile.CompanyProfileMapper;
import kks.lend36back.persistence.company_profile.CompanyProfileRepository;
import kks.lend36back.persistence.role.Role;
import kks.lend36back.persistence.role.RoleRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserMapper;
import kks.lend36back.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapping;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    public static final int ROLE_COMPANY = 3;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final CompanyProfileMapper companyProfileMapper;
    private final CompanyProfileRepository companyProfileRepository;


    public void addNewCompany(NewCompany newCompany) {
        User user = createAnSaveCompany(NewCompany);
        creatAndSaveNewCompanyProfile(newCompany, user);
    }
    private User createAnSaveCompany(NewCompany newCompany) {
        User user = createCompany(newCompany);
        userRepository.save(user);
        return user;
    }
    private User createCompany(NewCompany newCompany) {
        Role role = roleRepository.getReferenceById(ROLE_COMPANY);
        User user = userMapper.newCompanyToUser(newCompany);
        user.setRole(role);
        return user;
    }
    private void creatAndSaveNewCompanyProfile(NewCompany newCompany, User user) {
        CompanyProfile companyProfile = createProfile(newCompany, user);
        companyProfileRepository.save(companyProfile);
    }

    private CompanyProfile createProfile(NewCompany newCompany, User user) {
        CompanyProfile companyProfile = companyProfileMapper.toCompanyProfile(newCompany);
        companyProfile.setUser(user);
        return companyProfile;
    }
}
/*/    
        role = roleRepository.getReferenceById(ROLE_COMPANY);

        User user = userMapper.newCompanyToUser(newCompany);
        user.setRole(role);
        userRepository.set(user);

        private void createAndSaveProfile(NewUser newUser, User user) {
            Profile profile = createProfile(newUser, user);
            profileRepository.save(profile);
        }

        private Profile createProfile(NewUser newUser, User user) {
            Profile profile = profileMapper.toProfile(newUser);
            profile.setUser(user);
            return profile;
        }
       /* CompanyProfile companyProfile =  companyProfileMapper.toCompanyProfile(newCompany);
        companyProfile = companyProfileRepository.getReferenceById(ROLE_COMPANY);
        user.setRole(role);
       userRepository.save(user);
       @Mapping(source = "id", target = "id")
    void idToCompanyProfile (User user);
       */
    
    

/*public void addNewUser(NewUser newUser) {
    User user = createAndSaveUser(newUser);
    createAndSaveProfile(newUser, user);
}

private User createAndSaveUser(NewUser newUser) {
    User user = createUser(newUser);
    userRepository.save(user);
    return user;
}

private User createUser(NewUser newUser) {
    Role role = roleRepository.getReferenceById(ROLE_CUSTOMER);
    User user = userMapper.toUser(newUser);
    user.setRole(role);
    return user;
}

private void createAndSaveProfile(NewUser newUser, User user) {
    Profile profile = createProfile(newUser, user);
    profileRepository.save(profile);
}

private Profile createProfile(NewUser newUser, User user) {
    Profile profile = profileMapper.toProfile(newUser);
    profile.setUser(user);
    return profile;
}

    /*public void addNewStudent(NewStudent newStudent) {
        // todo: otsi tabelist ülesse group email rida (sisse tulnud emaili abil)
        Optional<GroupEmail> optionalGroupEmail = groupEmailRepository.findByEmail(newStudent.getEmail());
        // todo: selle saad entity objektina!!!!!!!
        GroupEmail groupEmail = optionalGroupEmail.orElseThrow(() ->
                new ForbiddenException(INCORRECT_EMAIL.getMessage(), INCORRECT_EMAIL.getErrorCode()));
        // todo: kui aga ei saanud seda ride, siis veateade "Sellist student emaili ei saa...:
        // todo: kui saime, siis saame edasi liikuda
        //email, password, status > muuda status ära GroupEmail'is ning User'is.

        User user = userMapper.newStudentToUser(newStudent);

        // todo: meil on vaja nüüd kõige peaalt lisada uus rida (entoity objekt) user tablisse
        // todo: selle rea entity objektida saaks luua mapperi abil

        Role role = roleRepository.getReferenceById(ROLE_STUDENT);
        user.setRole(role);


*/