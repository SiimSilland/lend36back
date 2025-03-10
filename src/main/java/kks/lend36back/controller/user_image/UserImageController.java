package kks.lend36back.controller.user_image;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.user_image.dto.UserImageDto;
import kks.lend36back.service.UserImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserImageController {
    private final UserImageService userImageService;

    @PostMapping("/image")
    @Operation(summary = "lisab kasutaja pildi")

    public void addUserImage(@RequestBody UserImageDto userImageDto) {
        userImageService.addUserImage(userImageDto);
    }

}
