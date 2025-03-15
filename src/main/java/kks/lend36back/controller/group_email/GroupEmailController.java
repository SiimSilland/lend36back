package kks.lend36back.controller.group_email;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.group_email.dto.GroupEmailInfo;
import kks.lend36back.service.GroupEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class GroupEmailController {
    private final GroupEmailService groupEmailService;

    @GetMapping("/group-email")
    @Operation(summary = "Toob ära kõikide aktiivsete lendude õppurid staatustega (kas A-active või P-pending")
    public List<GroupEmailInfo> getGroupEmails(@RequestParam Integer groupId) {
        return groupEmailService.getGroupEmails(groupId);
    }

    @DeleteMapping("/delete-group-email")
    @Operation(summary = "Kustutab lennust õppuri")
    public void deleteGroupEmail(@RequestParam String email) {
        groupEmailService.deleteGroupEmail(email);
    }
}

