package kks.lend36back.controller.group_email;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.group_email.dto.GroupEmailInfo;
import kks.lend36back.service.GroupEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}

