package kks.lend36back.controller.city;


import io.swagger.v3.oas.annotations.Operation;
import kks.lend36back.controller.city.dto.CityList;
import kks.lend36back.persistence.city.City;
import kks.lend36back.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/cities")
    @Operation(summary = "toob andmebaasist kõik linnad",
    description = "tagastab linnad koos cityId ja cityName'ga")
    List<CityList> cityList =cityService.getCities();
    return cityList;


}
