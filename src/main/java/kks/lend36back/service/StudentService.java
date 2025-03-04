package kks.lend36back.service;

import jakarta.validation.Valid;
import kks.lend36back.controller.student.dto.NewStudent;
import kks.lend36back.infrastructure.Error;
import kks.lend36back.infrastructure.exception.ForbiddenException;
import kks.lend36back.persistence.group_email.GroupEmail;
import kks.lend36back.persistence.group_email.GroupEmailRepository;
import kks.lend36back.persistence.role.Role;
import kks.lend36back.persistence.role.RoleRepository;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static kks.lend36back.infrastructure.Error.INCORRECT_EMAIL;

@Service
@RequiredArgsConstructor
public class StudentService {

    public static final int ROLE_STUDENT = 2;

    private final RoleRepository roleRepository;
    private final GroupEmailRepository groupEmailRepository;
    private final UserMapper userMapper;

    public void addNewStudent(NewStudent newStudent) {

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


        // todo: role ei saa mapperiga külge panna, see tuleb ise peale mäppimist käsitsi külge panna
        // todo: user objekt tuleb siis amndmebaasi ära salvestada
        // todo: peale salvestamist on see user objekt ise foreign key järgmise tabeli kandele
        // todo: peale salvestamist on see user objekt ise foreign key järgmise tabeli kandele

        // todo: siis oleks vaja lisada uus rida student_profile tabelisse

        // todo: selleks on meil vaja uut student_profile enityti objekti

        // todo: meil on juba olemas 3- väljaga andmed group_email entity objektis

        // todo: Meil oleks mõistilik see student_profile enityti objekt luua mapperi abil
        //  kasutades seda olemasolevat group_email entity objekti ja tyhjade stringide jaoks constanti

        // todo: user infot ei saa mapperiga panna, see tuleb ise panna student_profile'ile peale mäppimist käsitsi külge

        // todo: peale seda saab student_profile rea ära salvestada

        // todo: peale seda saab student_profile rea ära salvestada

        // todo: nüüd on vaja salvestada uus õpilane user_group tabelisse
        // todo:on vaja luua uus user_group objekt (seda teha käsitsi()

        // todo: selleks on vaja user objekti (entity) ja group objekti (enityt),
        // todo: group objekti (enityt) saab kenasti group_email objekti küljest

        // todo: kui user aja group objektid on olamas ja pandud user_group objekti külge

        // todo: siis see rida ära salvestada

        // todo: FINITO! :)




















    }
}
