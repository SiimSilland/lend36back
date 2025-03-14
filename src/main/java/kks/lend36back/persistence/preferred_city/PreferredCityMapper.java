package kks.lend36back.persistence.preferred_city;

import kks.lend36back.controller.preferred_city.dto.PreferredCityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PreferredCityMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "city.id", target = "cityId")
    PreferredCityDto toPreferredCityDto (PreferredCity preferredCity);

    List<PreferredCityDto> toPreferredCityDto (List<PreferredCity>preferredCityList);

}