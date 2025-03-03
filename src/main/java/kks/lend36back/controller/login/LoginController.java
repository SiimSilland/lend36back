package kks.lend36back.controller.login;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    public void login(@RequestParam String email, @RequestParam String password) {
        loginService.login(email, password);
    }

}
