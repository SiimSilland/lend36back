package kks.lend36back.controller.group;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.controller.student.dto.NameToStudentProfileDto;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.persistence.user.User;
import kks.lend36back.persistence.user.UserRepository;
import kks.lend36back.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class GroupController {
    private final GroupService groupService;
    private final UserRepository userRepository;


    @PostMapping ("/group")
    @Operation (summary = "lisab uue lennu/")
    public void addNewGroup (@RequestBody NewGroup newGroup) {
        groupService.addNewGroup(newGroup);
    }

    @PostMapping ("/group-email")
    @Operation (summary = "Lisab uue õpilase emaili lubatud õpilaste registreerimiseks")
    public void addGroupEmail(@RequestBody @Valid NewGroupEmail newGroupEmail) {
        groupService.addGroupEmail(newGroupEmail);

    }

    @PostMapping("/student/profile")
    @Operation(summary = "lisab ees ja perekonnanime student_profile tabelisse")
    public void addStudentName(@RequestBody NameToStudentProfileDto nameToStudentProfileDto, @RequestParam Long userId) {
       User user = userRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        groupService.addStudentName(nameToStudentProfileDto, user);
    }
}

/*@PostMapping("/student/profile")
@Operation (summary = "lisab ees ja perekkonnanime proofili tabeliss")
public void addStudentName(@RequestBody StudentProfileDto studentProfileDto) {
    groupService.addStudentName(studentProfileDto);

    @PostMapping("/student/profile")
    @Operation(summary = "lisab ees ja perekkonnanime proofili tabeliss")
    public void addStudentName(@RequestBody StudentProfileRequest request) {
        groupService.addStudentName(request.getStudentProfileDto(), request.getUser().getId());

@PostMapping("/student/profile")
@Operation(summary = "lisab ees ja perekkonnanime proofili tabelisse")
public void addStudentName(@RequestBody StudentProfileDto studentProfileDto,  {

}
}*/
