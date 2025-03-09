package kks.lend36back.persistence.city;

import kks.lend36back.controller.city.dto.CityList;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {

    List<CityList> toCityList (List<City> cities);


}