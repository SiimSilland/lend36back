
package kks.lend36back.service;

import kks.lend36back.controller.company.dto.NewCompanyDto;
import kks.lend36back.controller.company.dto.NewCompanyProfileDto;
import kks.lend36back.infrastructure.exception.DuplicationResourceException;
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
import org.springframework.transaction.annotation.Transactional;

import static kks.lend36back.infrastructure.Error.COMPANY_NUMBER_IN_USE;

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
}

/*private StudentProfile createStudentProfile(NameToStudentProfileDto nameToStudentProfileDto, User user) {
        StudentProfile studentProfile = studentProfileMapper.nameToStudentProfile(nameToStudentProfileDto);
        studentProfile.setUser(user);

        // Ensure email is not null if required
        if (studentProfile.getEmail() == null) {
            studentProfile.setEmail(""); // Set empty string or default value
        }

        return studentProfile;
    }

private CompanyProfile createCompanyProfile (@Valid  NewCompanyProfileDto newCompanyProfileDto, User user) {

    }public void addNewInternship (InternshipDto internshipDto) {
    Integer companyUserId = internshipDto.getCompanyUserId();
    User companyUser = userRepository.findById(companyUserId)
            .orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("companyUserId", companyUserId));
    Internship internship = internshipMapper.toInternship(internshipDto);
    internship.setCompanyUser(companyUser);
    internship.setStatus("A");
    internshipRepository.save(internship);

     public void addStudentName(NameToStudentProfileDto nameToStudentProfileDto, User user) {
        StudentProfile studentProfile = createStudentProfile(nameToStudentProfileDto, user);
        studentProfileRepository.save(studentProfile);
    }

    private StudentProfile createStudentProfile(NameToStudentProfileDto nameToStudentProfileDto, User user) {
        StudentProfile studentProfile = studentProfileMapper.nameToStudentProfile(nameToStudentProfileDto);
        studentProfile.setUser(user);

        // Ensure email is not null if required
        if (studentProfile.getEmail() == null) {
            studentProfile.setEmail(""); // Set empty string or default value
        }
        return studentProfile;
    }
public void createAndSaveStudentProfile(@Valid StudentProfileDto studentProfileDto, Integer userId) {
            User user = (User) userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
            StudentProfile studentProfile = createStudentProfile (studentProfileDto, user);
        studentProfileRepository.save(studentProfile);
    }
    private StudentProfile createStudentProfile (StudentProfileDto studentProfileDto, User user){
        StudentProfile studentProfile = studentProfileMapper.toStudentProfile(studentProfileDto);
        studentProfile.setUser(user);
        return studentProfile;

    }

    */