package kks.lend36back.controller.preferred_city;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kks.lend36back.controller.preferred_city.dto.CityDto;
import kks.lend36back.service.PreferredCityService;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/student")
public class PreferredCityController {
    private final PreferredCityService preferredCityService;

    @PostMapping("/preferred-city")
    @Operation(summary = "lisab eelistatud linna(d) oma profiilile")

    public void addPreferredCity(@RequestBody User user @RequestParam @Valid CityDto cityDto){


    }


}
