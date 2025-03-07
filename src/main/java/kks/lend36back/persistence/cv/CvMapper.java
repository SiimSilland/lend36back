package kks.lend36back.persistence.cv;

import kks.lend36back.controller.cv.dto.CvDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface CvMapper {
    @Mapping(source = "userId", target = "user.id")
    Cv toEntity(CvDto cvDto);

    @Mapping(source = "user.id", target = "userId")
    CvDto toDto(Cv cv);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
            @Mapping(source = "userId", target = "user.id")
    Cv partialUpdate(CvDto cvDto, @MappingTarget Cv cv);
}