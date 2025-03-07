package kks.lend36back.controller.student;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.student.dto.NewCv;
import kks.lend36back.persistence.cv.Cv;
import kks.lend36back.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pdf")
public class PageController {

    private final PageService pageService;


    @PostMapping("/student")
    @Operation(summary = "lisab CV")
    public void addCv(@RequestBody Cv cv){
        pageService.
    }


}
