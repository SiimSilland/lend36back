package kks.lend36back.controller.group;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.controller.student.dto.StudentProfileDto;
import kks.lend36back.controller.student.dto.StudentProfileRequest;
import kks.lend36back.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class GroupController {
    private final GroupService groupService;


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
    @Operation(summary = "lisab ees ja perekkonnanime proofili tabeliss")
    public void addStudentName(@RequestBody StudentProfileDto studentProfileDto) {
        groupService.addStudentName(studentProfileDto);
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

}*/
