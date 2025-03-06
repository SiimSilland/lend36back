package kks.lend36back.controller.student;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.student.dto.NewCv;
import kks.lend36back.service.PageService;
import kks.lend36back.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PageController {
    private final PageService pageService;

    @PostMapping("/student")
    @Operation (summary = "lisab CV")
    public void addCv (@RequestBody @Valid NewCv newCv)
     {pageService.addCv(newCv);}


}
