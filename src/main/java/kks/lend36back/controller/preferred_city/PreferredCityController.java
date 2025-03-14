package kks.lend36back.controller.preferred_city;

import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.preferred_city.dto.PreferredCityDto;
import kks.lend36back.persistence.preferred_city.PreferredCity;
import kks.lend36back.service.PreferredCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/preferred-city")
public class PreferredCityController {
    private final PreferredCityService preferredCityService;

    @PostMapping("/city")
    @Operation(summary = " Võtab userId ja cityId ning seob need kokku")

    public void addPreferredCity(@RequestParam Integer userId, @RequestParam Integer cityId) {
        preferredCityService.addPreferredCity(userId, cityId);
    }

    @DeleteMapping("/city")
    @Operation (summary = "eemaldab cityId selle userId alt")
    public void deletePreferredCity(@RequestParam Integer userId, @RequestParam Integer cityId) {
        preferredCityService.deletePreferredCity(userId, cityId);
    }

    @PutMapping("/city")
    @Operation(summary = "uuendab linnade nimekirja")
    public void updatePreferredCity(@RequestParam Integer userId, @RequestParam Integer cityId) {
    }

    @GetMapping("city")
    @Operation(summary = "toob ära linnad userId järgi")
    public List<PreferredCityDto> getAllPreferredCities(Integer userId){
         return preferredCityService.getAllPreferredCities(userId);
    }

}




