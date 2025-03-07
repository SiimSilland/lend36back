package kks.lend36back.controller.preferred_city;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.preferred_city.dto.CityDto;
import kks.lend36back.service.PreferredCityService;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/preferred-city")
public class PreferredCityController {
    private final PreferredCityService preferredCityService;

    @PostMapping("/select")
    @Operation(summary = "lisab eelistatud linna(d) oma profiilile")

    public void addPreferredCity(@RequestParam Integer userId, @RequestParam Integer cityId){
         preferredCityService.addPreferredCity(userId, cityId);
            }

    @PostMapping("/update")
    @Operation(summary = "uuendab linnade nimekirja")
    public void updatePreferredCity(@RequestParam Integer userId, @RequestParam Integer cityId){

    }


}




