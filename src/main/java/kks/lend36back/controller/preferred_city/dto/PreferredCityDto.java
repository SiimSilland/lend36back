package kks.lend36back.controller.preferred_city.dto;

import kks.lend36back.persistence.preferred_city.PreferredCity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link PreferredCity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferredCityDto implements Serializable {
    private Integer userId;
    private Integer cityId;
}