package kks.lend36back.controller.user;

import jakarta.validation.Valid;
import kks.lend36back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    public void addNewUser(@RequestBody @Valid NewUser newUser){
        userService.addNewUser(newUser);
    }

}
