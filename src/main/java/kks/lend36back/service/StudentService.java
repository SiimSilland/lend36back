package kks.lend36back.service;


import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.infrastructure.exception.ForbiddenException;
import kks.lend36back.persistence.group.Group;
import kks.lend36back.persistence.group_email.GroupEmail;
import kks.lend36back.persistence.group_email.GroupEmailRepository;
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
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static kks.lend36back.infrastructure.Error.INCORRECT_EMAIL;

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

// todo: tee transactional

    public void addNewStudent(NewStudent newStudent) {
        // todo: otsi tabelist ülesse group email rida (sisse tulnud emaili abil)
        // todo: selle saad entity objektina!!!!!!!
        // todo: kui aga ei saanud seda ride, siis veateade "Sellist student emaili ei saa...:
        // todo: kui saime, siis saame edasi liikuda
        GroupEmail groupEmail = groupEmailRepository.findByEmail(newStudent.getEmail(), Status.PENDING.getCode())
                .orElseThrow(() -> new ForbiddenException(INCORRECT_EMAIL.getMessage(), INCORRECT_EMAIL.getErrorCode()));

        // todo: (Siimu lisatud)siin on puudu staatuse kontrolli vastus. kui staatus on groupEmailis A, siis peaks user juba registreeritud olema.

        // todo: role ei saa mapperiga külge panna, see tuleb kõige pealt andmebaasist üles leida
        Role role = roleRepository.getReferenceById(ROLE_STUDENT);

        // todo: meil on vaja nüüd kõige peaalt lisada uus rida (entoity objekt) 'user' tablisse
        // todo: selle rea entity objektida saaks luua mapperi abil
        User user = userMapper.newStudentToUser(newStudent);
        // todo: kuna role ei saa mapperiga külge panna, see tuleb ise peale mäppimist käsitsi külge panna
        user.setRole(role);

        // todo: user objekt tuleb siis amndmebaasi ära salvestada
        // todo: peale salvestamist on see user objekt ise foreign key järgmise tabeli kandele
        user.setStatus("A");

        userRepository.save(user);

        // todo: siis oleks vaja lisada uus rida student_profile tabelisse
        // todo: selleks on meil vaja uut student_profile enityti objekti
        // todo: meil on juba olemas 3- väljaga andmed group_email entity objektis

        // todo: Meil oleks mõistilik see student_profile enityti objekt luua mapperi abil
        //  kasutades seda olemasolevat group_email entity objekti ja tyhjade stringide jaoks constanti

//        @Mapping(source = "EI SAA MÄPPIDA", target = "user")
        StudentProfile studentProfile = studentProfileMapper.toStudentProfile(groupEmail);
        studentProfile.setUser(user);
        // todo: peale seda saab student_profile rea ära salvestada
        studentProfileRepository.save(studentProfile);

        // todo: nüüd on vaja salvestada uus õpilane user_group tabelisse

        UserGroup userGroup = new UserGroup();
        userGroup.setGroup(groupEmail.getGroup());
        userGroup.setUser(user);
        userGroupRepository.save(userGroup);

        // todo: selleks on vaja tekitada seostablisse user_group üks uus rida
        // todo: user_group rida võtab sisse sisuliselt ainult foreign keyd
        // todo: meil ei ole mõsitlik luua selle rea objekto loomiseks juurde üht mäpperit
        // todo: lihtsam on ise teha juurde üks UUS (new) user_group objekt
        //  ja panna setteritega külge vajalikud foreign key objecktid
        //  Group foreing key saate 'groupEmail' objekti seest
        // todo: ning siis see rida ära salvestada

        // todo: Viimase sammuna on vaha muuta ära groupEmail objekti sees tema status from P to A
        // todo: see satuse muudatus tuleb ka andmebaasi ära salvestada

        // FINITO

    }
}
