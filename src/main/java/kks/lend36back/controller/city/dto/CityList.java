package kks.lend36back.controller.city.dto;

import kks.lend36back.persistence.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityList {
    private Integer cityId;
    private String cityName;
}