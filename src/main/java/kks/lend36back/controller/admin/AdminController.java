package kks.lend36back.controller.admin;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.admin.dto.NewGroup;
import kks.lend36back.controller.admin.dto.AddStudent;
import kks.lend36back.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class AdminController {
    private final AdminService adminService;

    @PostMapping ("/admin")
    @Operation (summary = "lisab uue lennu/")
    public void addNewGroup (@RequestBody NewGroup newGroup) {
        adminService.addNewGroup(newGroup);
    };


    @PostMapping ("/admin/student")
    @Operation (summary = "lisab uue õpilase")
    public void addNewStudentToGroup(@RequestBody AddStudent addStudent) {
        adminService.addNewStudentToGroup(addStudent);
    }
}

