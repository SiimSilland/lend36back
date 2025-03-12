package kks.lend36back.controller.internship;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.internship.dto.InternshipDto;
import kks.lend36back.service.InternshipService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor

public class InternshipController {
    private final InternshipService internshipService;

    @PostMapping("/company/internship")
    @Operation(summary = "lisab uue praktikakoha ja uuendab juhendaja andmeid/")
    public void addNewInternship (@RequestBody InternshipDto internshipDto) {
        internshipService.addNewInternship(internshipDto);
    }
}
