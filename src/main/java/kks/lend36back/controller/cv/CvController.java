package kks.lend36back.controller.cv;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.cv.dto.CvDto;
import kks.lend36back.service.CvService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CvController {
    private final CvService cvService;


    @PostMapping("/cv")
    @Operation(summary = "lisab CV")
    public void addCv(@RequestBody CvDto cvDto) {
        cvService.addCV(cvDto);
    }

    @DeleteMapping("/delete-cv")
    @Operation(summary = "kustutab kasutaja cv")
    public void deleteCv (@RequestParam Integer userId) {
        cvService.deleteCv(userId);
    }
}
