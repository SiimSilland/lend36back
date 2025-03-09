package kks.lend36back.controller.city.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kks.lend36back.persistence.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityList implements Serializable {
    private Integer cityId;
    private String cityName;
}