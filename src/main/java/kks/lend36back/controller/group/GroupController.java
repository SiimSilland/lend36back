package kks.lend36back.controller.group;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.group.dto.GroupInfo;
import kks.lend36back.controller.group.dto.NewGroup;
import kks.lend36back.controller.group.dto.NewGroupEmail;
import kks.lend36back.controller.student.dto.NameToStudentProfileDto;
import kks.lend36back.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Operation(summary = "lisab ees ja perekonnanime student_profile tabelisse")
    public void addStudentName(@RequestBody NameToStudentProfileDto nameToStudentProfileDto, @RequestParam Long userId) {
        groupService.addStudentName(nameToStudentProfileDto, userId);
    }

    @GetMapping("/groups")
    public List<GroupInfo> getAllActiveGroups() {
        List<GroupInfo> allActiveGroups = groupService.getAllActiveGroups();
        return allActiveGroups;
    }

}

