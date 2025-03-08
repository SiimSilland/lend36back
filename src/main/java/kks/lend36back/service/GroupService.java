package kks.lend36back.service;



import jakarta.persistence.EntityNotFoundException;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.persistence.group.Group;
import kks.lend36back.persistence.group.GroupMapper;
import kks.lend36back.persistence.group.GroupRepository;
import kks.lend36back.persistence.groupemail.GroupEmail;
import kks.lend36back.persistence.groupemail.GroupEmailMapper;
import kks.lend36back.persistence.groupemail.GroupEmailRepository;
import kks.lend36back.persistence.student_profile.StudentProfile;
import kks.lend36back.persistence.student_profile.StudentProfileMapper;
import kks.lend36back.persistence.student_profile.StudentProfileRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static kks.lend36back.status.Status.PENDING;


@Service
@RequiredArgsConstructor

public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GroupEmailRepository groupEmailRepository;
    private final GroupEmailMapper groupEmailMapper;
    private final StudentProfileMapper studentProfileMapper;
    private final StudentProfileRepository studentProfileRepository;
    private final UserRepository userRepository;

    // Todo: transactional
    public void addNewGroup (NewGroup newGroup){
        Group group = groupMapper.toGroup(newGroup);
        //GroupEmail newRow = groupEmailMapper.toGroupEmail(newGroup);
        groupRepository.save(group);

    }

    public void addGroupEmail(NewGroupEmail newGroupEmail) {
        Integer groupId = newGroupEmail.getGroupId();

        // Ei saa MÄPPIDA FOREIGN KEYD @Mapping(source = "", target = "groupId")
        Group group = groupRepository.findById(groupId).orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("groupId", groupId));
        GroupEmail groupEmail = groupEmailMapper.toGroupEmail(newGroupEmail);
        groupEmail.setGroup(group);
        groupEmail.setStatus(PENDING.getCode());
        groupEmailRepository.save(groupEmail);



        // @Mapping(constant = "EI SAA MÄPPIDA", target = "groupNumber")

        //GroupEmail groupEmail = groupEmailMapper.toGroupEmail(newGroupEmail);
        //groupEmail.setGroup(group);
        //groupEmail.setGroupNumber();

        //groupEmail.setStatus(PENDING.getCode());

        // Ei saa MÄPPIDA @Mapping(source = "", target = "status")
        // Ei saa MäPPIDA @Mapping(source = "", target = "groupNumber")


       // groupEmailRepository.save(groupEmail);

        /*public void addStudentName(StudentProfileDto studentProfileDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        StudentProfile studentProfile = studentProfileMapper.toStudentProfile(studentProfileDto);
        studentProfile.setUser(user);
        studentProfileRepository.save(studentProfile);
         */

    }
    public void addStudentName(StudentProfileDto studentProfileDto, User user){
        StudentProfile studentProfile = createStudentProfile(studentProfileDto, user);
        studentProfileRepository.save(studentProfile);
    }
    private StudentProfile  createStudentProfile (StudentProfileDto studentProfileDto, User user) {
        StudentProfile studentProfile = studentProfileMapper.toStudentProfile(studentProfileDto);
        studentProfile.setUser(user);
        return studentProfile;

    }

    public void addStudentName(StudentProfileDto studentProfileDto) {

    }
}

