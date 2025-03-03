package kks.lend36back.controller.login;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.login.dto.LoginResponse;
import kks.lend36back.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Sisselogimine. Tagastab userId , roleName")
   // @ApiResponses( value = {
          //  @ApiResponse(responseCode = "200", description = "OK"),
          //  @ApiResponse(responseCode = "403", description = "Vale kasutajanimi või parool"})
                    //content = @Content(schema = @Schema(implementation = ApiError.class)))}

    public LoginResponse login(@RequestParam String email, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(email, password);
        return loginResponse;
    }

}
