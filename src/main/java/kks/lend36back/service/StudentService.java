package kks.lend36back.service;


import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.infrastructure.exception.ForbiddenException;
import kks.lend36back.persistence.groupemail.GroupEmail;
import kks.lend36back.persistence.groupemail.GroupEmailRepository;
import kks.lend36back.persistence.role.Role;
import kks.lend36back.persistence.role.RoleRepository;
import kks.lend36back.persistence.student_profile.StudentProfile;
import kks.lend36back.persistence.student_profile.StudentProfileMapper;
import kks.lend36back.persistence.student_profile.StudentProfileRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserMapper;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.persistence.user_group.UserGroup;
import kks.lend36back.persistence.user_group.UserGroupRepository;
import kks.lend36back.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static kks.lend36back.infrastructure.Error.INCORRECT_EMAIL;
import static kks.lend36back.status.Status.ACTIVE;

@Service
@RequiredArgsConstructor
public class StudentService {

    public static final int ROLE_STUDENT = 2;

    private final RoleRepository roleRepository;
    private final GroupEmailRepository groupEmailRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final StudentProfileMapper studentProfileMapper;
    private final UserGroupRepository userGroupRepository;


    @Transactional
    public void addNewStudent(NewStudent newStudent) {

        GroupEmail groupEmail = groupEmailRepository.findByEmail(newStudent.getEmail(), Status.PENDING.getCode())
                .orElseThrow(() -> new ForbiddenException(INCORRECT_EMAIL.getMessage(), INCORRECT_EMAIL.getErrorCode()));
        // todo: promt kui kasutaja on juba registreeritud
        Role role = roleRepository.getReferenceById(ROLE_STUDENT);
        User user = userMapper.toUser(newStudent);

        user.setRole(role);

        user.setStatus(ACTIVE.getCode());

        userRepository.save(user);

       /* StudentProfile studentProfile = studentProfileMapper.toStudentProfile(new StudentProfileDto());
        studentProfile.setUser(user);

        studentProfileRepository.save(studentProfile);
*/
        UserGroup userGroup = new UserGroup();
        userGroup.setGroup(groupEmail.getGroup());
        userGroup.setUser(user);
        userGroupRepository.save(userGroup);

        groupEmail.setStatus(ACTIVE.getCode());
        groupEmailRepository.save(groupEmail);


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
}


/*
    public void addStudentName(StudentProfileDto studentProfileDto, User user){
        StudentProfile studentProfile = createStudentProfile(studentProfileDto, user);
        studentProfileRepository.save(studentProfile);
    }
    private StudentProfile  createStudentProfile (StudentProfileDto studentProfileDto, User user) {
        StudentProfile studentProfile = studentProfileMapper.toStudentProfile(studentProfileDto);
        studentProfile.setUser(user);
        return studentProfile;

    }
*/