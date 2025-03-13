package kks.lend36back.controller.user_image;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.user_image.dto.UserImageDto;
import kks.lend36back.service.UserImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserImageController {
    private final UserImageService userImageService;

    @PostMapping("/image")
    @Operation(summary = "lisab kasutaja pildi")
    public void addUserImage(@RequestBody UserImageDto userImageDto) {
        userImageService.addUserImage(userImageDto);
    }

    @DeleteMapping("/image")
    @Operation(summary = "kustutab kasutaja pildi")
    public void deleteUserImage(@RequestParam Integer userId) {
        userImageService.deleteUserImage(userId);
    }

    @GetMapping("/image")
    public UserImageDto getUserImage(@RequestParam Integer userId){
        UserImageDto userImageDto = userImageService.getUserImage(userId);
        return userImageDto;
    }



}
