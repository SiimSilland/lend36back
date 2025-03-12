package kks.lend36back.service;



import jakarta.persistence.EntityNotFoundException;
import kks.lend36back.controller.group.dto.GroupInfo;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.controller.student.dto.NameToStudentProfileDto;
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
import kks.lend36back.status.Status;
import kks.lend36back.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    }
    public void addStudentName(NameToStudentProfileDto nameToStudentProfileDto, Long userId) {
        User user = userRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        StudentProfile studentProfile = createStudentProfile(nameToStudentProfileDto, user);
        studentProfileRepository.save(studentProfile);
    }

    public List<GroupInfo> getAllActiveGroups() {
        List<Group> groups = groupRepository.findGroupsBy(Status.ACTIVE.getCode());
        List<GroupInfo> groupInfos = groupMapper.toGroupInfos(groups);
        return groupInfos;
    }

    private StudentProfile createStudentProfile(NameToStudentProfileDto nameToStudentProfileDto, User user) {
        StudentProfile studentProfile = studentProfileMapper.nameToStudentProfile(nameToStudentProfileDto);
        studentProfile.setUser(user);
        if (studentProfile.getEmail() == null) {
            studentProfile.setEmail("");
        }
        return studentProfile;
    }


}